package RogueTiles.Screens;

import RogueAscii.Main.Creature;
import RogueAscii.Main.Item;
import RogueTiles.Main.TilesPanel;
import asciiPanel.AsciiPanel;

import java.util.ArrayList;

public class DropScreen extends InventoryBasedScreen {

    public DropScreen(Creature player) {
        super(player);
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

	protected String getVerb() {
        return "drop";
    }

	protected boolean isAcceptable(Item item) {
        return true;
    }

	protected Screen use(Item item) {
        player.drop(item);
        return null;
    }
}
