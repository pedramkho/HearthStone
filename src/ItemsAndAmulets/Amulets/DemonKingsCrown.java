package ItemsAndAmulets.Amulets;

import ItemsAndAmulets.Amulet;
import Player.Player;

public class DemonKingsCrown extends Amulet {

    public DemonKingsCrown() {
        super.price = 0;
        super.name = "Demon King's Crown";
        super.details = "Decrease All Incoming Damages by 20%.";
        super.isTradable = false;//remember
    }

    public void action(Player player){
        player.demonKingsCrownEffect = 0.8;
    }
    public void remove(Player player){
        player.demonKingsCrownEffect = 1;
    }
}
