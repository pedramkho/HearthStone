package customGame;

import Cards.Card;
import Cards.MonsterCard.Friendly.AtlantianMonsters.*;
import Cards.MonsterCard.Friendly.DragonBreedMonster.*;
import Cards.MonsterCard.Friendly.ElvenMonster.*;
import Cards.SpellCards.*;
import ItemsAndAmulets.Amulet;
import ItemsAndAmulets.Amulets.*;
import ItemsAndAmulets.Item;
import ItemsAndAmulets.Items.*;

import java.io.*;
import java.util.ArrayList;

import static Cards.Card.initializeCardsNumberInShop;
import static Cards.Component.initilizeComponentsNumberInShop;
import static data.constants.General.CUSTOM_GAME_SAVE_LOCATION;

public class CustomGame {
    public static Data data;
    static {
        createDefaultMode();
        loadDefaultMode();
    }
    public static void loadData(String name){
            try(FileInputStream fileInputStream = new FileInputStream(CUSTOM_GAME_SAVE_LOCATION+name+".ser")){
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                data = (Data) objectInputStream.readObject();
                Card.cards =data.cards;
                Cards.Spell.Spell.spells = data.spells;
                Amulet.amulets = data.amulets;
                Item.items = data.items;
                initializeCardsNumberInShop();
                //other initializes
            }catch (Exception e){
                System.out.println("Error during loading data");
                e.printStackTrace();
            }
    }
    public static void saveData(){
        File file = new File(CUSTOM_GAME_SAVE_LOCATION+data.name+".ser");
        try {
            if (!file.exists())
                file.createNewFile();
        }catch (Exception e){
            e.printStackTrace();
        }
        try(FileOutputStream fileOutputStream = new FileOutputStream(file)){
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(data);
        }catch (Exception e){
            System.out.println("Error during saving data");
            e.printStackTrace();
        }
    }
    public static void initializeNewCustomGame(String name){
        initializeData();
        data.name = name;
        saveData();
    }
    public static void createDefaultMode(){
        initializeNewCustomGame("Default");
    }
    public static void loadDefaultMode(){
        loadData("Default");
    }
    public static void initializeData(){
        data = new Data();
        initializeMonsterCards();
        initializeSpellCards();
        initializeSpells();
        initializeAmulets();
        initializeItems();
        initializeInitialInventoryCards();
        initializeInitialInventoryAmulets();
        initializeInitialInventoryItems();
        initilizeComponentsNumberInShop();
        intitilizeDeck();
    }

    private static void intitilizeDeck() {
        //add Atlantians
        data.initialDeck.add(new MurlocCrawler());
        data.initialDeck.add(new MurlocCrawler());
        data.initialDeck.add(new MurlocWarrior());
        data.initialDeck.add(new MurlocWarrior());
        data.initialDeck.add(new GiantCrab());
        data.initialDeck.add(new SharkMan());
        data.initialDeck.add(new NagaSiren());
        //add DragonBreeds
        data.initialDeck.add(new LesserWhelp());
        data.initialDeck.add(new LesserWhelp());
        data.initialDeck.add(new Dragonling());
        data.initialDeck.add(new Dragonling());
        data.initialDeck.add(new ArmoredDragon());
        data.initialDeck.add(new YellowDrake());
        data.initialDeck.add(new BlueDragon());
        //add Elvens
        data.initialDeck.add(new ElvenRanger());
        data.initialDeck.add(new ElvenRanger());
        data.initialDeck.add(new ElvenHunter());
        data.initialDeck.add(new ElvenHunter());
        data.initialDeck.add(new ElvenGuardsman());
        data.initialDeck.add(new ElvenAssassin());
        data.initialDeck.add(new ElvenDruid());
        //add spell cards
        data.initialDeck.add(new FirstAidKit());
        data.initialDeck.add(new FirstAidKit());
        data.initialDeck.add(new FirstAidKit());
        data.initialDeck.add(new ThrowingKnives());
        data.initialDeck.add(new ThrowingKnives());
        data.initialDeck.add(new ThrowingKnives());
        data.initialDeck.add(new PoisionousCauldron());
        data.initialDeck.add(new HealingWard());
        data.initialDeck.add(new WarDrum());
    }

    private static void initializeInitialInventoryItems() {
        data.initialInventoryItems.add(new MysticHourglass());
        data.initialInventoryItems.add(new MysticHourglass());
        data.initialInventoryItems.add(new MysticHourglass());
        data.initialInventoryItems.add(new SmallHPPotion());
        data.initialInventoryItems.add(new SmallHPPotion());
        data.initialInventoryItems.add(new SmallMPPotion());
        data.initialInventoryItems.add(new SmallMPPotion());

    }

    private static void initializeInitialInventoryAmulets() {

    }

    private static void initializeInitialInventoryCards() {
    }

    public static void initializeMonsterCards(){
        //add Atlantians
        data.cards.add(new GiantCrab());
        data.cards.add(new Kraken());
        data.cards.add(new MurlocCrawler());
        data.cards.add(new MurlocWarrior());
        data.cards.add(new NagaSiren());
        data.cards.add(new NeptuneKingOfAtlantis());
        data.cards.add(new SeaSerpent());
        data.cards.add(new SharkMan());
        //add DragonBreeds
        data.cards.add(new ArmoredDragon());
        data.cards.add(new BlueDragon());
        data.cards.add(new Dragonling());
        data.cards.add(new GreaterDragon());
        data.cards.add(new IngeelTheDragonKing());
        data.cards.add(new LesserWhelp());
        data.cards.add(new VolcaincDragon());
        data.cards.add(new YellowDrake());
        //add Elvens
        data.cards.add(new ElvenAssassin());
        data.cards.add(new ElvenDruid());
        data.cards.add(new ElvenGuardsman());
        data.cards.add(new ElvenHunter());
        data.cards.add(new ElvenRanger());
        data.cards.add(new ElvenSorceress());
        data.cards.add(new LuthienTheHighPriestess());
        data.cards.add(new NobleElf());
    }
    public static void initializeSpellCards(){
        data.cards.add(new ArcaneBolt());
        data.cards.add(new BloodFeast());
        data.cards.add(new FirstAidKit());
        data.cards.add(new GreaterPurge());
        data.cards.add(new HealingWard());
        data.cards.add(new LunarBlessing());
        data.cards.add(new MagicSeal());
        data.cards.add(new MeteorShower());
        data.cards.add(new PoisionousCauldron());
        data.cards.add(new ReapersScythe());
        data.cards.add(new StrategicRetreat());
        data.cards.add(new TakeAllYouCan());
        data.cards.add(new ThrowingKnives());
        data.cards.add(new Tsunami());
        data.cards.add(new WarDrum());
    }
    public static void initializeSpells(){
        //todo
    }
    public static void initializeAmulets(){
        data.amulets.add(new DemonKingsCrown());
        data.amulets.add(new DiamondPendant());
        data.amulets.add(new DimondRing());
        data.amulets.add(new GoldPendant());
        data.amulets.add(new GoldRing());
        data.amulets.add(new IronPendant());
        data.amulets.add(new IronRing());
    }
    public static void initializeItems(){
        data.items.add(new GreaterRestorative());
        data.items.add(new LargeHPPotion());
        data.items.add(new LargeMPPotion());
        data.items.add(new LesserRestorative());
        data.items.add(new MediumHPPotion());
        data.items.add(new MediumMPPotion());
        data.items.add(new MysticHourglass());
        data.items.add(new SmallHPPotion());
        data.items.add(new SmallMPPotion());
    }
    public static boolean removeCustomGame(String name){
        File data = new File(CUSTOM_GAME_SAVE_LOCATION+name+".ser");
        return data.delete();
    }
    public static boolean exist(String name) {
        return new File(CUSTOM_GAME_SAVE_LOCATION + name + ".ser").exists();
    }
}