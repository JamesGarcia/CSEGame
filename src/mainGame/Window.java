package mainGame;

import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JFrame;

/**
 * 2nd step/class made
 * EXTEND CANVAS
 */
public class Window
{
	public Window(JFrame frame, Game game) 
	throws IOException 
	{
		frame.setSize(new Dimension(Game.WIDTH, Game.HEIGHT));
		frame.setPreferredSize(new Dimension(Game.WIDTH, Game.HEIGHT));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		/* VERY IMPORTANT */
		/* NEVER DELETE */
		frame.add(game);
		frame.setVisible(true);
		game.start();
	}
}