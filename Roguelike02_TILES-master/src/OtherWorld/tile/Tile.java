package OtherWorld.tile;

import OtherWorld.main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public enum Tile {
    FLOOR("/tiles/grass.png","floor"),
    WALL("/tiles/tree.png","wall"),
    BOUNDS("/tiles/water.png","bounds");

    String file;
    String type;
    int height;
    int width;

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    Tile(String file, String type) {
        GamePanel gp = new GamePanel();
        this.file = file;
        this.width = gp.tileSize;
        this.height = gp.tileSize;
        this.type = type;
    }

}
