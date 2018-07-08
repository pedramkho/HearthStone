package ItemsAndAmulets.Amulets;

import ItemsAndAmulets.Amulet;
import ItemsAndAmulets.Item;
import Player.Player;

public class IronPendant extends Amulet {

    public IronPendant() {
        super.name = "Iron Pendant";
        super.amuletCost = 2000;
        super.details = "Increase Player’s Max HP by 500.";
    }

    public void action(Player player){
        player.MaxHP += 500;
    }
}
