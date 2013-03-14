package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;

import javax.swing.JPanel;

import threads.ObstacleLauncher;

import entities.Asteroid;
import entities.Craft;
import entities.Missile;
import entities.Obstacles;
import entities.Space;
import entities.Space.Star;

import listeners.ObstacleListener;
import listeners.ResizeListener;


public class AnimationCanvas extends JPanel implements Runnable, ResizeListener, ObstacleListener {
	private static final long serialVersionUID = 1L;
	private final static int DELAY = 30;
	
	private Thread animationThread;
	private Thread asteroidLauncher; 
	
	private Craft craft;
	private Space space;
	private boolean running;
	private Obstacles obstacles;
	private ObstacleLauncher obstacleLauncher;
	
	
	public AnimationCanvas() {
		this.addKeyListener(new TAdapter());
		this.setFocusable(true);
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		
		this.craft = new Craft();
		this.space = new Space();
		this.obstacles = new Obstacles();
		this.animationThread = new Thread(this);
		this.obstacleLauncher = new ObstacleLauncher();
		this.asteroidLauncher = new Thread(obstacleLauncher);
		this.obstacleLauncher.addObstacleListener(this);
		
		//Refactor
//		obstacles.addAsteroid();

	}
	
	@Override
	public void addNotify() {
		super.addNotify();
		this.animationThread.start();
		this.asteroidLauncher.start();
		this.running = true;
	}
	
	
	
	@Override
	public void run() {
		while(running) {
			this.space.move();
			
			ArrayList<Missile> craftMissle = craft.getMissiles();
			
			for(Missile m : craftMissle) {
				if(m.isVisible()) {
					m.move();
				}
			}
			
			sleepThread();
			craft.move();
			obstacles.moveAsteroids();
			this.repaint();
			
			
		}
	}

	private void sleepThread() {
		try {
			Thread.sleep(DELAY);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		Graphics2D g2d = (Graphics2D) g;
		ArrayList<Missile> craftMissiles = craft.getMissiles();
		ArrayList<Star> stars = space.getStars();
		ArrayList<Asteroid> asteroids = obstacles.getAsteroids();
	
		for(Star s : stars) {
			g2d.setColor(Color.white);
			g2d.fillOval(
					s.getX(), 
					s.getY(), 
					s.DIAMETER, 
					s.DIAMETER);
		}
		
		g2d.drawImage(
				craft.getCraftImage(), 
				craft.getX(), 
				craft.getY(), 
				this);
	
		for(Missile m : craftMissiles) {
			g2d.drawImage(
					m.getMissileImage(), 
					m.getX(), 
					m.getY() - m.getImageHeight(), 
					null);
		}
		
		// To do
		try {
			for (Asteroid a : asteroids) {
				g2d.drawImage(
						a.getAsteroidImg(), 
						a.getX(), 
						a.getY(), 
						this);
			}
		} catch (ConcurrentModificationException e) {
			System.err.println(e.getMessage());
		}
		
	}

	private class TAdapter extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			craft.keyPressed(e);
		}
		
		
		@Override
		public void keyReleased(KeyEvent e) {
			craft.keyReleased(e);
		}
	}

	@Override
	public void onResize(Dimension newDimension) {
//		space.resize();
//		craft.resize();
	}

	@Override
	public void onLaunchAsteroid() {
		obstacles.addAsteroid();

	}

}


