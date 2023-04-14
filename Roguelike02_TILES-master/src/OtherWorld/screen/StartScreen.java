package OtherWorld.screen;

import OtherWorld.main.GamePanel;
import OtherWorld.screen.PlayScreen;

import java.awt.*;
import java.awt.event.KeyEvent;

public class StartScreen implements Screen {
    @Override
    public void displayOutput(Graphics2D g2, GamePanel gp) {
        System.out.println("START SCREEN");
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {

        return key.getKeyCode() == KeyEvent.VK_ENTER ? new PlayScreen() : this;
    }
}
