package Cards.MonsterCard;

import Cards.Card;
import Cards.SpellCards.Spell;
import Player.Player;

import java.util.ArrayList;

public class Monster extends Card {
    //TODO: default HP and AP should be added
    //info:
    public ArrayList<Spell> auraEffects = new ArrayList<>();//used in spells
    public boolean haveSpell = false;                           //
    public int defaultHP = 0;
    public int defaultAP = 0;
    public int HP = 0;
    public int AP = 0;
    public Type type = Type.Normal;
    public Specialty specialty = Specialty.None;
    //TODO: We should set each monsters House
    public House house = House.Elven;
    public boolean Alive = true;
    //TODO: We should change Nimble cards readyTOAttack parameter
    public boolean readyToAttack = false;
    public String battleCryDescription = null;
    public String willDescription = null;
    public String spellDetails = null;

    public Monster() {
        super.description = battleCryDescription + "\n" + willDescription + "\n" + spellDetails;
        needChoosing = false;
        MPCost = 0;
    }

    public String cardInfo() {
        String string = this.name + "\n" + "HP: " + this.HP + "\nAP: " + this.AP + "\n" + description;
        return string;
    }

    //actions:
    public boolean deathCheck() {
        if (this.HP <= 0) {
            return true;
        }
        return false;
    }

    public static void revive(Monster monster) {
        if (monster.type == Type.SpellCaster) {
            monster.haveSpell = true;
        }
        monster.HP = monster.defaultHP;
        monster.AP = monster.defaultAP;
        monster.Alive = true;
    }

    public void attack(Player player, Player enemy, int target) {
        //target -1 = hero
        //target -2 = no need to set target

        Monster defender = null;
        for (Monster monster : enemy.monsterField) {
            if (monster.specialty == Specialty.Defender) {
                defender = monster;
            }
        }

        if (defender != null) {

            this.HP -= defender.AP * player.demonKingsCrownEffect;
            defender.HP -= this.AP * enemy.demonKingsCrownEffect;
            if (deathCheck()) {
                this.battlecry(player, enemy, -2);
                Alive = false;
            }
            if (defender.deathCheck()) {
                defender.battlecry(player, enemy, -2);
                defender.Alive = false;
            }

            System.out.println(this.name + " clashed with " + defender.name);

        } else if (target > -1) {

            enemy.choosenMonster = enemy.getSearchedMonster(target);
            this.HP -= enemy.choosenMonster.AP * enemy.demonKingsCrownEffect;
            enemy.choosenMonster.HP -= this.AP * player.demonKingsCrownEffect;

            if (deathCheck()) {
                this.battlecry(player, enemy, target);
                Alive = false;
            }

            if (enemy.choosenMonster.deathCheck()) {
                enemy.choosenMonster.battlecry(player, enemy, target);
                enemy.choosenMonster.Alive = false;
            }
            System.out.println(this.name + " clashed with " + enemy.choosenMonster.name);
        } else {
            enemy.Hero.HP -= this.AP * player.demonKingsCrownEffect;
            this.HP -= enemy.Hero.AP * enemy.demonKingsCrownEffect;

            if (deathCheck()) {
                this.battlecry(player, enemy, target);
                Alive = false;
            }
            System.out.println(this.name + " clashed with " + enemy.Hero.name);
        }
        player.updateLists();
        enemy.updateLists();
    }

    //spells:
    public void will(Player player, Player enemy, int target) {
        //Should get override
    }

    public void spellEffect(Player player, Player enemy, int target) {
        //Should get override
    }

    public void battlecry(Player player, Player enemy, int target) {
        //Should be override
    }


    public Monster(String name, Type type, Specialty specialty, House house, int defaultHP, int defaultAP, int MPcost, int price,boolean custom) {
        super.name = name;
        this.type = type;
        this.specialty = specialty;
        this.house = house;
        this.defaultHP = defaultHP;
        this.defaultAP = defaultAP;
        super.MPCost = MPcost;
        super.price = price;
        super.custom = custom;
    }

    public void makeCustomMonster(String name, Type type, Specialty specialty, House house, int defaultHP, int defaultAP, int MPcost, int price) {
        if (existMonster(name)) {
            System.out.println("Duplicate name");//todo
            return;
        }
    }

    public static boolean existMonster(String cardName) {
        for (Card card : cards)
            if ((card instanceof Monster) && card.getName().equals(cardName))
                return true;
        return false;
    }

    public static boolean removeMonster(String name) {
        for (Card card : cards)
            if ((card instanceof Monster) && card.getClass().equals(name)) {
                cards.remove(card);
                return true;
            }
        return false;
    }
    public boolean equals(Monster monster){
        return getName().equals(monster.name);
    }
}


