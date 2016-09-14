package mainGame.Levels;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import mainGame.Game;
import mainGame.Handler;
import mainGame.Levels.Menu;

public class CharacterCreation 
extends MouseAdapter
{
	private Game game;
	private Handler handler;
	public CharacterCreation(Game game, Handler handler)
	{
		this.game=game;
		this.handler=handler;
	}
	public void mousePressed(MouseEvent e)
	{
		int mseX=e.getX();
		int mseY=e.getY();
				
		if(Game.GameState==State.charCreate)
		{
			if(mouseOver(mseX, mseY, 27, 10, 159, 66))
			{
				//BACK TO MENU
				Game.GameState=State.menu;
			}
			else if(mouseOver(mseX, mseY, 1350, 10, 159, 66))
			{
				if(Game.PTVars.type!=null)
				{
					//START GAME
					Game.GameState=State.game;
					//PTVars=new PlayerTempVars();
					LevelInit.level0(handler);
				}
			}
			else if(mouseOver(mseX,mseY,191,480,398,367))
			{
				//Water Type
				Game.PTVars.type="1";
			}
			else if(mouseOver(mseX,mseY,191,81,398,367))
			{
				//Fire Type
				Game.PTVars.type="2";
			}
			else if(mouseOver(mseX,mseY,947,480,398,367))
			{
				//Earth Type
				Game.PTVars.type="3";
			}
			else if(mouseOver(mseX,mseY,947,81,398,367))
			{
				//Air Type
				Game.PTVars.type="4";
			}
		}
	}
	public void mouseReleased(MouseEvent e)
	{
		
	}
	public boolean mouseOver(int mseX, int mseY, int x, int y, int width, int height)
	{
		if((mseX>x&&mseX<x+width)&&(mseY>y&&mseY<y+height))	return true;
		else												return false;
	}
	public void tick()
	{
		
	}
	public void render(Graphics g)
	{
		
	}
}
