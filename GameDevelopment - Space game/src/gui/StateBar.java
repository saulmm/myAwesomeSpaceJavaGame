package gui;

import java.awt.Image;

import entities.Utils;

public class StateBar {
	private Image barImg;
	
	public StateBar(String barSource) {
		barImg = Utils.getImage(barSource+".png", getClass());
	}
	
	public Image getBarImg() {
		return barImg;
	}
}
