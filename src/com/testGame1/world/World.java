package com.testGame1.world;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.testGame1.game.Game;

public class World {
	private Game game;
	private int map[][];
	
	public World(Game g) {
		game = g;
		worldInitializer();
	}
	
	private void worldInitializer() {
		
	}
	
	public void draw(Graphics graphics) {
		
		try {
			BufferedImage bufferedImage = ImageIO.read(new File("resources/map/pasto.jpg"));
			Image pasto = Toolkit.getDefaultToolkit().createImage(bufferedImage.getSource());
			for(int x = 0; x < 50; x++) {
				for(int y = 0; y < 50; y++) {
					graphics.drawImage( pasto, x*40, y*40, 40, 40, game);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
