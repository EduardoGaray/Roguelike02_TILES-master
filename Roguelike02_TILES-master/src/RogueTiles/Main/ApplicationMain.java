package RogueTiles.Main;

import javax.swing.*;

import RogueTiles.Screens.Screen;
import RogueTiles.Screens.StartScreen;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ApplicationMain extends JFrame {
	private static final long serialVersionUID = 1060623638149583738L;
	private TilesPanel tp;
	private Screen screen;

	public ApplicationMain() {
		super();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setTitle("2D ROGUELIKE");
		screen = new StartScreen();
		tp = new TilesPanel();
		tp.setScreen(screen);
		this.add(tp);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		tp.startGameThread();
	}


	public static void main(String[] args) {
		ApplicationMain app = new ApplicationMain();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);

	}
}