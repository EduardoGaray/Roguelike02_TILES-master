package OtherWorld.screen;

import OtherWorld.main.GamePanel;

import java.awt.*;
import java.awt.event.KeyEvent;

public class PlayScreen implements Screen {


    @Override
    public void displayOutput(Graphics2D g2, GamePanel gp) {
        System.out.println("PLAY SCREEN");
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        return null;
    }
}
