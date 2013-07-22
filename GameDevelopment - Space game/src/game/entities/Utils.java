package game.entities;

import game.core.Configuration;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Utils {
	public static Image getImage(String imageName, Class context) {
		return new ImageIcon(context.getResource(Configuration.RESOURCE_PATH+imageName)).getImage();
	}
}
