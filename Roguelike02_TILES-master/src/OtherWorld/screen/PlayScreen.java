package OtherWorld.screen;

import OtherWorld.main.GamePanel;
import OtherWorld.main.World;
import OtherWorld.main.WorldBuilder;
import OtherWorld.tile.TileManager;
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
        int left = getScrollX(gp);
        int top = getScrollY(gp);
        displayTiles(g2, left, top);
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()){
            case KeyEvent.VK_ESCAPE: return new LoseScreen();
            case KeyEvent.VK_ENTER: return new WinScreen();
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_H: scrollBy(-1, 0); break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_L: scrollBy( 1, 0); break;
            case KeyEvent.VK_UP:
            case KeyEvent.VK_K: scrollBy( 0,-1); break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_J: scrollBy( 0, 1); break;
            case KeyEvent.VK_Y: scrollBy(-1,-1); break;
            case KeyEvent.VK_U: scrollBy( 1,-1); break;
            case KeyEvent.VK_B: scrollBy(-1, 1); break;
            case KeyEvent.VK_N: scrollBy( 1, 1); break;

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

    public int getScrollX(GamePanel gp) {
        return Math.max(0, Math.min(centerX - gp.maxScreenRow / 2, world.width() - gp.maxScreenRow));
    }

    public int getScrollY(GamePanel gp) {
        return Math.max(0, Math.min(centerY - gp.maxScreenCol / 2, world.height() - gp.maxScreenCol));
    }

    private void scrollBy(int mx, int my){
        centerX = Math.max(0, Math.min(centerX + mx, world.width() - 1));
        centerY = Math.max(0, Math.min(centerY + my, world.height() - 1));
    }

    private void displayTiles(Graphics2D g2, int left, int top) {
        GamePanel gp = new GamePanel();
        TileManager tm = new TileManager();

        for (int x = 0,screenX = 0; x < gp.maxScreenRow && screenX <= gp.screenWidth; x++, screenX+=gp.tileSize){
            for (int y = 0, screenY = 0; y < gp.maxScreenCol && screenY <= gp.screenWidth; y++, screenY+=gp.tileSize){
                int wx = x + left;
                int wy = y + top;
                int sx = screenX;
                int sy = screenY;
                String file = world.file(wx,wy);
                if(world.type(wx,wy) == "floor"){
                    g2.drawImage(tm.getFloor(), sx, sy, gp.tileSize, gp.tileSize, null);
                    //System.out.println("floor x: "+sx+" y: "+sy);
                }
                if(world.type(wx,wy) == "wall"){
                    g2.drawImage(tm.getWall(), sx, sy, gp.tileSize, gp.tileSize, null);
                    //System.out.println("wall x: "+sx+" y: "+sy);
                }
                if(world.type(wx,wy) == "bounds"){
                    g2.drawImage(tm.getBounds(), sx, sy, gp.tileSize, gp.tileSize, null);
                    //System.out.println("bounds x: "+sx+" y: "+sy);
                }
            }
        }
    }


}
