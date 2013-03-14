package entities;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Utils {
	public static Image getImage(String imageName, Class context) {
		return new ImageIcon(context.getResource("/res/"+imageName)).getImage();
	}
}
