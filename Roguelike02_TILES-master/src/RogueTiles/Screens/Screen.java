package RogueTiles.Screens;

import RogueTiles.Main.TilesPanel;
import asciiPanel.AsciiPanel;

import java.awt.*;
import java.awt.event.KeyEvent;

public interface Screen {
	
	public void displayOutput(AsciiPanel terminal);

    public void displayOutput(TilesPanel tp);

	public Screen respondToUserInput(KeyEvent key);

    public void displayOutput(Graphics2D g2);
}
