package mainGame;

import java.awt.Graphics;

public abstract class GameObject //moving things
{

	protected int x;
	protected int y;
	protected ID id;
	protected Direction dir;
	protected int velX;
	protected int velY;
	protected int moveCount;
	protected boolean collides;
	protected int damageCount;
	protected boolean damageable;
	protected int interactCount;
	protected int health;
	protected int cashMoney;
	protected int mana;
	protected int[][] pos=new int[2][2];
	
	public GameObject(int x, int y, ID id) 
	{
		this.x = (x/Game.TileSize)*Game.TileSize;
		this.y = (y/Game.TileSize)*Game.TileSize;
		this.id = id;
		dir=Direction.right;
		collides=true;
		damageable=true;
		health=100;
		this.moveCount=0;
		this.cashMoney=0;
		this.mana = 0;
		pos[0][0]=(x/Game.TileSize)*Game.TileSize;
		pos[0][1]=(y/Game.TileSize)*Game.TileSize;
		pos[1][0]=pos[0][0];
		pos[1][1]=pos[0][1];
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	public int getMoney()
	{
		return cashMoney;
	}
	public void setMana(int mana) 
	{
		this.mana = mana;
	}
	public int getMana() 
	{
		return mana;
	}
	public void setHealth(int health)
	{
		this.health=health;
	}
	public int getHealth()
	{
		return health;
	}
	public void setCollides(boolean state)
	{
		this.collides=state;
	}
	public boolean getCollides()
	{
		return collides;
	}
	public void setDir(Direction dir)
	{
		this.dir=dir;
	}
	public Direction getDir()
	{
		return dir;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public void setId(ID id) {
		this.id = id;
	}
	
	public ID getId() {
		return id;
	}
	
	public void setVelX(int velX) 
	{
		if(moveCount==0)
		{
			this.velX = velX;
		}
	}
	
	public void setVelY(int velY) 
	{
		if(moveCount==0)
		{
			this.velY = velY;
		}
	}
	
	public void setMoveCount(int count)
	{
		this.moveCount=count;
	}
	
	public int getVelX() {
		return velX;
	}
	
	public int getVelY() {
		return velY;
	}
	
	public int getMoveCount()
	{
		return moveCount;
	}
	public int[][] getPos()
	{
		return pos;
	}
	
	
}




