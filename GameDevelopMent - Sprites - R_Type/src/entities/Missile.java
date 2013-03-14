package entities;

import gui.MyFrame;

import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;

public class Missile {
	private int speed = 0;
	private Image missileImage;
	private boolean visible;
	private int x;
	private int y;

	public Missile(int x, int y) {
		speed = new Random().nextInt(20) + 3;

		this.visible = true;
		this.x = x;
		this.y = y;
		this.missileImage = new ImageIcon(this.getClass()
			.getResource("/res/missile.png")).getImage();
	}
	
	public void move() {
		this.x += speed;
		
		if(x >= MyFrame.FRAME_DIMENSION.width)
			visible = false;
	}
	
	public Image getMissileImage() {
		return missileImage;
	}


	public int getX() {
		return x;
	}


	public int getY() {
		return y;
	}
	
	public boolean isVisible() {
		return visible;
	}
	
	public int getImageHeight() {
		return missileImage.getHeight(null) / 2;
	}
}
