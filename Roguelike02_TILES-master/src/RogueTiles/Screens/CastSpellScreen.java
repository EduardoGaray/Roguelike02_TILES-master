package RogueTiles.Screens;

import RogueAscii.Main.Creature;
import RogueAscii.Main.Spell;
import RogueTiles.Main.TilesPanel;

import java.awt.*;

public class CastSpellScreen extends TargetBasedScreen {
    private Spell spell;
    
    public CastSpellScreen(Creature player, String caption, int sx, int sy, Spell spell) {
        super(player, caption, sx, sy);
        this.spell = spell;
    }
    
    public void selectWorldCoordinate(int x, int y, int screenX, int screenY){
        player.castSpell(spell, x, y);
    }

    @Override
    public void displayOutput(TilesPanel tp) {

    }

    @Override
    public void displayOutput(Graphics2D g2, TilesPanel tp) {

    }

}
