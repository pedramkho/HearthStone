package ItemsAndAmulets.Amulets;

import ItemsAndAmulets.Amulet;
import ItemsAndAmulets.Item;
import Player.Player;

public class GoldPendant extends Amulet {

    public GoldPendant() {
        super.amuletCost = 4000;
        super.name = "Gold Pendant";
        super.details = "Increase Player’s Max HP by 1000.";
    }

    public void action(Player player){
        player.MaxHP += 1000;
    }
    public void remove(Player player) {
        player.MaxHP -= 1000;
    }

}
