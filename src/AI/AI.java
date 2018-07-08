package AI;

import Cards.MonsterCard.Monster;
import Player.Player;


public abstract class AI {
    public static void run(Player sideName, Player enemySide){
        useMonsterCards(sideName, enemySide);
        useHand(sideName, enemySide);
        System.out.println(sideName.actorName + " AI Did the job!");
    }

    static void useMonsterCards(Player sideName, Player enemySide){

        if(enemySide.monsterField.size() > 0 && sideName.monsterField.size() > 0){
            Monster[] myMonsters = sideName.monsterField.toArray(new Monster[0]);
            for(int i = 0; i < myMonsters.length; i++) {
                myMonsters[i].attack(sideName, enemySide, getBestTarget(enemySide, myMonsters[i]));
            }
        }

    }

    static int getBestTarget(Player enemySide, Monster attacker){
        if(enemySide.monsterField.size() > 0) {
            Monster targetMonster = enemySide.monsterField.get(0);
            int count = 0;
            int target = 0;
            int deathpoint = targetMonster.HP - attacker.AP;

            for (Monster monster : enemySide.monsterField) {
                int temp = monster.HP - attacker.AP;
                if (temp < 0 && Math.abs(temp) < Math.abs(deathpoint)) {
                    deathpoint = temp;
                    target = count;
                }
                count++;
            }
            return target;
        }
        return -1;
    }

    static void useHand(Player sideName, Player enemyside){
        if(sideName.hand.size() > 0) {
            sideName.moveCardFromHandToField(0);
        }
    }

}
