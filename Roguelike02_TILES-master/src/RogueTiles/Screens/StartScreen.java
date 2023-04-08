package RogueTiles.Screens;

import RogueTiles.Main.TilesPanel;
import asciiPanel.AsciiPanel;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class StartScreen implements Screen {

	public void displayOutput(AsciiPanel terminal) {
		terminal.write("rl tutorial", 1, 1);
		terminal.writeCenter("-- press [enter] to start --", 22);
	}

	@Override
	public void displayOutput(TilesPanel tp) {

	}

	public void displayOutput(Graphics2D g2, TilesPanel tp) {

		//WINDOW
		int x = tp.tileSize *2;
		int y = tp.tileSize /2;
		int width = tp.screenWidth - (tp.tileSize *4);
		int height = tp.tileSize *5;

		Color c = new Color(0,0,0);
		g2.setColor(c);
		g2.fillRoundRect(x,y,width,height,35,35);

		c = new Color(255,255,255);
		g2.setColor(c);
		g2.setStroke(new BasicStroke(3));
		g2.drawRoundRect(x+5,y+5,width-10,height-10,25,25);
		g2.setFont(tp.mainFont.deriveFont(35f));
		String title = "Roguelike Project";
		g2.drawString(title, width /2,height /2);
		String subTitle = "-- Press [enter] to start --";
		g2.setFont(tp.mainFont.deriveFont(24f));
		g2.drawString(subTitle, 10,44);
	}

	public Screen respondToUserInput(KeyEvent key) {
		return key.getKeyCode() == KeyEvent.VK_ENTER ? new PlayScreen() : this;
	}
}