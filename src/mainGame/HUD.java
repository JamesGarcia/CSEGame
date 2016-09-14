package mainGame;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {

	/**
	 * TODO:
	 * Remove static because
	 * eventually when attack is added,
	 * the enemies need a health of their
	 * own
	 */
	public int HEALTH = 100;
	public int CASH = 0;
	public int MANA = 0;
	
	public void tick(int HEALTH,int CASH,int Mana) 
	{
		//HEALTH--;
		this.HEALTH=HEALTH;
		HEALTH = Game.clamp(HEALTH, 0, 100);
		this.MANA=Mana;
		MANA=Game.clamp(MANA, 0, 80);
		this.CASH=CASH;
		
	}
	
	public void render(Graphics g) 
	{
		//health
		g.setColor(Color.gray);
			g.fillRect(12, 1, 200, 28);
		g.setColor(Color.green);
			g.fillRect(12, 1, HEALTH * 2, 28);
		/** border around HUD */
		g.setColor(Color.white);
			g.drawRect(12, 1, 200, 28);
			
		//mana
		g.setColor(Color.gray);
	    	g.fillRect(234 + (32 * 10), 0, 32*5, 32);
	    g.setColor(Color.lightGray);
	    	g.drawRect(234 + (32 * 10), 0, 32* 5, 32);
	    g.setColor(Color.magenta);
	    	g.fillRect(234+ 32*10, 0, MANA*2, 32);
			
		//inventory locations
		g.setColor(Color.gray);
			g.fillRect(224, 0, 32*10, 32);
		g.setColor(Color.lightGray);
			g.drawRect( 7*32+1, 1, 30, 30); //225,1
			g.drawRect( 8*32+1, 1, 30, 30); //257,1
			g.drawRect( 9*32+1, 1, 30, 30); //289,1
			g.drawRect(10*32+1, 1, 30, 30); //321,1
			g.drawRect(11*32+1, 1, 30, 30); //353,1
			g.drawRect(12*32+1, 1, 30, 30); //385,1
			g.drawRect(13*32+1, 1, 30, 30); //417,1
			g.drawRect(14*32+1, 1, 30, 30); //449,1
			g.drawRect(15*32+1, 1, 30, 30); //481,1
			g.drawRect(16*32+1, 1, 30, 30); //513,1
			
	    
			
		if(CASH>0)
		{
			g.setColor(Color.yellow);
			g.fillRect(7*32+4,4,25,25);
			
			g.setColor(Color.gray);
			g.drawString("$"+CASH, 224+4, 1+27);
		}
		
		//if (MANA > 0) 
		//{
		//	System.out.println(MANA);
		//	g.setColor(Color.MAGENTA);
		//    for (int i = 0; i < MANA; i++) {
		//    	g.fillRect(235 + (32 * 10), 1, MANA * 11, 30);
		//    }
		//}
		
		//g.drawString(""+CASH, 416+21, 1+26);
	}
	
}

