package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import listeners.ResizeListener;


public class MyFrame extends JFrame implements ComponentListener {
	public static Dimension FRAME_DIMENSION = new Dimension(800,500);
	private ArrayList<ResizeListener> rListeners;
	
	public MyFrame() {
		setProperties();
		initComponents();
	}

	private void setProperties() {
		this.setBackground(Color.DARK_GRAY);
		this.setSize(FRAME_DIMENSION);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addComponentListener(this);
	}
	
	private void initComponents() {
		this.rListeners = new ArrayList<ResizeListener>();
		AnimationCanvas myCanvas = new AnimationCanvas();
		this.rListeners.add(myCanvas);
		this.add(myCanvas);
	}

	public void addResizeListener(ResizeListener r) {
		rListeners.add(r);
	}
	
	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentResized(ComponentEvent e) {
		FRAME_DIMENSION = new Dimension(this.getWidth(), this.getHeight());
	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

}
