package game.gui;

import java.awt.Image;

import game.entities.Utils;

public class StateBar {
	private Image barImg;
	
	public StateBar(String barSource) {
		barImg = Utils.getImage(barSource+".png", getClass());
	}
	
	public Image getBarImg() {
		return barImg;
	}
	
	public int getBarWidth() {
		return barImg.getWidth(null);
	}
}
