package mainGame;

import javax.swing.JOptionPane;

import mainGame.Levels.State;

public class Action
{
	public static boolean collide(int Xpos,int Ypos,Handler handler)
	{
		for(int n=0;n<handler.wall.size();n++)
		{
			GameWall temp=handler.wall.get(n);
			//System.out.println(temp.getX()+","+temp.getY()+coord+pos);
			if(temp.getCollides())
			{
				if(temp.getX()==Xpos&&temp.getY()==Ypos)
				return true;
			}
		}
		for(int n=0;n<handler.object.size();n++)
		{
			GameObject temp=handler.object.get(n);
			if(temp.getCollides()&&temp.getX()==Xpos&&temp.getY()==Ypos)
			{
				return true;
			}
		}
		return false;
	}
	public static boolean collide2(int[][] pos, GameObject self, Direction dir, Handler handler)
	{
		int x1=pos[0][0];
		int y1=pos[0][1];
		int x2=pos[1][0];
		int y2=pos[1][1];
		
	//	if(self.velX==-2)		dir=Direction.left;
	//	else if(self.velX==2)	dir=Direction.right;
	//	else if(self.velY==-2)	dir=Direction.up;
	//	else if(self.velY==2)	dir=Direction.down;
			
		
		
			 if(dir==Direction.up) 		{y1=pos[0][1]-Game.TileSize;	y2=pos[1][1]-Game.TileSize;}
		else if(dir==Direction.down)	{y1=pos[1][1]+Game.TileSize;	y2=pos[1][1]+Game.TileSize;}
		else if(dir==Direction.left)	{x1=pos[0][0]-Game.TileSize;	x2=pos[1][0]-Game.TileSize;}
		else if(dir==Direction.right)	{x1=pos[1][0]+Game.TileSize;	x2=pos[1][0]+Game.TileSize;}
		for(int n=0;n<handler.wall.size();n++)
		{
			GameWall temp=handler.wall.get(n);
			if(temp.getCollides())
			{
				if(temp.getX()==x1&&temp.getY()==y1)
					return true;
			}
		}
		for(int n=0;n<handler.object.size();n++)
		{
			GameObject temp=handler.object.get(n);
			if(temp.getCollides()&&temp!=self)
			{
				int[][] tempPos=new int[2][2];
				tempPos=temp.getPos();
					 if(tempPos[0][0]==x1&&tempPos[0][1]==y1)		return true;
				else if(tempPos[1][0]==x1&&tempPos[1][1]==y1)		return true;
				else if(tempPos[1][0]==x2&&tempPos[1][1]==y2)		return true;
				else if(tempPos[1][0]==x2&&tempPos[1][1]==y2)		return true;
			}
		}
		
		return false;
	}
	public static void interact(int x, int y, Direction dir, KeyInput key, Handler handler)
	{
		for(int n=0;n<handler.wall.size();n++)
		{
			GameWall temp=handler.wall.get(n);
			if(temp.wallType==WallType.interaction)
			{
				if(key.getInteractPressed())
				{
					if(dir==Direction.right&&temp.getX()==x+Game.TileSize&&temp.getY()==y)
					{
						temp.interact();
					}
					else if(dir==Direction.left&&temp.getX()==x-Game.TileSize&&temp.getY()==y)
					{
						temp.interact();
					}
					else if(dir==Direction.up&&temp.getX()==x&&temp.getY()==y-Game.TileSize)
					{
						temp.interact();
					}
					else if(dir==Direction.down&&temp.getX()==x&&temp.getY()==y+Game.TileSize)
					{
						temp.interact();
					}
					else{}
				}
			}
			else if(temp.wallType==WallType.item)
			{
				for(int m=0;m<handler.object.size();m++)
				{
					if(handler.object.get(m).getId()==ID.Player)
					{
						GameObject player=handler.object.get(m);
						if(player.getX()==temp.getX()&&player.getY()==temp.getY())	
							temp.interact();
						
					}
				}
			}
			else if(temp.wallType==WallType.door)
			{
				for(int m=0;m<handler.object.size();m++)
				{
					if(handler.object.get(m).getId()==ID.Player)
					{
						GameObject player=handler.object.get(m);
						if(player.getX()==temp.getX()&&player.getY()==temp.getY())	
							temp.interact();
						
					}
				}
			}
		}
	}
	public static void absorb(int x, int y, Handler handler)
	{
		for(int n=0;n<handler.wall.size();n++)
		{
			GameWall temp=handler.wall.get(n);
			if(temp.getX()==x&&temp.getY()==y)
			{
				
			}
		}
			
	}
	public static void damage(int amount,Handler handler)
	{
		
		for(int n=0;n<handler.object.size();n++)
		{
			GameObject temp=handler.object.get(n);
			if(temp.getId()==ID.Player&&temp.damageable&&temp.getHealth()>0&&temp.damageCount==0)	
			{
				for(int m=0;m<handler.object.size();m++)
				{	
					GameObject tempEnemy=handler.object.get(m);
					if(tempEnemy.getId()==ID.BasicEnemy)
					{
						int xEnemy=tempEnemy.getX();	int yEnemy=tempEnemy.getY();
						int xPlayer=temp.getX();		int yPlayer=temp.getY();
						
						boolean doDamage=false;
						
							 if(xPlayer+Game.TileSize==xEnemy&&yPlayer==yEnemy)	doDamage=true;
						else if(xPlayer-Game.TileSize==xEnemy&&yPlayer==yEnemy)	doDamage=true;
						else if(xPlayer==xEnemy&&yPlayer+Game.TileSize==yEnemy)	doDamage=true;
						else if(xPlayer==xEnemy&&yPlayer-Game.TileSize==yEnemy)	doDamage=true;
						if(doDamage)
						{
							temp.setHealth(temp.getHealth()-amount);
							temp.damageCount=8;
						}
					}
				}
			}
		}
		
	}
	public static void EndGame(Handler handler)
	{
		for(int n=0;n<handler.wall.size();n++)
		{
			if(handler.wall.get(n).wallType==WallType.tombstone)
			{
				if(handler.wall.get(n).health>200)
				{
					Game.GameState=State.lose;
					
				//	JOptionPane.showMessageDialog(null, "YOU DIED!");
				//	try { Thread.sleep(1000); } catch (Exception e) { e.printStackTrace(); }
				//	System.exit(1);
				}
				else
					handler.wall.get(n).health++;
			}
		}
	}
	public static void KILL(Handler handler)
	{
		for(int n=0;n<handler.object.size();n++)
		{
			GameObject temp=handler.object.get(n);
			if(temp.health<=0)
			{
				if(temp.getId()==ID.Player)
				{
					Builder.addSingle((temp.getX()/Game.TileSize)*Game.TileSize, (temp.getY()/Game.TileSize)*Game.TileSize, WallType.tombstone, handler);
				}
				if(temp.getId()==ID.BasicEnemy)
				{
					Builder.addSingle((temp.getX()/Game.TileSize)*Game.TileSize, (temp.getY()/Game.TileSize)*Game.TileSize, WallType.item, handler);
					
				}
				handler.object.remove(n);
			}
		}
		for(int n=0;n<handler.wall.size();n++)
		{
			GameWall temp=handler.wall.get(n);
			if(temp.health==0)
			{
				if(temp.wallType==WallType.item)
				{
					for(int m=0;m<handler.object.size();m++)
					{
						if(handler.object.get(m).getId()==ID.Player)
						{
							GameObject player = handler.object.get(m);
							
							//johnny cash money
							if(temp.getItemType()==ItemType.money)
							{
								player.cashMoney+=15;
							}
							
							//Helth Paque
							if(temp.getItemType()==ItemType.healthpack)
							{
								if(player.getHealth()<85)	player.setHealth(handler.object.get(m).getHealth()+15);
								else	player.setHealth(100);
							}
							
							//MANA
							if(temp.getItemType() == ItemType.mana)
							{
								if (player.getMana() < 85) player.setMana(handler.object.get(m).getMana() + 15);
								else player.setMana(100);
							}
						}
					}
				}
				handler.wall.remove(n);
			}
		}
	}
	public static void PlayerAction(Handler handler, GameObject tempObject, KeyInput keyInput)
	{
		if(tempObject.getMoveCount()==0)
		{
				 if(keyInput.getUpPressed())	tempObject.setDir(Direction.up);
			else if(keyInput.getDownPressed())	tempObject.setDir(Direction.down);
			else if(keyInput.getLeftPressed())	tempObject.setDir(Direction.left);
			else if(keyInput.getRightPressed())	tempObject.setDir(Direction.right);
			
			int[][] pos=tempObject.getPos();
			int x=(tempObject.getX()/Game.TileSize)*Game.TileSize; 
			int y=(tempObject.getY()/Game.TileSize)*Game.TileSize;
			tempObject.setX((x/Game.TileSize)*Game.TileSize);
			tempObject.setY((y/Game.TileSize)*Game.TileSize);
			
			tempObject.pos[0][0]=x;
			tempObject.pos[1][0]=x;
			tempObject.pos[0][1]=y;
			tempObject.pos[1][1]=y;
			
			if (keyInput.getUpPressed() && keyInput.getRightPressed()) 
			{
				tempObject.setVelY(0);
				tempObject.setVelX(0);
			}
			else if (keyInput.getUpPressed() && keyInput.getLeftPressed()) 
			{
				tempObject.setVelY(0);
				tempObject.setVelX(0);
			}
			else if (keyInput.getDownPressed() && keyInput.getRightPressed()) 
			{
				tempObject.setVelY(0);
				tempObject.setVelX(0);
			}
			else if (keyInput.getDownPressed() && keyInput.getLeftPressed()) 
			{
				tempObject.setVelY(0);
				tempObject.setVelX(0);
			}
			else if (keyInput.getUpPressed()&&!Action.collide2(pos,tempObject,Direction.up,handler)) 
			{
				//tempObject.setDir(Direction.up);
				//tempObject.setMoveCount(16);
				//System.out.print(collide(x,y-32)+" ");
				tempObject.setVelY(-2);
				tempObject.setVelX(0);
				
				tempObject.pos[0][0]=x;
				tempObject.pos[1][0]=x;
				tempObject.pos[0][1]=y;
				tempObject.pos[1][1]=y-Game.TileSize;
				
				tempObject.setMoveCount(Game.TileSize/2);
				
			} 
			else if (keyInput.getDownPressed()&&!Action.collide2(pos,tempObject,Direction.down,handler)) 
			{
				///tempObject.setDir(Direction.down);
				//tempObject.setMoveCount(16);
				//System.out.print(collide(x,y+32)+" ");
				tempObject.setVelY(2);
				tempObject.setVelX(0);
				
				tempObject.pos[0][0]=x;
				tempObject.pos[1][0]=x;
				tempObject.pos[0][1]=y;
				tempObject.pos[1][1]=y+Game.TileSize;
				
				tempObject.setMoveCount(Game.TileSize/2);
			}
			else if (keyInput.getRightPressed()&&!Action.collide2(pos,tempObject,Direction.right,handler)) 
			{
				//tempObject.setDir(Direction.right);
				//tempObject.setMoveCount(16);
				//System.out.print(collide(x+32,y)+" ");
				tempObject.setVelY(0);
				tempObject.setVelX(2);
				
				tempObject.pos[0][0]=x;
				tempObject.pos[1][0]=x+Game.TileSize;
				tempObject.pos[0][1]=y;
				tempObject.pos[1][1]=y;
				
				tempObject.setMoveCount(Game.TileSize/2);
			}
			else if (keyInput.getLeftPressed()&&!Action.collide2(pos,tempObject,Direction.left,handler)) 
			{
				//tempObject.setDir(Direction.left);
				//tempObject.setMoveCount(16);
				//System.out.print(collide(x-32,y)+" ");
				tempObject.setVelY(0);
				tempObject.setVelX(-2);
				
				tempObject.pos[0][0]=x;
				tempObject.pos[1][0]=x-Game.TileSize;
				tempObject.pos[0][1]=y;
				tempObject.pos[1][1]=y;
				
				tempObject.setMoveCount(Game.TileSize/2);
			}
			else 
			{
				tempObject.setVelX(0);
				tempObject.setVelY(0);
				
			}
		}
	}
	public static void attack(Player player, int x, int y, Direction dir, Handler handler, KeyInput keyInput)
	{
		for(int n=0;n<handler.object.size();n++)
		{
			GameObject temp=handler.object.get(n);
			if(temp.getId()==ID.BasicEnemy)
			{
				if(keyInput.getSpacePressed()&&player.attackCount==0)
				{
					if(dir==Direction.right&&temp.getX()==x+Game.TileSize&&temp.getY()==y)
					{
						temp.setHealth(temp.getHealth()-25);
						player.attackCount=8;
					}
					else if(dir==Direction.left&&temp.getX()==x-Game.TileSize&&temp.getY()==y)
					{
						temp.setHealth(temp.getHealth()-25);
						player.attackCount=8;
					}
					else if(dir==Direction.up&&temp.getX()==x&&temp.getY()==y-Game.TileSize)
					{
						temp.setHealth(temp.getHealth()-25);
						player.attackCount=8;
					}
					else if(dir==Direction.down&&temp.getX()==x&&temp.getY()==y+Game.TileSize)
					{
						temp.setHealth(temp.getHealth()-25);
						player.attackCount=8;
					}
					else{}
				}
			}
		}
	}
	public static void shoot(Player player, int x, int y, Direction dir, Handler handler, KeyInput keyInput)
	{
		if(keyInput.getSpacePressed()&&keyInput.keyInteract&&player.attackCount==0&&player.mana>10)
		{
			if(dir==Direction.right)
			{
				handler.addObject(new Projectile(x+Game.TileSize,y,2,0,ID.Projectile));
				player.attackCount=32;
			}
			else if(dir==Direction.left)
			{
				handler.addObject(new Projectile(x-Game.TileSize,y,-2,0,ID.Projectile));
				player.attackCount=32;
			}
			else if(dir==Direction.up)
			{
				handler.addObject(new Projectile(x,y-Game.TileSize,0,-2,ID.Projectile));
				player.attackCount=32;
			}
			else if(dir==Direction.down)
			{
				handler.addObject(new Projectile(x,y+Game.TileSize,0,2,ID.Projectile));
				player.attackCount=32;
			}
			if(player.attackCount==32)
				player.mana-=10;
		}
	}
	public static void attack(Projectile proj, Handler handler)
	{
		for(int n=0;n<handler.object.size();n++)
		{
			GameObject temp=handler.object.get(n);
			if(temp.getId()==ID.BasicEnemy)
				if(proj.getX()==temp.getX()&&proj.getY()==temp.getY())
					temp.setHealth(temp.getHealth()-proj.getHealth());
		}
	}
}