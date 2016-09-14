package mainGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import mainGame.Graphics.Sprite;

public class Interaction
extends GameWall
{
	int interactCount=0;
	public Interaction(int x, int y, boolean collides, WallType wall)
	{
		super(x, y, collides, wall);
	}

	@Override
	public void render(Graphics g)
	{
		if(interactCount>0)
			interactCount--;
		int openClose;
		if(collides)	openClose=6;
		else			openClose=7;
		Image img=Sprite.getSprite(openClose, 0, "entities").getScaledInstance(32, 32, BufferedImage.SCALE_FAST);
		g.drawImage(img, x, y, null);
	}

	@Override
	public void interact()
	{
		if(interactCount==0)
		{
			setCollides(!getCollides());
			interactCount=(Game.FPS*2)/5;
		}
	}

	@Override
	public ItemType getItemType() 
	{
		return null;
	}
	
	
}