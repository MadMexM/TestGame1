package com.testGame1.game;

import javax.swing.JPanel;

public class AnimationThread extends Thread {

	private Game panel;
	private int frameRate;
	
	public AnimationThread(JPanel p, int fr) {
		panel = (Game) p;
		frameRate = fr;
	}
	
	public void run() {
		while(panel.isRunning()) {
			panel.repaint();
			
			try {
				Thread.sleep(1000 / frameRate);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
