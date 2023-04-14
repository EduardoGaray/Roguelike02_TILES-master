package OtherWorld.tile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public enum Tile {
    FLOOR("/tiles/grass.png"),
    WALL("/tiles/tree.png"),
    BOUNDS("/tiles/water.png");

    String file;
    int height = 48;

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

    int width = 48;
    Tile(String file) {
        this.file = file;
        this.width = width;
        this.height = height;
    }

}
