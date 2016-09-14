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

public class Menu 
extends MouseAdapter
{
//	private Handler handler;
//	private PlayerTempVars PTVars;
	public Menu(Game game, Handler handler, PlayerTempVars PTVars)
	{
		
	}
	public void mousePressed(MouseEvent e)
	{
		int mX=e.getX();
		int mY=e.getY();
		if(Game.GameState==State.menu)
		{
			if(mouseOver(mX, mY, 1041, 122, 406, 116))
			{
				//START GAME
				Game.GameState=State.charCreate;
				Game.PTVars=new PlayerTempVars();
			}
			else if(mouseOver(mX, mY, 1043,289, 406, 116))
			{
				//HELP SCREEN
			}
			else if(mouseOver(mX, mY, 1045, 454, 406, 116))
			{
				//INFO SCREEN
				if (Desktop.isDesktopSupported()) {
					String uriStr = "http://reallyadoctor.blogspot.com";
					URI uri = URI.create(uriStr);
					try {
						Desktop.getDesktop().browse(uri);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
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
		/*
		g.setFont(new Font("comic sans",1,50));
		g.setColor(Color.white);
			g.drawString("MENU", 269+409/2, 48);
			g.drawRect(546-(546/2), 64+000, 546, 96);
			g.drawRect(546-(546/2), 64+128, 546, 96);
			g.drawRect(546-(546/2), 64+256, 546, 96);
			
			g.drawRect(546-(546/2), 64+000, 38, 14);
		  	g.drawRect(546-(546/2), 64+128, 35, 14);
		 	g.drawRect(546-(546/2), 64+256, 31, 14);
		g.setFont(new Font("comic sans",1,12));
			g.drawString("GAME", 546-(546/2)+3, 64+000+12);
			g.drawString("HELP", 546-(546/2)+3, 64+128+12);
			g.drawString("INFO", 546-(546/2)+3, 64+256+12);
		*/
	}
}




