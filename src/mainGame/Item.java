package mainGame;

import java.awt.Color;
import java.awt.Graphics;

public class Item 
extends GameWall
{
	protected ItemType T;
	public Item(int x, int y, boolean doesntMatter, WallType wall,ItemType T) 
	{
		super(x,y,false,wall);
		this.T=T;
	}
	public void render(Graphics graphics)
	{
		if(T==ItemType.healthpack)
		{
			graphics.setColor(Color.RED);
				graphics.fillRect(x+4,y+4,24,24);
		}
		else if(T==ItemType.money)
		{
			graphics.setColor(Color.yellow);
				graphics.fillRect(x+04,y+04,10,10);
				graphics.fillRect(x+18,y+04,10,10);
				graphics.fillRect(x+04,y+18,10,10);
				graphics.fillRect(x+18,y+18,10,10);
				
		}
		else if (T==ItemType.mana)
		{
			graphics.setColor(Color.MAGENTA);
				graphics.fillRect(x + 4, y + 4, 24, 24);
		}
	}
	
	@Override
	public ItemType getItemType()
	{
		return T;
	}
	
	@Override
	public void interact()
	{
		health=0;
	}


	
}