package mainGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import mainGame.Graphics.Sprite;

public class Door 
extends GameWall
{

	public Door(int x, int y, boolean collides, WallType wall) 
	{
		super(x, y, collides, wall);
	}

	@Override
	public void interact()
	{
		Game.Level++;
		health=0;
	}

	@Override
	public void render(Graphics g)
	{
		Image img=Sprite.getSprite(4, 1, "entities").getScaledInstance(32, 32, BufferedImage.SCALE_FAST);
		g.drawImage(img, x, y, null);
	}

	@Override
	public ItemType getItemType() 
	{
		return null;
	}

}
