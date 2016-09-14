package mainGame.Levels;

import mainGame.Player;

public class PlayerTempVars 
{
	public String type;
	public String Class;
	public int health;
	public int cash;
	public int mana;
	int x;
	int y;
	public PlayerTempVars()
	{
		
	}
	public PlayerTempVars(int health, int cash, int mana,String type,String Class)
	{
		this.type=type;
		this.Class=Class;
		this.health=health;
		this.cash=cash;
		this.mana=mana;
	}
	public void InventorySet(Player player)
	{
		type=player.type;
		Class=player.Class;
		health=player.getHealth();
		cash=player.getMoney();
		mana=player.getMana();
		x=player.getX();
		y=player.getY();
	}
	public void LevelSwitchSet(Player player)
	{
		type=player.type;
		Class=player.Class;
		health=player.getHealth();
		cash=player.getMoney();
		mana=player.getMana();
	}
}
