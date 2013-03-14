package entities;

import gui.MyFrame;

import java.awt.Image;
import java.util.Random;

import Core.Configuration;
import Core.Difficulties;

public class Asteroid {
	private final int SPEED;
	private int x;
	private int y;
	private Image asteroidImg;
	private boolean visible;
	
	public Asteroid() {
		SPEED = new Random().nextInt(10) + getRangeOfDifficulty();;
		
		this.asteroidImg = Utils.getImage("asteroid.png", this.getClass());
		this.x = MyFrame.FRAME_DIMENSION.width;
		this.y = new Random().nextInt(MyFrame.FRAME_DIMENSION.height);

		this.visible = true;
		
		// Debug
		System.out.println("Asteroid.Asteroid() speed : "+SPEED);
	}
	
	public void move() {		
		if(x == (0 - asteroidImg.getWidth(null))) {
			this.visible = false;
		
		} else {
			x -= SPEED;

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

	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Image getAsteroidImg() {
		return asteroidImg;
	}

	public boolean isVisible() {
		return visible;
	}

	@Override
	public String toString() {
		return "Asteroid [SPEED=" + SPEED + ", x=" + x + ", y=" + y
				+ ", asteroidImg=" + asteroidImg + ", visible=" + visible + "]";
	}
	
	
}
