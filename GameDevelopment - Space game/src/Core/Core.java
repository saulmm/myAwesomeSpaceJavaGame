package Core;

import org.omg.Dynamic.Parameter;

import gui.MyFrame;

public class Core {
	public static void main(String [] args) {
		Configuration.DIFFICULTY = Difficulties.VERY_EASY;
		
		MyFrame frame = new MyFrame();
		frame.setVisible(true);
	}
}
