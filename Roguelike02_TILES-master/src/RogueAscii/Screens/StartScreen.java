package RogueAscii.Screens;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import RogueTiles.Main.TilesPanel;
import asciiPanel.AsciiPanel;

public class StartScreen implements Screen {

	public void displayOutput(AsciiPanel terminal) {
		terminal.write("rl tutorial", 1, 1);
		terminal.writeCenter("-- press [enter] to start --", 22);
	}

	public void displayOutput(TilesPanel tp) {
		Graphics g = tp.getGraphics();
		Image img = tp.createTile();
		tp.paint(g,img);
	}

	public Screen respondToUserInput(KeyEvent key) {
		return key.getKeyCode() == KeyEvent.VK_ENTER ? new PlayScreen() : this;
	}
}