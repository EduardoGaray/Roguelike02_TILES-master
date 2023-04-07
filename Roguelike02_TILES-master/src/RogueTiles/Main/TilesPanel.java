package RogueTiles.Main;


import RogueTiles.Screens.Screen;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class TilesPanel extends JPanel implements Runnable {

    //SCREEN SETTINGS
    public final int originalTileSize = 16; //16x16 tile
    public final int scale = 3; // scale to resolution

    public int tileSize = originalTileSize * scale; //48x48 tile
    public int maxScreenCol = 16; // ^ v
    public int maxScreenRow = 12; // <>
    public int screenWidth = tileSize * maxScreenCol; //768 px
    public int screenHeight = tileSize * maxScreenRow; //576 px

    //WORLD SETTINGS
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;

    private Screen screen;

    //FPS
    int fps = 60;

    KeyHandler keyH = new KeyHandler(this);
    Thread gameThread; //When we call this thread, it automatically calls its run() method

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public TilesPanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void paint(Graphics g, Image img) {
        g.drawImage(img, 16,16,this);
    }

    public Image createTile() {
        BufferedImage image = null;
        try {
            File img = new File("Roguelike02_TILES-master/res/tiles/grass.png");
            image = ImageIO.read(img);
            //System.out.println(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    public Image createText() {
        BufferedImage bufferedImage = new BufferedImage(200,200,BufferedImage.TYPE_INT_RGB);
        Graphics g = bufferedImage.getGraphics();

        g.drawString("hghgghghhg", 20,20);

        return bufferedImage;
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

    private void update() {
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        screen.displayOutput(g2);
        g2.dispose();
    }

}