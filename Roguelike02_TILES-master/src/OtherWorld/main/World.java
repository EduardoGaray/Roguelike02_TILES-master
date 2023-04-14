package OtherWorld.main;

import OtherWorld.tile.Tile;

public class World {
    GamePanel gp;
    private Tile[][] tiles;
    private int width;
    public int width() { return width; }

    private int height;
    public int height() { return height; }

    public World(Tile[][] tiles){
        this.tiles = tiles;
        this.width = tiles.length;
        this.height = tiles[0].length;
    }
    public Tile tile(int x, int y){
        if (x < 0 || x >= width || y < 0 || y >= height)
            return Tile.BOUNDS;
        else
            return tiles[x][y];
    }
    public String file(int x, int y){
        return tile(x, y).getFile();
    }
    public String type(int x, int y){
        return tile(x, y).getType();
    }
}
