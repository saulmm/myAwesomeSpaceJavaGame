package entities;

import java.util.ArrayList;

public class Obstacles {
	public ArrayList<Asteroid> asteroids;
	
	public Obstacles() {
		asteroids = new ArrayList<Asteroid>();
	}
	
	public void addAsteroid() {
		asteroids.add(new Asteroid());
	}
	
	public void moveAsteroids() {
		for(Asteroid a : asteroids) {
			a.move();
		}
	}
	
	public ArrayList<Asteroid> getAsteroids() {
		return asteroids;
	}
	
}
