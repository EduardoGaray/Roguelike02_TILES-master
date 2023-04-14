package OtherWorld.main;

import OtherWorld.screen.Screen;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean upPressed, downPressed, leftPressed, rightPressed;
    GamePanel gp;


    public KeyHandler(GamePanel gp) {
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        gp.screen = gp.screen.respondToUserInput(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
