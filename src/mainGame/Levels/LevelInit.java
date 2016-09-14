package mainGame.Levels;

import mainGame.AudioPlayer;
import mainGame.Builder;
import mainGame.Game;
import mainGame.Handler;
import mainGame.ID;
import mainGame.Player;
import mainGame.Spawner;
import mainGame.WallType;

public class LevelInit 
{
	final static int TS=Game.TileSize;
	public static void levelTearDown(Handler handler)
	{
		AudioPlayer.getMusic("trk1").stop();
		while(!handler.getObject().isEmpty())
			handler.getObject().remove();
		while(!handler.getWall().isEmpty())
			handler.getWall().remove();
	}
	public static void level0(Handler handler)
	{
		
//		AudioPlayer.getMusic("trk0").loop();							//audio no work
		
		Builder.box(TS, TS+32, 8*TS, 15*TS+32, WallType.wall, handler);
		Builder.remove(8*TS, 8*TS+32, handler);
		Builder.addSingle(8*TS, 8*TS+32, WallType.interaction, handler);
		Builder.addSingle(9*TS, 9*TS+32, WallType.door, handler);
		
		Spawner.SingleEnemy(10*TS, 4*TS+32, handler);
		Spawner.SingleEnemy(15*TS, 4*TS+32, handler);
		Spawner.SingleEnemy(20*TS, 4*TS+32, handler);
		Spawner.SingleEnemy(25*TS, 4*TS+32, handler);
		Spawner.SingleEnemy(30*TS, 4*TS+32, handler);
		Spawner.SingleEnemy(35*TS, 4*TS+32, handler);
		
		Player player = new Player(Game.WIDTH/2 - TS, Game.HEIGHT/2 - TS, ID.Player);
		player.type=Game.PTVars.type;
		handler.addObject(player);
	}
	public static void level1(Handler handler)
	{
//		AudioPlayer.getMusic("trk0").stop();						//audio no work
		
		Builder.box(2*TS,2*TS,16*TS,16*TS,WallType.wall,handler);
		Builder.remove(16*TS, 16*TS-32, handler);
		Builder.addSingle(16*TS, 16*TS-32, WallType.interaction, handler);
		
		Spawner.SingleEnemy(4*TS,4*TS+32,handler);
		Spawner.SingleEnemy(8*TS,8*TS+32,handler);
		Builder.addSingle(3*TS, 2*TS+32, WallType.door, handler);
		
		Player player = new Player(20*TS, 20*TS, ID.Player);
		player.setPTVars(Game.PTVars);
		handler.addObject(player);
	}
public static void level2(Handler handler) 
{
		
		
		
		Builder.box(TS, TS, 17*TS, 6*TS, WallType.wall, handler);
		Builder.addSingle(2*TS, 2*TS, WallType.door, handler);
		Builder.remove(9*TS, 6*TS, handler);
		Builder.addSingle(9*TS, 6*TS, WallType.interaction, handler);
		
		Builder.box(TS - (32 * 8), TS + (32*8), 12*TS, 8*TS, WallType.wall, handler);
		Builder.box(TS - (32 * 14), TS + (32*8), 12*TS, 8*TS, WallType.wall, handler);
		
		Builder.addSingle(TS + 32, TS + 32, WallType.item, handler);
		Builder.addSingle(TS + 32, TS + 64, WallType.item, handler);
		Builder.addSingle(TS + 32, TS + 96, WallType.item, handler);
		Builder.addSingle(TS + 32, TS + 128, WallType.item, handler);
		
		Spawner.SingleEnemy(4*TS, 4*TS+32, handler);
		Spawner.SingleEnemy(5*TS, 4*TS+32, handler);
		Spawner.SingleEnemy(6*TS, 4*TS+32, handler);
		Spawner.SingleEnemy(7*TS, 4*TS+32, handler);
		
		Builder.addSingle(12*TS, 4*TS+96, WallType.interaction, handler);
		
		Spawner.SingleEnemy(4*TS, 4*TS+96, handler);
		
		Player player = new Player(20*TS, 20*TS, ID.Player);
		player.setPTVars(Game.PTVars);
		handler.addObject(player);
	}
public static void level3(Handler handler) //tutorial lvl
	{
		Builder.box(TS, TS+64, 4*TS, 6*TS+64, WallType.wall, handler);
		Builder.remove(4*TS, 4*TS+32, handler);
		Builder.addSingle(4*TS, 4*TS+32, WallType.interaction, handler);
		
		Builder.box(4*TS+128, 4*TS+128, 4*TS+192, 4*TS+192, WallType.wall, handler);
		Builder.remove(4*TS+160, 4*TS+128, handler);
		Builder.addSingle(4*TS+160, 4*TS+128, WallType.interaction, handler);
		Spawner.SingleEnemy(4*TS+160, 4*TS+160, handler);
		
		Builder.box(4*TS+512, 4*TS, 4*TS+512, 4*TS+384, WallType.wall, handler);
		Spawner.SingleEnemy(4*TS+544, 4*TS+32, handler);
		Spawner.SingleEnemy(4*TS+544, 4*TS+96, handler);
		Spawner.SingleEnemy(4*TS+544, 4*TS+160, handler);
		Spawner.SingleEnemy(4*TS+544, 4*TS+224, handler);
		Spawner.SingleEnemy(4*TS+544, 4*TS+288, handler);
		Spawner.SingleEnemy(4*TS+544, 4*TS+352, handler);
		
		Builder.addSingle(22*TS, 8*TS, WallType.door, handler);
		
		Player player = new Player(TS+32, 4*TS+96, ID.Player);
		player.setPTVars(Game.PTVars);
		handler.addObject(player);
	}
public static void level4 (Handler handler)//the edgy level
{
		Builder.box(TS, TS+32, 32*TS, 16*TS+32, WallType.wall, handler);
		Builder.box(TS, TS+32, 8*TS, 8*TS+32, WallType.wall, handler);
		Builder.box(8*TS, 8*TS+32, 8*TS, 16*TS+32, WallType.wall, handler);
		Builder.box(TS, TS+32, 12*TS, 16*TS+32, WallType.wall, handler);
		Builder.box(TS, TS+32, 8*TS, 12*TS+32, WallType.wall, handler);
		Builder.box(20*TS+32, TS+32, 32*TS, 16*TS+32, WallType.wall, handler);
		Builder.box(20*TS+32, TS+32, 32*TS, 5*TS+32, WallType.wall, handler);
		Builder.box(20*TS+32, TS+32, 32*TS, 10*TS+32, WallType.wall, handler);
		Builder.box(20*TS+32, TS+32, 32*TS, 16*TS+32, WallType.wall, handler);
		Builder.box(8*TS+32, 8*TS+32, 12*TS, 5*TS+32, WallType.wall, handler);
		Builder.box(12*TS, 5*TS+32, 32*TS, 5*TS+32, WallType.wall, handler);
		Builder.box(12*TS, 5*TS+32, 21*TS, 12*TS+32, WallType.wall, handler);
		
		Builder.remove(8*TS, 3*TS+32, handler);
		Builder.addSingle(8*TS, 3*TS+32, WallType.interaction, handler);
		Builder.remove(10*TS, 5*TS+32, handler);
		Builder.addSingle(10*TS, 5*TS+32, WallType.interaction, handler);
		Builder.remove(12*TS, 3*TS+32, handler);
		Builder.addSingle(12*TS, 3*TS+32, WallType.interaction, handler);
		Builder.remove(21*TS, 3*TS+32, handler);
		Builder.addSingle(21*TS, 3*TS+32, WallType.interaction, handler);
		Builder.remove(21*TS, 8*TS+32, handler);
		Builder.addSingle(21*TS, 8*TS+32, WallType.interaction, handler);
		Builder.remove(21*TS, 14*TS+32, handler);
		Builder.addSingle(21*TS, 14*TS+32, WallType.interaction, handler);
		Builder.remove(16*TS, 12*TS+32, handler);
		Builder.addSingle(16*TS, 12*TS+32, WallType.interaction, handler);
		Builder.remove(17*TS, 12*TS+32, handler);
		Builder.addSingle(17*TS, 12*TS+32, WallType.interaction, handler);
		Builder.remove(12*TS, 14*TS+32, handler);
		Builder.addSingle(12*TS, 14*TS+32, WallType.interaction, handler);
		Builder.remove(8*TS, 14*TS+32, handler);
		Builder.addSingle(8*TS, 14*TS+32, WallType.interaction, handler);
		Builder.remove(8*TS, 10*TS+32, handler);
		Builder.addSingle(8*TS, 10*TS+32, WallType.interaction, handler);
		Builder.remove(12*TS, 10*TS+32, handler);
		Builder.addSingle(12*TS, 10*TS+32, WallType.interaction, handler);
		Builder.remove(10*TS, 8*TS+32, handler);
		Builder.addSingle(10*TS, 8*TS+32, WallType.interaction, handler);
		Builder.remove(16*TS, 5*TS+32, handler);
		Builder.addSingle(16*TS, 5*TS+32, WallType.interaction, handler);
		Builder.remove(17*TS, 5*TS+32, handler);
		Builder.addSingle(17*TS, 5*TS+32, WallType.interaction, handler);
		Builder.remove(26*TS, 5*TS+32, handler);
		Builder.addSingle(26*TS, 5*TS+32, WallType.interaction, handler);
		Builder.remove(27*TS, 5*TS+32, handler);
		Builder.addSingle(27*TS, 5*TS+32, WallType.interaction, handler);
		Builder.remove(26*TS, 5*TS+32, handler);
		Builder.addSingle(26*TS, 5*TS+32, WallType.interaction, handler);
		Builder.remove(27*TS, 10*TS+32, handler);
		Builder.addSingle(27*TS, 10*TS+32, WallType.interaction, handler);
		Builder.remove(26*TS, 10*TS+32, handler);
		Builder.addSingle(26*TS, 10*TS+32, WallType.interaction, handler);
		Builder.remove(4*TS, 8*TS+32, handler);
		Builder.addSingle(4*TS, 8*TS+32, WallType.interaction, handler);
		Builder.remove(5*TS, 8*TS+32, handler);
		Builder.addSingle(5*TS, 8*TS+32, WallType.interaction, handler);
		Builder.remove(5*TS, 12*TS+32, handler);
		Builder.addSingle(5*TS, 12*TS+32, WallType.interaction, handler);
		Builder.remove(4*TS, 12*TS+32, handler);
		Builder.addSingle(4*TS, 12*TS+32, WallType.interaction, handler);
		Builder.remove(2*TS, 2*TS, handler);
		Builder.addSingle(2*TS, 2*TS, WallType.interaction, handler);

		Spawner.SingleEnemy(20*TS, 4*TS+32, handler);
		Spawner.SingleEnemy(10*TS, 4*TS+32, handler);
		Spawner.SingleEnemy(30*TS, 2*TS+32, handler);
		Spawner.SingleEnemy(27*TS, 3*TS+32, handler);
		Spawner.SingleEnemy(24*TS, 2*TS+32, handler);
		Spawner.SingleEnemy(15*TS, 4*TS+32, handler);
		Spawner.SingleEnemy(10*TS, 6*TS+32, handler);
		Spawner.SingleEnemy(10*TS, 10*TS+32, handler);
		Spawner.SingleEnemy(10*TS, 13*TS+32, handler);
		Spawner.SingleEnemy(10*TS, 15*TS+32, handler);
		Spawner.SingleEnemy(5*TS, 15*TS+32, handler);
		Spawner.SingleEnemy(4*TS, 15*TS+32, handler);
		Spawner.SingleEnemy(5*TS, 10*TS+32, handler);
		Spawner.SingleEnemy(4*TS, 10*TS+32, handler);
		Spawner.SingleEnemy(5*TS, 6*TS+32, handler);
		Spawner.SingleEnemy(4*TS, 6*TS+32, handler);
		Spawner.SingleEnemy(5*TS, 4*TS+32, handler);
		Spawner.SingleEnemy(4*TS, 4*TS+32, handler);
		Spawner.SingleEnemy(14*TS, 15*TS+32, handler);
		Spawner.SingleEnemy(19*TS, 15*TS+32, handler);
		Spawner.SingleEnemy(16*TS, 15*TS+32, handler);
		Spawner.SingleEnemy(23*TS, 15*TS+32, handler);
		Spawner.SingleEnemy(25*TS, 15*TS+32, handler);
		Spawner.SingleEnemy(28*TS, 15*TS+32, handler);
		Spawner.SingleEnemy(23*TS, 12*TS+32, handler);
		Spawner.SingleEnemy(25*TS, 12*TS+32, handler);
		Spawner.SingleEnemy(28*TS, 12*TS+32, handler);
		Spawner.SingleEnemy(23*TS, 7*TS+32, handler);
		Spawner.SingleEnemy(25*TS, 7*TS+32, handler);
		Spawner.SingleEnemy(28*TS, 7*TS+32, handler);
		Spawner.SingleEnemy(23*TS, 9*TS+32, handler);
		Spawner.SingleEnemy(25*TS, 9*TS+32, handler);
		Spawner.SingleEnemy(28*TS, 9*TS+32, handler);
		
		Builder.addSingle(40*TS, 10*TS, WallType.door, handler);
		
		Player player = new Player(Game.WIDTH/2 - TS, Game.HEIGHT/2 - TS, ID.Player);
		player.setPTVars(Game.PTVars);
		handler.addObject(player);
	}
	public static void level5(Handler handler) //boss lvl
	{
		Builder.box(TS, TS, 32*TS, 18*TS, WallType.wall, handler);
		
		
		Player player = new Player(TS+512, TS+288, ID.Player);
		Spawner.SingleEnemy(TS+32,TS+64,handler, 300);
		Spawner.SingleEnemy(TS+32,TS+288,handler, 300);
		Spawner.SingleEnemy(TS+32,TS+480,handler, 300);
		Spawner.SingleEnemy(TS+960,TS+64,handler, 300);
		Spawner.SingleEnemy(TS+960,TS+288,handler, 300);
		Spawner.SingleEnemy(TS+960,TS+480,handler, 300);
		
		Spawner.SingleEnemy(TS+160,TS+480,handler, 300);
		Spawner.SingleEnemy(TS+288,TS+480,handler, 300);
		Spawner.SingleEnemy(TS+416,TS+480,handler, 300);
		Spawner.SingleEnemy(TS+544,TS+480,handler, 300);
		Spawner.SingleEnemy(TS+672,TS+480,handler, 300);
		Spawner.SingleEnemy(TS+800,TS+480,handler, 300);
		Spawner.SingleEnemy(TS+928,TS+480,handler, 300);
		Spawner.SingleEnemy(TS+960,TS+480,handler, 300);
		
		Spawner.SingleEnemy(TS+160,TS+64,handler, 300);
		Spawner.SingleEnemy(TS+288,TS+64,handler, 300);
		Spawner.SingleEnemy(TS+416,TS+64,handler, 300);
		Spawner.SingleEnemy(TS+544,TS+64,handler, 300);
		Spawner.SingleEnemy(TS+672,TS+64,handler, 300);
		Spawner.SingleEnemy(TS+800,TS+64,handler, 300);
		Spawner.SingleEnemy(TS+928,TS+64,handler, 300);
		Spawner.SingleEnemy(TS+960,TS+64,handler, 300);
		
		
		
		player.type=Game.PTVars.type;
		handler.addObject(player);
	}

}
