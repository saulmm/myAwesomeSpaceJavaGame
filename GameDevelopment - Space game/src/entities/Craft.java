package entities;

import gui.MyFrame;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;



public class Craft {
	private final int SPEED = 6;
// Example commit
	private String craftSource = "craft.png";
	private Image craftImage;
	private ArrayList<Missile> missiles;
	private int deltaX;
	private int deltaY;
	private int x;
	private int y;

	public Craft() {
		x = 40;
		y = 60;

		craftImage = new ImageIcon(this.getClass()
				.getResource("/res/"+craftSource)).getImage();

		missiles = new ArrayList<Missile>();
		
	
	}
	
	public void move() {
		int limit_left = 0; 
		int limit_top = 0;
		int limit_right = MyFrame.FRAME_DIMENSION.width - craftImage.getWidth(null); 
		int limit_bottom = MyFrame.FRAME_DIMENSION.height - craftImage.getHeight(null);

		x += deltaX;
		y += deltaY;
	
		if(x >= limit_right) {
			deltaX = -1;
		}
		
		if(x < limit_left) {
			deltaX = 1;
		}
		
		if(y >= limit_bottom) {
			deltaY = -1;
		}
		
		if(y <= limit_top) {
			deltaY = 1;
		}

	}

	public String getCraftSource() {
		return craftSource;
	}

	public Image getCraftImage() {
		return craftImage;
	}

	public int getSpeedX() {
		return deltaX;
	}

	public int getSpeedY() {
		return deltaY;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	// Se dispará siempre que no haya mas de 10 misiles y todos hallan llegado al final
	public void fire() {
		boolean missileVisible = false;

		if(missiles.size() >= 10) {
			for(Missile m : missiles) {
				if(m.isVisible()) {
					missileVisible = true;
					break;
				}
			}
			
			if(!missileVisible) {
				missiles.removeAll(missiles);
			}
			
		} else {
			missiles.add(new Missile(
					x + craftImage.getWidth(null), 
					y + (craftImage.getHeight(null) / 2)));
		}
	}
	
	public ArrayList<Missile> getMissiles() {
		return missiles;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
	
		if (key == KeyEvent.VK_LEFT) {
			deltaX= -SPEED;
		}

		if (key == KeyEvent.VK_RIGHT) {
			deltaX = SPEED;
		}

		if (key == KeyEvent.VK_UP) {
			deltaY = -SPEED + 1;
		}

		if (key == KeyEvent.VK_DOWN) {
			deltaY = SPEED + 1;
		}
		
		if (key == KeyEvent.VK_SPACE) {
			fire();
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT) {
			deltaX = 0;
		}

		if (key == KeyEvent.VK_RIGHT) {
			deltaY = 0;
		}

		if (key == KeyEvent.VK_UP) {
			deltaY = 0;
		}

		if (key == KeyEvent.VK_DOWN) {
			deltaY = 0;
		}
	}	
	
	public Rectangle getBounds() {
		return new Rectangle(
				x, 
				y, 
				craftImage.getWidth(null), 
				craftImage.getHeight(null));
	}

	public void collision() {
			craftImage = Utils.getImage(craftSource, getClass());
		
		craftSource = "craft_collision.png";
	}
	
	public void alive() {
			craftImage = Utils.getImage(craftSource, getClass());

		
		craftSource = "craft.png";
	}
	
	
}
