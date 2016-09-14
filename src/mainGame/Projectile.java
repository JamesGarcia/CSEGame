package mainGame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import mainGame.Graphics.Sprite;

public class Projectile 
extends GameObject
{
	public Projectile(int x, int y, int velX, int velY, ID id)
	{
		super(x, y, id);
		this.velX=velX;
		this.velY=velY;
	}
	public void render(Graphics g)
	{
		Image img=Sprite.getSprite(0, 6, "entities").getScaledInstance(Game.TileSize, Game.TileSize, BufferedImage.SCALE_FAST);
		g.drawImage(img, x, y, null);
	}
	@Override
	public void tick() 
	{
		x += velX;
		y += velY;
		health--;
	}
}
