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
		g2.drawString("rl tutorial", 1,1);
		g2.drawString("-- press [enter] to start --", 1,22);
	}

	public Screen respondToUserInput(KeyEvent key) {
		return key.getKeyCode() == KeyEvent.VK_ENTER ? new PlayScreen() : this;
	}
}