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
		tp = new TilesPanel();
		this.getContentPane().add(tp);
		tp.startGameThread();
		pack();
		screen = new StartScreen();
		addKeyListener(this);
		repaint();
	}

	public void repaint() {
		//terminal.clear();
		//screen.displayOutput(terminal);
		//tp.clear();
		screen.displayOutput(tp);
		super.repaint();
	}

	public void keyPressed(KeyEvent e) {
		screen = screen.respondToUserInput(e);
		repaint();
	}


	public void keyReleased(KeyEvent e) {
	}

	public void keyTyped(KeyEvent e) {
//		screen = screen.respondToUserInput(e);
//		repaint();
	}

	public static void main(String[] args) {
		ApplicationMain app = new ApplicationMain();
		app.setSize(200, 200);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);

	}
}