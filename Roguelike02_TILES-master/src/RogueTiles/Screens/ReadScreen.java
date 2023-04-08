package RogueTiles.Screens;

import RogueAscii.Main.Creature;
import RogueAscii.Main.Item;
import RogueTiles.Main.TilesPanel;
import asciiPanel.AsciiPanel;

import java.awt.*;
import java.util.ArrayList;

public class ReadScreen extends InventoryBasedScreen {

    private int sx;
    private int sy;
    
    public ReadScreen(Creature player, int sx, int sy) {
        super(player);
        this.sx = sx;
        this.sy = sy;
    }

    protected String getVerb() {
        return "read";
    }

    protected boolean isAcceptable(Item item) {
        return !item.writtenSpells().isEmpty();
    }

    protected Screen use(Item item) {
        return new ReadSpellScreen(player, sx, sy, item);
    }

    public void displayOutput(AsciiPanel terminal) {
        ArrayList<String> lines = getList();
    
        int y = 23 - lines.size();
        int x = 4;

        if (lines.size() > 0)
            terminal.clear(' ', x, y, 20, lines.size());
    
        for (String line : lines){
            terminal.write(line, x, y++);
        }
    
        terminal.clear(' ', 0, 23, 80, 1);
        terminal.write("What would you like to " + getVerb() + "?", 2, 23);
    
        terminal.repaint();
    }

    @Override
    public void displayOutput(TilesPanel tp) {

    }

    @Override
    public void displayOutput(Graphics2D g2, TilesPanel t) {

    }
}
