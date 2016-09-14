package mainGame;


public class Spawner 
{
    public static void SingleEnemy(int x, int y, Handler handler)
    {
    	double texture = Math.random();
        handler.addObject(new BasicEnemy(x,y,ID.BasicEnemy, texture));
    } 
    public static void SingleEnemy(int x, int y, Handler handler, int health)
    {
    	double texture = Math.random();
        handler.addObject(new BasicEnemy(x,y,ID.BasicEnemy, texture, health));
    }
}



