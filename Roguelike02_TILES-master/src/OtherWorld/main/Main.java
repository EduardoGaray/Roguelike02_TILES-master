package OtherWorld.main;

import OtherWorld.screen.Screen;
import OtherWorld.screen.StartScreen;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        Screen screen = new StartScreen();
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("2D ROGUELIKE");

        GamePanel gamePanel = new GamePanel();
        gamePanel.screen = screen;

        window.add(gamePanel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.startGameThread();

    }

}
