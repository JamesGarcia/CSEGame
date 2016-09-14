package mainGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import mainGame.Graphics.Sprite;

public class BasicEnemy extends GameObject {

	//private Random r = new Random();
	private double textureVal = 0;
	
	public BasicEnemy(int x, int y, ID id, double texture) 
	{
		super(x, y, id);
		textureVal = texture;
	}
	public BasicEnemy(int x, int y, ID id, double texture, int health)
	{
		super(x, y, id);
		textureVal = texture;
		this.health=health;
	}

	/**
	 * @tick 
	 * happens every tick
	 */
	public void tick() 
	{
		if(moveCount>0&&moveCount<9)
		{
			velX=0;	velY=0;
		}
		if(moveCount>0)		moveCount--;
		if(damageCount>0)	damageCount--;
		
		
		
		x += velX;
		y += velY;
	}

	public void render(Graphics g) 
	{		
		if (textureVal >= 0.5) {
			Image img=Sprite.getSprite(4, 0, "entities").getScaledInstance(Game.TileSize, Game.TileSize, BufferedImage.SCALE_FAST);
			g.drawImage(img, x, y, null);
		} else {
			Image img=Sprite.getSprite(5, 0, "entities").getScaledInstance(Game.TileSize, Game.TileSize, BufferedImage.SCALE_FAST);
			g.drawImage(img, x, y, null);
		}
		g.setColor(Color.black);
		g.fillRect(x, y, 27, 6);
		g.setColor(Color.green);
		g.fillRect(x+1, y+1, health/4, 4);
	}

}




