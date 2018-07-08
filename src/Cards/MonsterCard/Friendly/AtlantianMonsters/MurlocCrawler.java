package Cards.MonsterCard.Friendly.AtlantianMonsters;

import Cards.MonsterCard.House;
import Cards.MonsterCard.Monster;
import Cards.MonsterCard.Specialty;
import Cards.MonsterCard.Type;

public class MurlocCrawler extends Monster {
    public MurlocCrawler() {
        super.haveSpell = false;
        super.name = "Murloc Crawler";
        super.defaultHP = 200;
        super.defaultAP = 500;
        super.house = House.Atlantian;
        super.readyToAttack = false;
        super.HP = 200;
        super.AP = 500;
        super.MPCost = 1;
        super.type = Type.Normal;
        super.specialty = Specialty.None;
    }
}
