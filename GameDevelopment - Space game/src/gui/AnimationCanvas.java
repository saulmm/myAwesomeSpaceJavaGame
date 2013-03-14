package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

import entities.Asteroid;
import entities.Craft;
import entities.Missile;
import entities.Obstacles;
import entities.Space;
import entities.Space.Star;

import listeners.ResizeListener;


public class AnimationCanvas extends JPanel implements Runnable, ResizeListener {
	private static final long serialVersionUID = 1L;
	private final static int DELAY = 30;
	
	private Thread animationThread;
	private Thread asteroidLauncher; 
	
	private Craft craft;
	private Space space;
	private boolean running;
	private Obstacles obstacles;
	
	
	public AnimationCanvas() {
		this.addKeyListener(new TAdapter());
		this.setFocusable(true);
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		
		this.craft = new Craft();
		this.space = new Space();
		this.obstacles = new Obstacles();
		this.animationThread = new Thread(this);
		
		//Refactor
		obstacles.addAsteroid();
	}
	
	@Override
	public void addNotify() {
		super.addNotify();
		this.animationThread.start();
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
			g2d.fillOval(s.getX(), s.getY(), s.getDIAMETER(), s.getDIAMETER());
		}
		
		g2d.drawImage(craft.getCraftImage(), craft.getX(), craft.getY(), this);
	
		for(Missile m : craftMissiles) {
			g2d.drawImage(m.getMissileImage(), m.getX(), m.getY() - m.getImageHeight(), null);
		}
		
		for(Asteroid a : asteroids) {
			g2d.drawImage(a.getAsteroidImg(), a.getX(), a.getY(), this);
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

}


