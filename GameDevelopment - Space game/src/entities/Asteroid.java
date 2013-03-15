package entities;

import gui.MyFrame;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import Core.Configuration;

public class Asteroid {
	private final int SPEED;
	private int posX;
	private int posY;
	private Image asteroidImg;
	private boolean visible;
	
	public Asteroid() {
		SPEED = new Random().nextInt(10) + getRangeOfDifficulty();;

		this.visible = true;
		this.posX = MyFrame.FRAME_DIMENSION.width;
		this.posY = new Random().nextInt(MyFrame.FRAME_DIMENSION.height);
		this.asteroidImg = Utils.getImage("asteroid.png", this.getClass());
		
		// Debug
		System.out.println("Asteroid.Asteroid() speed : "+SPEED);
	}
	
	public void move() {		
		if(posX == (0 - asteroidImg.getWidth(null))) {
			this.visible = false;
		
		} else {
			posX -= SPEED;

		}
	}
	
	private int getRangeOfDifficulty() {
		switch (Configuration.DIFFICULTY) {
		case VERY_EASY:
			return 3;
		case EASY:
			return 5;
		case HARD:
			return 10;
		case NORMAL:
			return 15;
		case VERY_HARD:
			return 20;
		default:
			return 0;
		}
	}

	
	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public Image getAsteroidImg() {
		return asteroidImg;
	}

	public boolean isVisible() {
		return visible;
	}

	@Override
	public String toString() {
		return "Asteroid [SPEED=" + SPEED + ", x=" + posX + ", y=" + posY
				+ ", asteroidImg=" + asteroidImg + ", visible=" + visible + "]";
	}
	
	
	public Rectangle getBounds() {
		return new Rectangle(
				posX, 
				posY, 
				(posX + asteroidImg.getWidth(null)),
				(posY + asteroidImg.getHeight(null) + posY));
	}
	
}
