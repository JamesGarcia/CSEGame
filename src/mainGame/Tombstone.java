package mainGame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import mainGame.Graphics.Sprite;

public class Tombstone 
extends GameWall
{
	public Tombstone(int x, int y, boolean collides, WallType wall) 
	{
		super(x,y,collides,wall);
		
	}
	public void render(Graphics g)
	{
		Image img=Sprite.getSprite(5, 1, "entities").getScaledInstance(32, 32, BufferedImage.SCALE_FAST);
		g.drawImage(img, x, y, null);
	}
	@Override
	public void interact()
	{
		
	}
	@Override
	public ItemType getItemType() 
	{
		return null;
	}
}