package gui;

import java.util.ArrayList;

public class ObstacleLauncher implements Runnable {
	private ArrayList<ObstacleListener> obsListeners;
	private boolean running;
	
	@Override
	public void run() {
		while(running) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
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
