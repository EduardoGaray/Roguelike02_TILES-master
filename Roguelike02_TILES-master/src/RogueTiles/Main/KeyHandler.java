package RogueTiles.Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean upPressed, downPressed, leftPressed, rightPressed;
    TilesPanel tp;

    public KeyHandler(TilesPanel tp) {

        this.tp = tp;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        tp.setScreen(tp.getScreen().respondToUserInput(e));
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
