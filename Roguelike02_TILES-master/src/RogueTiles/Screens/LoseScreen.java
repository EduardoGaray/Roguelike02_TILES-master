package RogueTiles.Screens;

import RogueTiles.Main.TilesPanel;
import asciiPanel.AsciiPanel;

import java.awt.event.KeyEvent;

public class LoseScreen implements Screen {

	public void displayOutput(AsciiPanel terminal) {
		terminal.write("You lost.", 1, 1);
		terminal.writeCenter("-- press [enter] to restart --", 22);
	}

	@Override
	public void displayOutput(TilesPanel tp) {

	}

	public Screen respondToUserInput(KeyEvent key) {
		return key.getKeyCode() == KeyEvent.VK_ENTER ? new PlayScreen() : this;
	}

}
