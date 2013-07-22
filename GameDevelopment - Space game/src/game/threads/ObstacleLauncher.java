package game.threads;

import game.listeners.ObstacleListener;

import java.util.ArrayList;


public class ObstacleLauncher implements Runnable {
	private ArrayList<ObstacleListener> obsListeners;
	private boolean running;
	
	public ObstacleLauncher() {
		obsListeners = new ArrayList<ObstacleListener>();
		this.running = true;
	}
	
	public void addObstacleListener(ObstacleListener o) {
		this.obsListeners.add(o);
	}
	
	@Override
	public void run() {
		while(running) {
			try {
				Thread.sleep(3000);
				for(ObstacleListener o : obsListeners) 
					o.onLaunchAsteroid();
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void setRunning(boolean running) {
		this.running = running;
	}
	
	public boolean isRunning() {
		return running;
	}
}
