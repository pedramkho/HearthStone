package ItemsAndAmulets.Amulets;

import ItemsAndAmulets.Amulet;
import ItemsAndAmulets.Item;
import Player.Player;

public class DiamondPendant extends Amulet {

    public DiamondPendant() {
        super.amuletCost = 8000;
        super.name = "Diamond Pendant";
        super.details = "Increase Player’s Max HP by 2000.";
    }

    public void action(Player player){
        player.MaxHP += 2000;
    }

    public void remove(Player player) {
        player.MaxHP -= 2000;
        if(player.Hero.HP > player.MaxHP){
            player.Hero.HP = player.MaxHP;
        }
    }
}
