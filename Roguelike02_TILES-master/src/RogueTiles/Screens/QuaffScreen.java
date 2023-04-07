package RogueTiles.Screens;

import RogueAscii.Main.Creature;
import RogueAscii.Main.Item;
import RogueTiles.Main.TilesPanel;
import asciiPanel.AsciiPanel;

import java.awt.*;
import java.util.ArrayList;

public class QuaffScreen extends InventoryBasedScreen {

    public QuaffScreen(Creature player) {
            super(player);
    }

    protected String getVerb() {
            return "quaff";
    }

    protected boolean isAcceptable(Item item) {
            return item.quaffEffect() != null;
    }

    protected Screen use(Item item) {
            player.quaff(item);
            return null;
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
    public void displayOutput(Graphics2D g2) {

    }
}