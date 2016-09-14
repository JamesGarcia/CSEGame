package mainGame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JFrame;

import mainGame.Graphics.Sprite;
import mainGame.Levels.CharacterCreation;
import mainGame.Levels.LevelInit;
import mainGame.Levels.LevelManager;
import mainGame.Levels.Menu;
import mainGame.Levels.PlayerTempVars;
import mainGame.Levels.State;

public class Game extends Canvas implements Runnable 
{
	private static final long serialVersionUID = 1323874629845200729L;
	public static final int TileSize=32;
	public static final int TilesWide=48;//16*3
	public static final int TilesHigh=27;//9*3
	public static final int HUDHeight=64;
	
	/** game resolution */
	//16X9 without HUD
	public static final int WIDTH = TilesWide*TileSize+6;//1536
	public static final int HEIGHT = TilesHigh*TileSize+HUDHeight+3;//928
	public static final int PlayWidth = TilesWide*TileSize;
	public static final int PlayHeight = TilesHigh*TileSize+HUDHeight;
	
	
	/** THREADING - single threaded game */
	private Thread thread;
	/** is the thread on (running) or off */
	private boolean running = false;
	
	private Handler handler;
	private HUD hud;
	
	public static Menu menu;
	public static CharacterCreation charCreate;
	
	private KeyInput keyInput;
	
	public Window screen=null;
	public JFrame frame=new JFrame("TITLE");
	public Canvas c=this;
	
	public static boolean end;
	public static State GameState = State.menu;
	public static int Level = 0;
	public static int CurLevel=0;
	public static PlayerTempVars PTVars;
	
	//* system metrics */
	public static int FPS;	
	public static long PlayStartTime=System.currentTimeMillis();
	public static long PlayTimeSecs=0;
	public static long LevelStartTime=System.currentTimeMillis();
	public static long LevelTimeSecs=0;
	
	public Game() 
	{
		handler = new Handler();
		PTVars=new PlayerTempVars();
		
		menu=new Menu(this,handler,PTVars);
		charCreate=new CharacterCreation(this,handler);
		
		keyInput = new KeyInput(handler);
		this.addKeyListener(keyInput);
		this.addMouseListener(menu);
		this.addMouseListener(charCreate);
		
		AudioPlayer.load("zelda","trk1");								//audio no work
		AudioPlayer.getMusic("trk1").setVolume(0.1f);					//audio no work
		AudioPlayer.getMusic("trk1").loop(.9f, .1f);					//audio no work
		AudioPlayer.load("queen", "trk0");								//audio no work
		
		AudioPlayer.getMusic("trk1").loop();							//audio no work
		
	//	AudioPlayer.load("music");				test - nouse
	//	AudioPlayer.getMusic("music").loop();
		
		try 
		{
			screen=new Window(frame, this);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		hud = new HUD();
	}
	
	@SuppressWarnings("unused")
	private void sleep() {
		try {
			Thread.sleep(10);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/** @run
	* FPS lock, makes sure game
	* is running at normal speed
	*/
	@SuppressWarnings("unused")
	public void run() 
	{
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (running) 
		{
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) 
			{
				tick();
				delta--;
			}
			if (running)
				render();
			frames++;
			
			if (System.currentTimeMillis() - timer > 1000) 
			{
				timer += 1000;
				//System.out.println("FPS: " + frames);
				FPS=frames;
				frames = 0;
			}
		}
		stop();
	}
	
	private void tick() 
	{
		if(PlayTimeSecs<(System.currentTimeMillis()-PlayStartTime)/1000)
			PlayTimeSecs++;
		if(LevelTimeSecs<(System.currentTimeMillis()-LevelStartTime)/1000)
			LevelTimeSecs++;
		
		handler.tick();
		//hud.tick();
		if(GameState==State.game)
		{
			if(CurLevel<Level)
			{
				while(CurLevel<Level)
					CurLevel++;
				LevelManager.changeLevels(handler);
				LevelTimeSecs=0;
			}
			
			for (int i = 0; i < handler.object.size(); i++) 
			{
				Action.EndGame(handler);
				GameObject tempObject = handler.object.get(i);
				if (tempObject.getId() == ID.Player) 
				{
					hud.tick(tempObject.getHealth(),tempObject.cashMoney,tempObject.mana);
					Action.PlayerAction(handler, tempObject, keyInput);
					Action.interact(tempObject.getX(), tempObject.getY(), tempObject.getDir(), keyInput, handler);
					Action.attack((Player) tempObject, tempObject.getX(), tempObject.getY(), tempObject.getDir(), handler, keyInput);
					Action.shoot((Player) tempObject, tempObject.getX(), tempObject.getY(), tempObject.getDir(), handler, keyInput);
				}
				else if(tempObject.getId()==ID.Projectile)
				{
					Action.attack((Projectile) tempObject, handler);
				}
				else if(tempObject.getId()==ID.BasicEnemy)
				{
					if(tempObject.moveCount==0)
					{
						
						int[] vel=EnemyMovement.aiMove(tempObject.getX(), tempObject.getY(), tempObject.getPos(),tempObject,handler);
						tempObject.setVelX(vel[0]);
						tempObject.setVelY(vel[1]);
						tempObject.setMoveCount(TileSize/2+8);
					}
				}
				Action.damage(1, handler);
				Action.KILL(handler);
			}	
		}
		else if(GameState==State.menu)
		{
			menu.tick();
		}
		else if(GameState==State.charCreate)
		{
			charCreate.tick();
		}
	}
	
	
	
	
	
	/** @render
	* Renders graphics onto canvas
	* using BufferStrategy
	*/
	private void render() 
	{
		/** TODO: RESEARCH BUFFERSTRATEGY */
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) 
		{
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		
		/** TODO: BACK IN BLACKGROUND.AC/DC */
		g.setColor(Color.getHSBColor(1.35f, 1f, .502f));
			g.fillRect(0, 0, WIDTH, HEIGHT);
		if(end&&GameState!=State.lose)
		{
			Image img=Sprite.loadSprite("win").getScaledInstance(WIDTH, HEIGHT, BufferedImage.SCALE_FAST);
			g.drawImage(img, 0, 0, null);
		}
		else
		{
			if(GameState==State.game)
			{
				Image img=Sprite.getSprite(Level%4, 5, "entities").getScaledInstance(32, 32, BufferedImage.SCALE_FAST);
				for (int i = 0 ; i < PlayWidth; i += 32) 
		            for (int j = 0; j < PlayHeight; j += 32) 
		                g.drawImage(img, i, j, null);
				hud.render(g);
			}
			else if(GameState==State.menu)
			{
				Image img=Sprite.loadSprite("menu");
				g.drawImage(img, 0, 0, null);
				menu.render(g);
			}
			else if(GameState==State.charCreate)
			{
				Image img=Sprite.loadSprite("element_selection");
				g.drawImage(img, 0, 0, null);
				charCreate.render(g);
			}
			else if(GameState==State.help)
			{
				
			}
			else if(GameState==State.info)
			{
				
			}
			else if(GameState==State.lose)
			{
				if(!end)
				{
					LevelInit.levelTearDown(handler);
					try{Thread.sleep(1000);}
					catch(InterruptedException IE){}
				}
				Image img=Sprite.loadSprite("lose").getScaledInstance(WIDTH, HEIGHT, BufferedImage.SCALE_FAST);
				g.drawImage(img, 0, 0, null);
				
			}
			handler.render(g);
			handler.renderWalls(g);
		}
		
		g.setColor(Color.yellow);
		g.setFont(new Font("consolas", Font.BOLD, 20));
			g.drawString("FPS: "+FPS, 2, HEIGHT-38-30);
			g.drawString("DLV: "+Level, 2, HEIGHT-38-15);
			g.drawString("CLV: "+CurLevel, 2, HEIGHT-38);
			g.drawString("LTS: "+LevelTimeSecs, 2, HEIGHT-38-60);
			g.drawString("PTS: "+PlayTimeSecs, 2, HEIGHT-38-45);
			
		g.dispose();
		bs.show();
	}

	/**
	* @clamp
	* var = x value for example
	* if we ever see x val is bigger
	* than room width, return value
	* equal to room width so you can 
	* never go pass room width
	*/
	public static int clamp(int var, int min, int max) {
		if (var >= max)
			return var = max;
		else if (var <= min)
			return var = min;
		else
			return var;
	}
	
	/** @main
	*  creates instance of Game class
	*/
	public static void main(String[] args) 
	{
		new Game();
	}
	
}