package mainGame;

public class Builder 
{
	public static void addSingle(int x, int y, WallType type, Handler handler)
	{
		
		if(type==WallType.interaction)	
			handler.addWall(new Interaction(x,y,true,type));
		if(type==WallType.item)	
		{
			double randNum=Math.random()*100;
			if(randNum<10)			handler.addWall(new Item(x,y,false,type,ItemType.healthpack));
			else if(randNum<40)		handler.addWall(new Item(x,y,false,type,ItemType.money));
			else if (randNum<60) 	handler.addWall(new Item(x, y, false,type,ItemType.mana));
		}
		if(type==WallType.door)
			handler.addWall(new Door(x, y, false, type));
		if(type==WallType.tombstone)
			handler.addWall(new Tombstone(x,y,true,type));
	}
	/**builds linear wall from point 1(x1,y) to point 2(x2,y)
	 * x1 is the left-most point, lesser value than x2
	 */
	public static void lineHorz(int x1, int x2, int y, WallType type, Handler handler)
	{
		while(x1<=x2)
		{
			handler.addWall(new Wall(x1,y,true,type));
			x1+=Game.TileSize;
		}		
	}
	public static void lineVert(int x, int y1, int y2, WallType type, Handler handler)
	{
		while(y1<=y2)
		{
			handler.addWall(new Wall(x,y1,true,type));
			y1+=Game.TileSize;
		}
	}
	public static void box(int x1, int y1, int x2, int y2, WallType type, Handler handler)
	{
		lineHorz(x1,x2,y1,type,handler);
		lineHorz(x1,x2,y2,type,handler);
		lineVert(x1,y1,y2-Game.TileSize,type,handler);
		lineVert(x2,y1,y2-Game.TileSize,type,handler);
		
	}
	public static void remove(int x,int y, Handler handler)
	{
		for(int n=0;n<handler.wall.size();n++)
		{
			GameWall tempWall = handler.wall.get(n);
			int wallX=tempWall.getX(); int wallY=tempWall.getY();
			if(x==wallX&&y==wallY)
			{
				handler.wall.remove(n);
			}
		}
	}
}
