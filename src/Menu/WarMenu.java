package Menu;

import Cards.Card;
import Cards.MonsterCard.Monster;
import Cards.MonsterCard.Type;
import Cards.SpellCards.Spell;
import Cards.SpellCards.cardType;
import ItemsAndAmulets.Amulet;
import ItemsAndAmulets.Item;
import Player.Player;
import World.World;
import com.company.Main;

import static com.company.Main.again;
import static com.company.Main.print;

public abstract class WarMenu {
    public static void monsterSpellCasting_Spell(Player sideName, Player enemySide, Monster monster) {
        while (true) {
            boolean haveUsedCard = false;
            if (monster.needChoosing) {
                while (true) {
                    System.out.println("You are in spell casting menu.");
                    monster.haveSpell = false;
                    //TODO: write Spell info
                    System.out.println("'" +monster.name + "' :");
                    System.out.println("info: " + monster.description);

                    String commandInSpellCasting = Main.scanner.nextLine();
                    System.out.println("List of Targets:");
                    System.out.println("1. " + enemySide.actorName);
                    for (int i = 0; i < enemySide.monsterField.size(); i++) {
                        int j = i + 2;
                        System.out.println(j + " " + monster.name);
                    }
                    //Again:
                    if(commandInSpellCasting.contains("Again")){
                        System.out.println(Main.again);
                    }

                    //Help:
                    if (commandInSpellCasting.contains("Help")) {
                        System.out.println("1. Target #TargetNum: To cast the spell on the specified target " +
                                "\n2. Exit: To skip spell casting ");
                    }

                    //Exit:
                    if (commandInSpellCasting.contains("Exit")) {
                        if (!haveUsedCard) {
                            System.out.println("No Target was chosen. Such a waste");
                        }
                        break;
                    }

                    //Target:
                    if (commandInSpellCasting.contains("Target")) {
                        String[] strings1 = commandInSpellCasting.split(" ");
                        try {
                            int targetIndex = Integer.parseInt(strings1[strings1.length - 1]);
                            monster.spellEffect(sideName, enemySide, targetIndex);
                            System.out.println(monster.name + " has cast a Spell:");
                        }catch (NumberFormatException e){
                            System.out.println("invalid input!");
                        }
                    }

                }
            } else {
                monster.spellEffect(sideName, enemySide, -1);
                print("You are in spell casting menu."
                        + "\n" + monster.name + " has cast a Spell:"
                        + "Spell info: " + monster.spellDetails);
            }
        }
    }

    public static void monsterSpellCasting_Will(Player sideName, Player enemySide, Monster monster) {
        while (true) {
            boolean haveUsedCard = false;
            if (monster.needChoosing) {
                while (true) {
                    System.out.println("You are in spell casting menu.");
                    monster.haveSpell = false;
                    //TODO: write Spell info
                    System.out.println("'" +monster.name + "' :");
                    System.out.println("info: " + monster.description);

                    String commandInSpellCasting = Main.scanner.nextLine();
                    System.out.println("List of Targets:");
                    System.out.println("1. " + enemySide.actorName);
                    for (int i = 0; i < enemySide.monsterField.size(); i++) {
                        int j = i + 2;
                        System.out.println(j + " " + monster.name);
                    }
                    //Again:
                    if(commandInSpellCasting.contains("Again")){
                        System.out.println(Main.again);
                    }

                    //Help:
                    if (commandInSpellCasting.contains("Help")) {
                        print("1. Target #TargetNum: To cast the spell on the specified target " +
                                "\n2. Exit: To skip spell casting ");
                    }

                    //Exit:
                    if (commandInSpellCasting.contains("Exit")) {
                        if (!haveUsedCard) {
                            print("No Target was chosen. Such a waste");
                        }
                        break;
                    }

                    //Target:
                    if (commandInSpellCasting.contains("Target")) {
                        String[] strings1 = commandInSpellCasting.split(" ");
                        try {
                            int targetIndex = Integer.parseInt(strings1[strings1.length - 1]);
                            monster.will(sideName, enemySide, targetIndex);
                            print(monster.name + " has cast a Spell:");
                        }catch (NumberFormatException e){
                            print("invalid input!");
                        }
                    }

                }
            } else {
                monster.will(sideName, enemySide, -1);
                print("You are in spell casting menu.\n"
                        + monster.name + " has cast a Spell:"
                        + "\nSpell info: " + monster.spellDetails);
            }
        }
    }

    public static void useItem(String command, Player sideName){
        String[] strings = command.split(" ");
        try{
            int index = Integer.parseInt(strings[strings.length - 1]);
            Item item = sideName.inventory.items.get(index);
            item.action(sideName);
            sideName.inventory.items.remove(item);
            System.out.println("Item " +item.name + " used.       \\\\info: " + item.details);
        }catch (NumberFormatException e){
            System.out.println("invalid input!");
        }
    }

    public static void useCard(String command, Player sideName, Player enemySide){

        String[] strings = command.split(" ");
        int index = Integer.parseInt(strings[strings.length - 1]);
        Monster monster = sideName.monsterField.get(index);

        print("Using " + monster.name + ":" + "\nHP: " + monster.HP + " AP: " + monster.AP + "\n Is sleeping: ");

        if (monster.readyToAttack) {
            System.out.println("False");
            Main.again += "False";
        } else {
            System.out.println("True");
            System.out.println("Can't get used now!");
            Main.again += "True\nCan't get used now!";
            return;
        }

        while (true) {
            System.out.println("You are in use card menu.");

            if (monster.type == Type.Normal) {
                //normal cards
                String commandInUseMode = Main.scanner.nextLine();

                //Info:
                if (commandInUseMode.contains("Info")) {
                    print("\"" + monster.name + "\"" + "\nHP: " + monster.HP + " AP: " + monster.AP + "\ninfo: " + monster.description);
                }

                //Exit:
                if (commandInUseMode.contains("Exit")) {
                    break;
                }

                //Attack:
                if (commandInUseMode.contains("Attack")) {
                    String[] strings2 = commandInUseMode.split(" ");
                    try {
                        int target = Integer.parseInt(strings2[strings2.length - 1]);
                        monster.attack(sideName, enemySide, target);
                    } catch (NumberFormatException e) {
                        monster.attack(sideName, enemySide, -1);
                    }
                }

                //Help:
                if(commandInUseMode.contains("Help")){
                    print("1. Attack #EnemyMonsterSlot / Player: To attack the card on that slot of enemy MonsterField or the enemy player " +
                            "\n2. Cast Spell: To cast the ’cards spell " +
                            "\n3. Info: To get full information on card " +
                            "\n4. Exit: To go back to Play Menu ");
                }

            } else {
                //Spell casting cards
                print("Can Cast:");
                if(monster.haveSpell){
                    System.out.println("True");
                    Main.again += "True";
                }else{
                    System.out.println("False");
                    Main.again += "False";
                }

                String commandInUseMode = Main.scanner.nextLine();


                //Info:
                if (commandInUseMode.contains("Info")) {
                    System.out.println("\n\"" + monster.name + "\"" + "\nHP: " + monster.HP + " AP: " + monster.AP + "\ninfo: " + monster.description);
                }

                //Exit:
                if (commandInUseMode.contains("Exit")) {
                    break;
                }

                //Attack:
                if (commandInUseMode.contains("Attack")) {
                    String[] strings3 = commandInUseMode.split(" ");
                    try {
                        int target = Integer.parseInt(strings3[strings3.length - 1]);
                        monster.attack(sideName, enemySide, target);
                    } catch (Exception e) {
                        monster.attack(sideName, enemySide, -1);
                    }
                }

                //Help:
                if(commandInUseMode.contains("Help")){
                    print("1. Attack #EnemyMonsterSlot / Player: To attack the card on that slot of enemy MonsterField or the enemy player " +
                            "\n2. Cast Spell: To cast the ’cards spell " +
                            "\n3. Info: To get full information on card " +
                            "\n4. Exit: To go back to Play Menu ");
                }

                //spellCasting:
                if (commandInUseMode.contains("Cast")) {
                    WarMenu.monsterSpellCasting_Spell(sideName, enemySide, monster);
                }


            }
        }
    }

    public static void changeTurn(Player starter, Player other, Player sideName, Player enemySide){

    }

    public static void preTurn(Player sideName, Player enemySide, int turn){
        //This shows turn
        if(turn % 2 == 1) {
            print("Turn " + (turn / 2 + 1) + " started!");
        }
         print(sideName.actorName + "'s turn.");


        if (turn > 2) {
            Card card = sideName.moveCardFromDeckToHand();
            print("[" + card.name + "]");
        }
        print("[" + sideName.MP + "/" + sideName.MaxMP + "]");

        for(Monster monster : sideName.monsterField){
            monster.readyToAttack = true;
        }
        for(Monster monster : enemySide.monsterField){
            monster.readyToAttack = true;
        }

    }

    public static void setCard(String command, Player sideName, Player enemySide){
        String[] strings2 = command.split(" ");
        try {
            int index2 = Integer.parseInt(strings2[strings2.length - 1]);
            Card card = sideName.hand.get(index2);
            print("Card \"" + card.name + "\" used!");
            sideName.moveCardFromHandToField(index2);

            if (card instanceof Monster) {
                Monster monster = (Monster) card;
                if (monster.type == Type.Hero || monster.type == Type.General) {
                    WarMenu.monsterSpellCasting_Will(sideName, enemySide, monster);
                }
            } else if (card instanceof Spell) {
                Spell spell = (Spell) card;
                if (spell.type == cardType.Instant) {
                    WarMenu.spellCasting_Spell(sideName, enemySide, spell);
                }
            }
        }catch (NumberFormatException e){
            print("invalid input!");
        }
    }

    public static void spellCasting_Spell(Player sideName, Player enemySide, Spell spell) {
        while (true) {
            boolean haveUsedCard = false;
            if (spell.needChoosing) {
                while (true) {
                    System.out.println("You are in spell casting menu.");
                    //TODO: write Spell info
                    print("\n\"" + spell.name + "\" :"+"\ninfo: " + spell.description + "\nList of Targets:");
                    System.out.println("1. " + enemySide.actorName);
                    for (int i = 0; i < enemySide.monsterField.size(); i++) {
                        int j = i + 2;
                        System.out.println(j + " " + spell.name);
                        Main.again += (j + " " + spell.name);
                    }
                    String commandInSpellCasting = Main.scanner.nextLine();
                    //Again:
                    if(commandInSpellCasting.contains("Again")){
                        System.out.println(Main.again);
                    }

                    //Help:
                    if (commandInSpellCasting.contains("Help")) {
                        print("1. Target #TargetNum: To cast the spell on the specified target " +
                                "\n2. Exit: To skip spell casting ");
                    }

                    //Exit:
                    if (commandInSpellCasting.contains("Exit")) {
                        if (!haveUsedCard) {
                            print("No Target was chosen. Such a waste");
                        }
                        return;
                    }

                    //Target:
                    if (commandInSpellCasting.contains("Target")) {
                        String[] strings1 = commandInSpellCasting.split(" ");
                        try {
                            if(!haveUsedCard) {
                                int targetIndex = Integer.parseInt(strings1[strings1.length - 1]);
                                spell.action(sideName, enemySide, targetIndex);
                                print("Spell " + spell.name + " clashed with " + enemySide.monsterField.get(targetIndex).name + "."
                                        + "\n" + spell.name + " has cast a Spell:"
                                        + "\ninfo : " + spell.description);
                                haveUsedCard = true;
                            }
                        }catch (NumberFormatException e){
                            print("invalid input!");
                        }
                    }

                }
            } else {
                spell.action(sideName, enemySide, -1);
                print("You are in spell casting menu."
                        + "\n" + spell.name + " has cast a Spell:"
                        + "\nSpell info: " + spell.description);
            }
        }
    }

    public static void viewHand(Player sideName){
        print("Your Hand:");
        for(int i = 0; i < sideName.hand.size(); i++){
            System.out.println(i + ". " + sideName.hand.get(i).name);
            Main.again += ("\n" + i + ". " + sideName.hand.get(i).name);
        }
    }

    public static void viewGraveyard(Player sideName, Player enemySide){
        print("Your Graveyard:");
        for(int i = 0; i < sideName.graveYard.size(); i++){
            System.out.println(i + ". " + sideName.graveYard.get(i).name);
            Main.again += ("\n" + i + ". " + sideName.graveYard.get(i).name);
        }

        System.out.println("Enemy Graveyard:");
        Main.again += "\nEnemy Graveyard:";
        for(int i = 0; i < enemySide.graveYard.size(); i++){
            System.out.println(i + ". " + sideName.graveYard.get(i).name);
            Main.again += ("\n" + i + ". " + sideName.graveYard.get(i).name);
        }

    }

    public static void viewMonsterField(Player sideName, Player enemySide){
        print("Your MonsterField:");
        for(int i = 0; i < sideName.monsterField.size(); i++){
            Monster monster = sideName.getMonsterField().get(i);
            System.out.println(i + ". " + monster.name + " :"
                    + "\n     HP: " + monster.HP + " AP: " + monster.AP + " \\\\ info: " + monster.description);
            Main.again += ("\n" + i + ". " + monster.name + " :"
                    + "\n     HP: " + monster.HP + " AP: " + monster.AP + " \\\\ info: " + monster.description);
        }

        System.out.println("Enemy MonsterField:");
        Main.again += "\nEnemy MonsterField:";
        for(int i = 0; i < enemySide.monsterField.size(); i++){
            Monster monster = enemySide.getMonsterField().get(i);
            System.out.println(i + ". " + monster.name + " \\ "
                    + "\n     HP: " + monster.HP + " AP: " + monster.AP + " \\\\ info: " + monster.description);
            Main.again += ("\n" + i + ". " + monster.name + " \\ "
                    + "\n     HP: " + monster.HP + " AP: " + monster.AP + " \\\\ info: " + monster.description);
        }

    }

    public static void viewItems(Player sideName){
        int i = 0;
        Main.again = "";
        for(Item item : sideName.inventory.items){
            System.out.println(i + ". " + item.name);
            Main.again += ("\n" + i + ". " + item.name);
            i++;
        }
    }

    public static void chooseAmulets(Player player){
        if(player.inventory.amulets.size() == 0){
            return;
        }
        if(player.equippedAmulet != null){
            System.out.println("Equipped amulet :" + player.equippedAmulet.name);
        }
        while (true){
            String command = Main.scanner.nextLine();
            for(int i = 0;i < player.inventory.amulets.size(); i++){
                Amulet amulet = player.inventory.amulets.get(i);
                System.out.println(i + ". " + amulet.name +"     \\\\info: " + amulet.name);
            }
            System.out.println("use \"use\" to choose");
            System.out.println("use \"Exit\" to exit :)");

            if(command.contains("use")){
                String[] strings = command.split(" ");
                try{
                    int index = Integer.parseInt(strings[strings.length - 1]);
                    Amulet amulet = player.inventory.amulets.get(index);
                    if(player.equippedAmulet != null){
                        player.equippedAmulet.remove(player);
                    }
                    amulet.action(player);
                    player.equippedAmulet = amulet;
                }catch (NumberFormatException e){
                    System.out.println("invalid input!");
                }
            }

            if(command.contains("Exit")){
                if(player.equippedAmulet == null){
                    System.out.println("You have no Amulet.");
                }else{
                    System.out.println("Your Amulet : " + player.equippedAmulet.name);
                }
                return;
            }
        }
    }

    public static boolean isGameFinished(World world){
        Player sideName = world.thePlayer;
        Player enemySide = world.theEnemy;
        Player player = world.thePlayer;
        Player loserSide = null;
        Player winnerSide = null;
        if(sideName.Hero.deathCheck()){
            loserSide = sideName;
            winnerSide = enemySide;
        }
        if(enemySide.Hero.deathCheck()){
            loserSide = enemySide;
            winnerSide = sideName;
        }

        if(loserSide == player){
            return true;
        }else{
            Main.someoneLost = false;
            print(winnerSide.actorName + " defeated " + loserSide.actorName + "!");
            return false;
        }
    }
}
