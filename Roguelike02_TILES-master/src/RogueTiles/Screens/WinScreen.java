package RogueTiles.Screens;

import RogueTiles.Main.TilesPanel;
import asciiPanel.AsciiPanel;

import java.awt.event.KeyEvent;

public class WinScreen implements Screen {

	 public void displayOutput(AsciiPanel terminal) {
	        terminal.write("You won.", 1, 1);
	        terminal.writeCenter("-- press [enter] to restart --", 22);
	    }

	@Override
	public void displayOutput(TilesPanel tp) {

	}

	public Screen respondToUserInput(KeyEvent key) {
	        return key.getKeyCode() == KeyEvent.VK_ENTER ? new PlayScreen() : this;
	    }
}
