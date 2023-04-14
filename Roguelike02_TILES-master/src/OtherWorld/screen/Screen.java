package OtherWorld.screen;

import OtherWorld.main.GamePanel;

import java.awt.*;
import java.awt.event.KeyEvent;

public interface Screen {
    public void displayOutput(Graphics2D g2, GamePanel gp);

    public Screen respondToUserInput(KeyEvent key);

}
