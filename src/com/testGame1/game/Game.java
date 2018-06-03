package com.testGame1.game;

import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import com.testGame1.player.Player;
import com.testGame1.utils.DirectionType;
import com.testGame1.world.World;

public class Game extends JPanel implements KeyListener {
	private String gameState;
	private AnimationThread animationThread;
	private boolean running;
	
	private World world;
	private Player player;

	public Game() {
		gameInitializer();
	}
	
	/**
	 * This will initialize the game.
	 */
	private void gameInitializer() {
		gameState = "start";  // TODO make enum
		running = true;
		
		world = new World(this);
		
		player = new Player(this);
		player.start();
		
		animationThread = new AnimationThread(this, 60);
		animationThread.start();
		
		addKeyListener(this);
		setFocusable(true);
	}

	public Game(LayoutManager arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	
	public void exitGame() {
		running = false;
		player.setGameRunning(false);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if(gameState.equals("start")) {
			world.draw(g);
			player.draw(g);
		}
	}
	
	@Override
	public void keyPressed(KeyEvent key) {
		char letter = key.getKeyChar();
		int letterCode = (int) letter;
		
		switch(letterCode) {
		case 119: // w
			player.setDirection(DirectionType.UP);
			player.setMoving(true);
			break;
		case 97: // a
			player.setDirection(DirectionType.LEFT);
			player.setMoving(true);
			break;
		case 115: // s
			player.setDirection(DirectionType.DOWN);
			player.setMoving(true);
			break;
		case 100: // d
			player.setDirection(DirectionType.RIGHT);
			player.setMoving(true);
			break;
		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		player.setDirection(DirectionType.IDLE);
		player.setMoving(false);
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

}
