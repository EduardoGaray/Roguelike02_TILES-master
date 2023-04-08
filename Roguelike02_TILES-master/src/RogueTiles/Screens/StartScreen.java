package RogueTiles.Screens;

import RogueTiles.Main.TilesPanel;
import asciiPanel.AsciiPanel;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class StartScreen implements Screen {

	public void displayOutput(AsciiPanel terminal) {
		terminal.write("rl tutorial", 1, 1);
		terminal.writeCenter("-- press [enter] to start --", 22);
	}

	@Override
	public void displayOutput(TilesPanel tp) {

	}

	public void displayOutput(Graphics2D g2) {
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN,80f));
		String title = "Roguelike Project";
		String subTitle = "-- Press [enter] to start --";

		g2.drawString("Roguelike Project", 10,22);
		g2.drawString("-- Press [enter] to start --", 10,44);
	}

	public Screen respondToUserInput(KeyEvent key) {
		return key.getKeyCode() == KeyEvent.VK_ENTER ? new PlayScreen() : this;
	}
}