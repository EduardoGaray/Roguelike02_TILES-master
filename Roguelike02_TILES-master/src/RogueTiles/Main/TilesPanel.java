package RogueTiles.Main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class TilesPanel extends JPanel implements Runnable {

    //FPS
    int fps = 60;
    Thread gameThread; //When we call this thread, it automatically calls its run() method


    public void paint(Graphics g, Image img) {
        img = createTile();
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

    private Image createText() {
        BufferedImage bufferedImage = new BufferedImage(200,200,BufferedImage.TYPE_INT_RGB);
        Graphics g = bufferedImage.getGraphics();

        g.drawString("www.tutorialspoint.com", 20,20);

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
                System.out.println("FPS:" + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    private void update() {
    }

}