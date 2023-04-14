package OtherWorld.screen;

import OtherWorld.main.GamePanel;

import java.awt.*;
import java.awt.event.KeyEvent;

public class WinScreen implements Screen{
    @Override
    public void displayOutput(Graphics2D g2, GamePanel gp) {
        System.out.println("WIN SCREEN");
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        return key.getKeyCode() == KeyEvent.VK_ENTER ? new PlayScreen() : this;
    }
}
