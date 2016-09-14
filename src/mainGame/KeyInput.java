package mainGame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

	private Handler handler;

	boolean keyUp = false;
	boolean keyDown = false;
	boolean keyRight = false;
	boolean keyLeft = false;
	boolean keyInteract = false;
	boolean keySpace = false;
	
	public KeyInput(Handler handler) {
		this.handler = handler;
	}
	
	/**
	* @keyPressed
	* Loop through all loaded objects
	* and finds the player object by
	* checking the ID.
	*/
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		//System.out.println(key);
		
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if (tempObject.getId() == ID.Player) {
				
				if (key == KeyEvent.VK_W) setUpPressed(true);
				if (key == KeyEvent.VK_S) setDownPressed(true);
				if (key == KeyEvent.VK_A) setLeftPressed(true);
				if (key == KeyEvent.VK_D) setRightPressed(true);
				if (key == KeyEvent.VK_F) setInteractPressed(true);
				if (key == KeyEvent.VK_SPACE) setSpacePressed(true);
			}
		}		
		if (key == KeyEvent.VK_ESCAPE) System.exit(1);
			
	}
	public void setInteractPressed(boolean state)
	{
		this.keyInteract=state;
	}
	public boolean getInteractPressed()
	{
		return keyInteract;
	}
	public void setSpacePressed(boolean state)
	{
		keySpace=state;
	}
	public boolean getSpacePressed()
	{
		return keySpace;
	}
	
	
	public void setUpPressed(boolean state) {
		keyUp = state;
	}
	
	public boolean getUpPressed() {
		return keyUp;
	}
	
	public void setDownPressed(boolean state) {
		keyDown = state;
	}
	
	public boolean getDownPressed() {
		return keyDown;
	}
	
	public void setRightPressed(boolean state) {
		keyRight = state;
	}
	
	public boolean getRightPressed() {
		return keyRight;
	}
	
	public void setLeftPressed(boolean state) {
		keyLeft = state;
	}
	
	public boolean getLeftPressed() {
		return keyLeft;
	}
	
	
	public GameObject getObject(GameObject tempObject) {
		return tempObject;
	}
	
	
	
	/** @keyReleased
	* set all values to 0
	* to stop movement of square
	*/
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if (tempObject.getId() == ID.Player) {
				
				if (key == KeyEvent.VK_W) setUpPressed(false);
				if (key == KeyEvent.VK_S) setDownPressed(false);
				if (key == KeyEvent.VK_A) setLeftPressed(false);
				if (key == KeyEvent.VK_D) setRightPressed(false);
				if (key == KeyEvent.VK_F) setInteractPressed(false);
				if (key == KeyEvent.VK_SPACE) setSpacePressed(false);
			}
			
		}
	}
	
}