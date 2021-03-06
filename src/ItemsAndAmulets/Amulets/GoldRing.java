package ItemsAndAmulets.Amulets;

import ItemsAndAmulets.Amulet;
import Player.Player;

public class GoldRing extends Amulet {

    public GoldRing() {
        super.price = 4000;
        super.name = "Gold Ring";
        super.details = "Increase Player’s Max MP by 2.";
    }

    public void action(Player player){
        player.MaxMP += 2;
    }
    public void remove(Player player) {
        player.MaxMP -= 2;
    }
}