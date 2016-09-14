package mainGame;

import java.awt.Graphics;

public abstract class GameWall //not moving things
{
	protected int x;
	protected int y;
	protected int health;
	protected boolean collides;
	protected WallType wallType;
	
	public GameWall(int x,int y,boolean collides, WallType wall)
	{
		this.x=x;	this.y=y;
		this.collides=collides;
		wallType=wall;
		health=100;
	}
	public abstract void interact();
	public abstract void render(Graphics g);
	public abstract ItemType getItemType();
	public int getX() 
	{
		return x;
	}

	public int getY() 
	{
		return y;
	}
	public boolean getCollides()
	{
		return collides;
	}
	public void setCollides(boolean state)
	{
		this.collides=state;
	}
}