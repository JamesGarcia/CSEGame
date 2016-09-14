package mainGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Random;

import mainGame.Graphics.Sprite;
import mainGame.Levels.PlayerTempVars;

public class Player extends GameObject 
{
	
	public String type = "";
	public String Class = "";
	Random r = new Random();
	public int attackCount=0;

	public Player(int x, int y, ID id) 
	{
		super(x, y, id);
	}

	public void tick() 
	{
		if(moveCount>0)		moveCount--;
		if(damageCount>0)	damageCount--;
		if(interactCount>0)	interactCount--;
		if(attackCount>0)	attackCount--;
		
		x = Game.clamp(x, 0, Game.WIDTH - (Game.TileSize+3)+1);
		y = Game.clamp(y, 0, Game.HEIGHT - (Game.TileSize+36)+1);
		
		x += velX;
		y += velY;
	}

	public void render(Graphics g) 
	{
		if(type!=null)
		{
			int element=Integer.parseInt(type)-1;
			int facing;
			if(dir.equals(Direction.right))
				facing=0;
			else if(dir.equals(Direction.down))
				facing=1;
			else if(dir.equals(Direction.left))
				facing=2;
			else//Direction.up
				facing=3;
			
			
			Image img=Sprite.getSprite(element, facing, "entities").getScaledInstance(32, 32, BufferedImage.SCALE_FAST);
			g.drawImage(img, x, y, null);
		}
		/*
		g.setColor(Color.red);
			g.fillRect(pos[0][0], pos[0][1], 4, 4);
		g.setColor(Color.orange);
			g.fillRect(pos[1][0], pos[1][1], 4, 4);
		g.setColor(Color.cyan);
			g.fillRect((x/Game.TileSize)*Game.TileSize, (y/Game.TileSize)*Game.TileSize, 2, 2);*/
	}
	public void setPTVars(PlayerTempVars PTVars)
	{
		type=PTVars.type;
		Class=PTVars.Class;
		health=PTVars.health;
		cashMoney=PTVars.cash;
		mana=PTVars.mana;
	}
}