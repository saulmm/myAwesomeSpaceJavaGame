package entities;

import gui.MyFrame;

import java.util.ArrayList;
import java.util.Random;

public class Space {
	private ArrayList<Star> stars;
	private final static int MAX_STARS = 50;
	
	public Space() {
		stars = new ArrayList<Space.Star>();
		for (int i = 0; i < MAX_STARS; i++) {
			stars.add(new Star());
		}
	}
	
	public ArrayList<Star> getStars() {
		return stars;
	}
	
	public void move() {
		for(Star s : stars) {
			s.move();
		}
	}
	
	
	
	public class Star {
		private final int SPEED;
		private final int DIAMETER;
		private int x;
		private int y;
		
		public Star() {
			SPEED = new Random().nextInt(50);
			DIAMETER = new Random().nextInt(5);
			x = MyFrame.FRAME_DIMENSION.width;
			y = new Random().nextInt(MyFrame.FRAME_DIMENSION.height);
		}
		
		private void move() {
			x -= SPEED;
			
			if(x <= 0) {
				x = MyFrame.FRAME_DIMENSION.width;
				y = new Random().nextInt(MyFrame.FRAME_DIMENSION.height);
			}
		}

		public int getSPEED() {
			return SPEED;
		}

		public int getDIAMETER() {
			return DIAMETER;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		@Override
		public String toString() {
			return "Star [SPEED=" + SPEED + ", DIAMETER=" + DIAMETER + ", x="
					+ x + ", y=" + y + "]";
		}
		
		
		
		
	}
	
}
