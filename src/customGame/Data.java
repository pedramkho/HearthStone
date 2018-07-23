package customGame;

import Cards.Card;
import Cards.MonsterCard.Monster;
import Cards.SpellCards.Spell;
import ItemsAndAmulets.Amulet;
import ItemsAndAmulets.Item;

import java.io.Serializable;
import java.util.ArrayList;

public class Data implements Serializable {
    public String name = "default";
    public ArrayList<Card> cards = new ArrayList<Card>();
    public ArrayList<Amulet> amulets = new ArrayList<>();
    public ArrayList<Item> items = new ArrayList<>();
    public ArrayList<Cards.Spell.Spell> spells = new ArrayList<>();
    public ArrayList<Card> initialInventoryCards = new ArrayList<>();
    public ArrayList<Item> initialInventoryItems = new ArrayList<>();
    public ArrayList<Amulet> initialInventoryAmulets = new ArrayList<>();
    public ArrayList<Card> initialDeck = new ArrayList<>();
}
