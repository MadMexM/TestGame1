package com.testGame1.main;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.testGame1.game.Game;

public class Main {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Test Game");
		
		Game game = new Game();
		frame.getContentPane().add(game);

		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				if (JOptionPane.showConfirmDialog(frame, "Are you sure to exit the game?", "Exit Game?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
					game.setRunning(false);
					System.exit(0);
				}
			}
		});

		frame.setSize(800, 600);
		frame.setVisible(true);
		frame.setResizable(false);
	}

}
