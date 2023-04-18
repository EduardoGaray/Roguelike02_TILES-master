package OtherWorld.tile;

import OtherWorld.main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

public class TileManager {

    BufferedImage floor;
    BufferedImage wall;
    BufferedImage bounds;

    public BufferedImage getFloor() {
        return floor;
    }

    public void setFloor(BufferedImage floor) {
        this.floor = floor;
    }

    public BufferedImage getWall() {
        return wall;
    }

    public void setWall(BufferedImage wall) {
        this.wall = wall;
    }

    public BufferedImage getBounds() {
        return bounds;
    }

    public void setBounds(BufferedImage bounds) {
        this.bounds = bounds;
    }

    public TileManager() {
        getTileImage();
    }

    //this method generates basic tiles randomly, we can work on a more complex system for map generation from here
    public void getTileImage() {
        try {

            floor = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/grass.png")));
            wall = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/wall00.png")));
            bounds = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/water.png")));

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
