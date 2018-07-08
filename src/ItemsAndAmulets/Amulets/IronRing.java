package ItemsAndAmulets.Amulets;

import ItemsAndAmulets.Amulet;
import ItemsAndAmulets.Item;
import Player.Player;

public class IronRing extends Amulet {

    public IronRing() {
        super.amuletCost = 2000;
        super.name = "Iron Ring";
        super.details = "Increase Player’s Max MP by 1.";
    }

    public void action(Player player){
        player.MaxMP += 1;
    }
    public void remove(Player player) {
        player.MaxMP -= 1;
    }

}
