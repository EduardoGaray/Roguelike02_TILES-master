package OtherWorld.main;

import OtherWorld.entity.Player;
import OtherWorld.screen.Screen;
import OtherWorld.tile.TileManager;
import RogueAscii.Screens.StartScreen;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    //SCREEN SETTINGS
    public final int originalTileSize = 16; //16x16 tile
    public final int scale = 2; // scale to resolution

    public int tileSize = originalTileSize * scale; //48x48 tile
    public int screenWidth = 640; //min res 640
    public int screenHeight = 480; // min res 480

    public int maxScreenCol = screenHeight / tileSize; // ^ v
    public int maxScreenRow = screenWidth / tileSize; // <>

    //WORLD SETTINGS
    public final int maxWorldCol = 100;
    public final int maxWorldRow = 100;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;

    //SCREEN
    public Screen screen;

    //FPS
    int fps = 60;

    KeyHandler keyH = new KeyHandler(this);
    Thread gameThread; //When we call this thread, it automatically calls its run() method
    public Player player = new Player(this, keyH);

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void zoomInOut(int i) {

        int oldWorldWidth = tileSize * maxWorldCol;
        tileSize += i;
        int newWorldWidth = tileSize * maxWorldCol;

        player.speed = (double)newWorldWidth/600;
        double multiplier = (double) newWorldWidth / oldWorldWidth;
        double newPlayerWorldX = player.worldX * multiplier;
        double newPlayerWorldY = player.worldY * multiplier;

        player.worldX = newPlayerWorldX;
        player.worldY = newPlayerWorldY;

    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000 / fps;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;
        while (gameThread != null) {

            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta > 1) {
                update();
                repaint();
                delta--;
                drawCount++;
            }

            if (timer >= 1000000000) {
                //System.out.println("FPS:" + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void update() {
        player.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        screen.displayOutput(g2,this);
        g2.dispose();
    }

}
