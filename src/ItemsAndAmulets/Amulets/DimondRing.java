package ItemsAndAmulets.Amulets;

import ItemsAndAmulets.Amulet;
import Player.Player;

public class DimondRing extends Amulet {

    public DimondRing() {
        super.price = 8000;
        super.name = "Diamond Pendant";
        super.details = "Increase Player’s Max MP by 3.";
    }

    public void action(Player player){
        player.MaxMP += 3;
    }

    public void remove(Player player){
        player.MaxMP -= 3;
        if(player.MP > player.MaxMP){
            player.MP = player.MaxMP;
        }
    }

}
