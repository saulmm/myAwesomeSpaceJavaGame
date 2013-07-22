package game.core;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.omg.Dynamic.Parameter;


import game.gui.MyFrame;

public class Core {
	private final static Logger log = Logger.getLogger(Core.class);

	
	public static void main(String [] args) {
		PropertyConfigurator.configure("log_confs/log_conf.properties");
		Configuration.DIFFICULTY = Difficulties.VERY_EASY;
		
		log.info("Starting game...");

		MyFrame frame = new MyFrame();
		frame.setVisible(true);
	}
}
