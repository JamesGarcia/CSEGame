package mainGame.Levels;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;

import mainGame.Game;
import mainGame.Handler;

public class Help 
extends MouseAdapter
{
//	private Handler handler;
//	private PlayerTempVars PTVars;
	public Help(Game game, Handler handler, PlayerTempVars PTVars)
	{
		
	}
	public void mousePressed(MouseEvent e)
	{
		int mX=e.getX();
		int mY=e.getY();
		if(Game.GameState==State.help)
		{
			int mseX=e.getX();
			int mseY=e.getY();
			if(Game.GameState==State.help)
			{
				
			}
		}
	}
	public void mouseReleased(MouseEvent e)
	{
		
	}
	public boolean mouseOver(int mX, int mY, int x, int y, int width, int height)
	{
		if((mX>x&&mX<x+width)&&(mY>y&&mY<y+height))	return true;
		else										return false;
	}
	public void tick()
	{
		
	}
	public void render(Graphics g)
	{
		
	}
}




