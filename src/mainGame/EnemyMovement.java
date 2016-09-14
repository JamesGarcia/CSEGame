package mainGame;

public class EnemyMovement 
{
	public static int[] rand(int x,int y,int[][]pos,GameObject obj,Handler handler)
	{
		int VelY = 2*(int)(Math.random()*3)-2;
		int VelX = 2*(int)(Math.random()*3)-2;
		
		if(Math.random()>=0.5)
		{
			if(VelY!=0&&VelX!=0)
			{
				VelY=0;
			}
		}
		else
		{
			if(VelY!=0&&VelX!=0)
			{
				VelX=0;
			}
		}
		
		if(x+Game.TileSize==Game.WIDTH&&VelX>0)		VelX=0;
		if(y+Game.TileSize==Game.HEIGHT&&VelY>0)	VelY=0;
		if(x==0&&VelX<0)							VelX=0;
		if(y==0&&VelY<0)							VelY=0;
		
			 if(VelY<0&&Action.collide2(pos, obj, Direction.up, handler))		VelY=0;
		else if(VelY>0&&Action.collide2(pos, obj, Direction.down, handler))		VelY=0;
		else if(VelX<0&&Action.collide2(pos, obj, Direction.left, handler))		VelX=0;
		else if(VelX>0&&Action.collide2(pos, obj, Direction.right, handler))	VelX=0;
		
		int[] vel=new int[] {VelX,VelY};
		
		return vel;
	}
	
	public static int[] aiMove(int x,int y,int[][]pos,GameObject obj,Handler handler)
	{
		int velX=0;
		int velY=0;
		int curX=obj.getX();
		int curY=obj.getY();
		int desX=curX;
		int desY=curY;
		
		pos[0][0]=curX;
		pos[1][0]=curX;
		pos[0][1]=curY;
		pos[1][1]=curY;
		
		for(int n=0;n<handler.object.size();n++)
		{
			if(handler.object.get(n).getId()==ID.Player)
			{
				desX=handler.object.get(n).getX();
				desY=handler.object.get(n).getY();
			}
		}
		int diffX=Math.abs(curX-desX);
		int diffY=Math.abs(curY-desY);
		if(diffX>diffY)
		{
			if(desX-curX<0)		velX=-2;
			if(desX-curX>0)		velX=2;
		}
		else
		{
			if(desY-curY<0)		velY=-2;
			if(desY-curY>0)		velY=2;
		}
		
		if(curX+Game.TileSize==Game.WIDTH&&velX>0)		velX=0;
		if(curY+Game.TileSize==Game.HEIGHT&&velY>0)		velY=0;
		if(curX==0&&velX<0)								velX=0;
		if(curY==0&&velY<0)								velY=0;
		
			 if(velY<0&&Action.collide2(pos, obj, Direction.up, handler))		velY=0;
		else if(velY>0&&Action.collide2(pos, obj, Direction.down, handler))		velY=0;
		else if(velX<0&&Action.collide2(pos, obj, Direction.left, handler))		velX=0;
		else if(velX>0&&Action.collide2(pos, obj, Direction.right, handler))	velX=0;
			 
		if(velY==-2)
		{
			obj.pos[0][0]=x;
			obj.pos[1][0]=x;
			obj.pos[0][1]=y;
			obj.pos[1][1]=y-Game.TileSize;
		}
		else if(velY==2)
		{
			obj.pos[0][0]=x;
			obj.pos[1][0]=x;
			obj.pos[0][1]=y;
			obj.pos[1][1]=y+Game.TileSize;
		}
		else if(velX==-2)
		{
			obj.pos[0][0]=x;
			obj.pos[1][0]=x-Game.TileSize;
			obj.pos[0][1]=y;
			obj.pos[1][1]=y;
		}
		else if(velX==2)
		{
			obj.pos[0][0]=x;
			obj.pos[1][0]=x+Game.TileSize;
			obj.pos[0][1]=y;
			obj.pos[1][1]=y;
		}
		
		int []vel=new int[] {velX,velY};
		return vel;
	}
	
}
