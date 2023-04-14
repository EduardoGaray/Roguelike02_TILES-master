package OtherWorld.screen;

import OtherWorld.main.GamePanel;
import OtherWorld.main.World;
import OtherWorld.main.WorldBuilder;
import OtherWorld.tile.Tile_old;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class PlayScreen implements Screen {

    GamePanel gp;
    private World world;
    private int centerX;
    private int centerY;
    private int screenWidth;
    private int screenHeight;

    @Override
    public void displayOutput(Graphics2D g2, GamePanel gp) {
        int left = getScrollX();
        int top = getScrollY();
        displayTiles(g2, left, top);
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()){
            case KeyEvent.VK_ESCAPE: return new LoseScreen();
            case KeyEvent.VK_ENTER: return new WinScreen();
        }

        return this;
    }

    public PlayScreen(){
        GamePanel gp = new GamePanel();
        screenWidth = gp.screenWidth;
        screenHeight = gp.screenHeight;
        createWorld(gp);
    }

    private void createWorld(GamePanel gp){
        world = new WorldBuilder(gp.maxWorldCol, gp.maxWorldRow)
                .makeCaves()
                .build();
    }

    public int getScrollX() {
        return Math.max(0, Math.min(centerX - screenWidth / 2, world.width() - screenWidth));
    }

    public int getScrollY() {
        return Math.max(0, Math.min(centerY - screenHeight / 2, world.height() - screenHeight));
    }

    private void displayTiles(Graphics2D g2, int left, int top) {
        GamePanel gp = new GamePanel();
        for (int x = 0,screenX = 0; x < screenWidth; x++, screenX+=gp.tileSize){
            for (int y = 0, screenY = 0; y < screenHeight; y++, screenY+=gp.tileSize){
                int wx = x + left;
                int wy = y + top;
                int sx = screenX + left;
                int sy = screenY + top;
                String file = world.file(wx,wy);
                BufferedImage image;
                try {
                    image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(file)));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                g2.drawImage(image, sx, sy, gp.tileSize, gp.tileSize, null);
                System.out.println("Tile: "+file + "x: "+x+" y: "+y);
                //terminal.write(world.glyph(wx, wy), x, y, world.color(wx, wy));
            }
        }
    }


}
