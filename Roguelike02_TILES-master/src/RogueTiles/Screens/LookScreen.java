package RogueTiles.Screens;

import RogueAscii.Main.Creature;
import RogueAscii.Main.Item;
import RogueAscii.Main.Tile;
import RogueTiles.Main.TilesPanel;

import java.awt.*;

public class LookScreen extends TargetBasedScreen {

    public LookScreen(Creature player, String caption, int sx, int sy) {
        super(player, caption, sx, sy);
    }

    public void enterWorldCoordinate(int x, int y, int screenX, int screenY) {
        Creature creature = player.creature(x, y, player.z);
        if (creature != null){
            caption = creature.glyph() + " "     + creature.name() + creature.details();
            return;
        }
    
        Item item = player.item(x, y, player.z);
        if (item != null){
            caption = item.glyph() + " "     + item.name() + item.details();
            return;
        }
    
        Tile tile = player.tile(x, y, player.z);
        caption = tile.glyph() + " " + tile.details();
    }

    @Override
    public void displayOutput(TilesPanel tp) {

    }

    @Override
    public void displayOutput(Graphics2D g2) {

    }
}