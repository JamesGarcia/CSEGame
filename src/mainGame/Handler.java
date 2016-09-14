package mainGame;

import java.awt.Graphics;
import java.util.LinkedList;

/** maintain & render all objects */
public class Handler {

	LinkedList<GameObject> object = new LinkedList<GameObject>();
	LinkedList<GameWall> wall=new LinkedList<GameWall>();
	
	public void tick() {
		for (int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			
			tempObject.tick();
		}
	}
	
	public void render(Graphics g) {
		for (int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			
			tempObject.render(g);
		}
	}
	
	public void addObject(GameObject object) {
		this.object.add(object);
	}
	
	public void removeObject(GameObject object) {
		this.object.remove(object);
	}
	
	public void renderWalls(Graphics g)
	{
		for(int n=0;n<wall.size();n++)
		{
			GameWall tempWall=wall.get(n);
			tempWall.render(g);
		}
	}
	
	public void addWall(GameWall wall)
	{
		this.wall.add(wall);
	}
	
	public void removeWall(GameWall wall)
	{
		this.wall.remove(wall);
	}
	public LinkedList<GameObject> getObject()
	{
		return object;
	}
	public LinkedList<GameWall> getWall()
	{
		return wall;
	}
	
}