package com.testGame1.player;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.testGame1.game.Game;
import com.testGame1.utils.DirectionType;

public class Player extends Thread {
	private Game game;
	private boolean gameRunning;

	// Player images
	private Image walkRightImages[];
	private Image idleRightImages[];

	private int xPosition;
	private int yPosition;

	private boolean moving;
	private DirectionType direction;
	private DirectionType currentDirection;

	private int width;
	private int height;

	private int imageNumber;
	private int totalNumberOfImages;

	public Player(Game game) {
		this.game = game;
		playerInitializer();
	}

	private void playerInitializer() {
		gameRunning = true;
		xPosition = 1;
		yPosition = 1;
		width = 80;
		height = 80;
		direction = DirectionType.IDLE;
		currentDirection = direction;
		setUpImages();
	}

	private void setUpImages() {
		totalNumberOfImages = 10;
		walkRightImages = new Image[totalNumberOfImages];
		idleRightImages = new Image[totalNumberOfImages];
		try {
			for (int i = 0; i < totalNumberOfImages; i++) {
				BufferedImage bufferedImage = ImageIO.read(new File("resources/player/walk/Walk (" + (i + 1) + ").png"));
				BufferedImage bufferedImage2 = ImageIO.read(new File("resources/player/idle/Idle (" + (i + 1) + ").png"));
				walkRightImages[i] = Toolkit.getDefaultToolkit().createImage(bufferedImage.getSource());
				idleRightImages[i] = Toolkit.getDefaultToolkit().createImage(bufferedImage2.getSource());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void draw(Graphics graphics) {
		moveCharacter();
		switch (direction) {
		case RIGHT:
			graphics.drawImage(walkRightImages[imageNumber], xPosition, yPosition, width, height, game);
			break;
		case LEFT:
			graphics.drawImage(walkRightImages[imageNumber], xPosition, yPosition, width, height, game);
			break;
		case UP:
			graphics.drawImage(walkRightImages[imageNumber], xPosition, yPosition, width, height, game);
			break;
		case DOWN:
			graphics.drawImage(walkRightImages[imageNumber], xPosition, yPosition, width, height, game);
			break;
		case IDLE:
			graphics.drawImage(idleRightImages[imageNumber], xPosition, yPosition, width, height, game);
			break;
		default:
			break;
		}	
		
		try {
			Thread.sleep(60);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	private void moveCharacter() {
		if (moving) {
			int steps = 5; // move this amount of pixels
			switch (direction) {
			case RIGHT:
				xPosition += steps;
				break;
			case LEFT:
				xPosition -= steps;
				break;
			case UP:
				yPosition -= steps;
				break;
			case DOWN:
				yPosition += steps;
				break;
			default:
				break;
			}			
		}
		
		if(currentDirection != direction) {
			currentDirection = direction;
			imageNumber = 0;
		}else {
			if(imageNumber == totalNumberOfImages -1) {
				imageNumber = 0;
			}else {
				imageNumber++;
			}
		}
	}
	
	public void run() {
		while(gameRunning) {
			try {
				if (moving) {
					Thread.sleep(1000 / totalNumberOfImages);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	public boolean isGameRunning() {
		return gameRunning;
	}

	public void setGameRunning(boolean gameRunning) {
		this.gameRunning = gameRunning;
	}

	public int getxPosition() {
		return xPosition;
	}

	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	public int getyPosition() {
		return yPosition;
	}

	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}

	public DirectionType getDirection() {
		return direction;
	}

	public void setDirection(DirectionType direction) {
		this.direction = direction;
	}

	public boolean isMoving() {
		return moving;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}
}
