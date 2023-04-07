package RogueTiles.Main;

import javax.swing.*;

import RogueTiles.Screens.Screen;
import RogueTiles.Screens.StartScreen;
import asciiPanel.AsciiPanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ApplicationMain extends JFrame implements KeyListener {
	private static final long serialVersionUID = 1060623638149583738L;

	private AsciiPanel terminal;

	private TilesPanel tp;
	private Screen screen;

	public ApplicationMain() {
		super();
		screen = new StartScreen();
		tp = new TilesPanel();
		tp.setScreen(screen);
		this.getContentPane().add(tp);
		tp.startGameThread();
		pack();
		addKeyListener(this);
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	public void keyPressed(KeyEvent e) {
		screen = screen.respondToUserInput(e);
		tp.setScreen(screen);
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	public static void main(String[] args) {
		ApplicationMain app = new ApplicationMain();
		app.setSize(200, 200);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);

	}
}