package mainGame.Levels;

import mainGame.Game;
import mainGame.Handler;
import mainGame.ID;
import mainGame.Player;

public class LevelManager 
{
	public static void changeLevels(Handler handler)
	{
		
		boolean look=true;
		Player p=null;
		for(int n=0;n<handler.getObject().size()&&look;n++)
			if(handler.getObject().get(n).getId()==ID.Player)
			{
				p=(Player)handler.getObject().get(n);
				look=false;
			}
		Game.PTVars.LevelSwitchSet(p);
		LevelInit.levelTearDown(handler);
		Game.LevelStartTime=System.currentTimeMillis();
		if(Game.Level==0)
		{}
		else if(Game.Level==1)
			LevelInit.level1(handler);
		else if(Game.Level==2)
			LevelInit.level2(handler);
		else if(Game.Level==3)
			LevelInit.level3(handler);
		else if(Game.Level==4)
			LevelInit.level4(handler);
		else if(Game.Level==5)
			LevelInit.level5(handler);
		else
			Game.end=true;
	}
}
