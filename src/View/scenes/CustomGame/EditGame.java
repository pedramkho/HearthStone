package View.scenes.CustomGame;

import Cards.Card;
import Cards.Component;
import Cards.MonsterCard.Monster;
import Cards.SpellCards.Spell;
import ItemsAndAmulets.Amulet;
import ItemsAndAmulets.Item;
import View.scenes.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.text.Text;

import java.util.ArrayList;

import static View.Graphics.goToScene;
import static customGame.CustomGame.loadData;
import static customGame.CustomGame.saveData;
import static data.constants.scenes.EditGame.*;
import static data.constants.scenes.customGame.NEW_GAME_BUTTON_Y;

public class EditGame extends Scene {
    private Text selectedCard = null;
    private Text selectedSpell = null;
    private Text selectedAmulet = null;
    private Text selectedItem = null;
    private ArrayList<Text> cards = new ArrayList<>();
    private ArrayList<Text> spells = new ArrayList<>();
    private ArrayList<Text> amulets = new ArrayList<>();
    private ArrayList<Text> items = new ArrayList<>();

    public EditGame() {
        addCards();
        addSpells();
        addAmulets();
        addItems();
        addNewButtons();
        addEditButtons();
        addRemoveButtons();
        addSaveButton();
        addBackButton();
    }

    public void addBackButton() {
        ToggleButton button = createButton(BACK_BUTTON_IMAGE, BACK_BUTTON_START_X, BACK_BUTTON_START_Y, BACK_BUTTON_X, BACK_BUTTON_Y);
        button.setOnAction(event -> {
            loadData("Default");
            goToScene(new CustomGame());
        });
        add(button);
    }

    private void addSaveButton() {
        Button button = createButton(SAVE_BUTTON_TEXT, SAVE_BUTTON_START_X, SAVE_BUTTON_START_Y, SAVE_BUTTON_X, SAVE_BUTTON_Y, SAVE_BUTTON_FONT);
        button.setOnAction(event -> {
            saveData();
            loadData("Default");
            goToScene(new CustomGame());
        });
        add(button);
    }

    private void addRemoveButtons() {
        ToggleButton removeCard = createButton(REMOVE_BUTTON_IMAGE, REMOVE_CARD_BUTTON_START_X, REMOVE_CARD_BUTTON_START_Y, REMOVE_BUTTON_X, REMOVE_BUTTON_Y);
        ToggleButton removeSpell = createButton(REMOVE_BUTTON_IMAGE, REMOVE_SPELL_BUTTON_START_X, REMOVE_SPELL_BUTTON_START_Y, REMOVE_BUTTON_X, REMOVE_BUTTON_Y);
        ToggleButton removeAmulet = createButton(REMOVE_BUTTON_IMAGE, REMOVE_AMULET_BUTTON_START_X, REMOVE_AMULET_BUTTON_START_Y, REMOVE_BUTTON_X, REMOVE_BUTTON_Y);
        ToggleButton removeItem = createButton(REMOVE_BUTTON_IMAGE, REMOVE_ITEM_BUTTON_START_X, REMOVE_ITEM_BUTTON_START_Y, REMOVE_BUTTON_X, REMOVE_BUTTON_Y);
        removeCard.setOnAction(event -> {
            if (selectedCard != null) {
                if (Card.removeCard(selectedCard.getText())) {
                    refreshCards();
                    selectedCard = null;
                } else
                    System.out.println("Error while deleting card");
            }
        });
        removeSpell.setOnAction(event -> {
            if (selectedSpell != null) {
                if (Cards.Spell.Spell.removeSpell(selectedSpell.getText())) {
                    refreshSpells();
                    selectedSpell = null;
                } else
                    System.out.println("Error while deleting card");
            }
        });
        removeAmulet.setOnAction(event -> {
            if (selectedAmulet != null) {
                if (Amulet.removeAmulet(selectedAmulet.getText())) {
                    refreshAmulets();
                    selectedAmulet = null;
                } else
                    System.out.println("Error while deleting amulet");
            }
        });
        removeItem.setOnAction(event -> {
            if (selectedItem != null) {
                if (Item.removeItem(selectedItem.getText())) {
                    refreshItems();
                    selectedItem = null;
                } else
                    System.out.println("Error while deleting item");
            }
        });
        add(removeCard);
        add(removeSpell);
        add(removeAmulet);
        add(removeItem);
    }

    private void refreshItems() {
        for (Text item : items)
            remove(item);
        items.clear();
        addItems();
    }

    private void refreshAmulets() {
        for (Text amulet : amulets)
            remove(amulet);
        amulets.clear();
        addAmulets();
    }

    private void refreshSpells() {
        for (Text spell : spells)
            remove(spell);
        spells.clear();
        addSpells();
    }

    private void refreshCards() {
        for (Text card : cards)
            remove(card);
        cards.clear();
        addCards();
    }

    private void addEditButtons() {
        ToggleButton editCard = createButton(EDIT_BUTTON_IMAGE, EDIT_CARD_BUTTON_START_X, EDIT_CARD_BUTTON_START_Y, EDIT_BUTTON_X, EDIT_BUTTON_Y);
        ToggleButton editSpell = createButton(EDIT_BUTTON_IMAGE, EDIT_SPELL_BUTTON_START_X, EDIT_SPELL_BUTTON_START_Y, EDIT_BUTTON_X, EDIT_BUTTON_Y);
        ToggleButton editAmulet = createButton(EDIT_BUTTON_IMAGE, EDIT_AMULET_BUTTON_START_X, EDIT_AMULET_BUTTON_START_Y, EDIT_BUTTON_X, EDIT_BUTTON_Y);
        ToggleButton editItem = createButton(EDIT_BUTTON_IMAGE, EDIT_ITEM_BUTTON_START_X, EDIT_ITEM_BUTTON_START_Y, EDIT_BUTTON_X, EDIT_BUTTON_Y);
        editCard.setOnAction(event -> {
        });
        editSpell.setOnAction(event -> {
        });
        editAmulet.setOnAction(event -> {
            if (selectedAmulet != null)
                goToScene(new EditAmulets(selectedAmulet.getText()));
        });
        editItem.setOnAction(event -> {
            if (selectedItem != null)
                goToScene(new EditItems(selectedItem.getText()));
        });
        add(editCard);
        add(editSpell);
        add(editAmulet);
        add(editItem);
    }//todo

    private void addNewButtons() {
        ToggleButton newCard = createButton(NEW_BUTTON_IMAGE, NEW_CARD_BUTTON_START_X, NEW_CARD_BUTTON_START_Y, NEW_BUTTON_X, NEW_GAME_BUTTON_Y);
        ToggleButton newSpell = createButton(NEW_BUTTON_IMAGE, NEW_SPELL_BUTTON_START_X, NEW_SPELL_BUTTON_START_Y, NEW_BUTTON_X, NEW_GAME_BUTTON_Y);
        ToggleButton newAmulet = createButton(NEW_BUTTON_IMAGE, NEW_AMULET_BUTTON_START_X, NEW_AMULET_BUTTON_START_Y, NEW_BUTTON_X, NEW_GAME_BUTTON_Y);
        ToggleButton newItem = createButton(NEW_BUTTON_IMAGE, NEW_ITEM_BUTTON_START_X, NEW_ITEM_BUTTON_START_Y, NEW_BUTTON_X, NEW_GAME_BUTTON_Y);
        newCard.setOnAction(event -> {
        });
        newSpell.setOnAction(event -> {
        });
        newAmulet.setOnAction(event -> {
            goToScene(new EditAmulets());
        });
        newItem.setOnAction(event -> {
            goToScene(new EditItems());
        });
        add(newCard);
        add(newSpell);
        add(newAmulet);
        add(newItem);
    }//todo

    private void addItems() {

        int itemNumber = 0;
        for (Item item : Item.items)
            if (item.custom) {
                Text text = new Text(ITEM_BUTTONS_WIDTH, ITEM_BUTTONS_HEIGHT, item.getName());
                text.relocate(ITEM_BUTTONS_START_X, FIRST_ITEM_BUTTON_START_Y + itemNumber *
                        (ITEM_BUTTONS_HEIGHT + ITEM_BUTTONS_Y_DISTANCE));
                text.setFont(ITEM_BUTTONS_FONT);
                text.setOnMouseClicked(event -> {
                    if (selectedItem == text) {
                        selectedItem = null;
                        text.setFont(ITEM_BUTTONS_FONT);
                    } else {
                        if (selectedItem != null)
                            selectedItem.setFont(ITEM_BUTTONS_FONT);
                        selectedItem = text;
                        text.setFont(ITEM_BUTTONS_SELECTED_MODE_FONT);
                    }
                });
                add(text);
                EditGame.this.items.add(text);
                itemNumber++;
            }
    }

    private void addAmulets() {
//        showObject(Amulet.amulets.toArray(new Component[Amulet.amulets.size()]), AMULET_BUTTONS_START_X,
//                FIRST_AMULET_BUTTON_START_Y, AMULET_BUTTONS_WIDTH * 10, AMULET_BUTTONS_HEIGHT * 10,
//                AMULET_BUTTONS_Y_DISTANCE, AMULET_BUTTONS_FONT, AMULET_BUTTONS_SELECTED_MODE_FONT, selectedAmulet);
        int amuletNumber = 0;
        for (Amulet amulet : Amulet.amulets)
            if (amulet.custom) {
                Text text = new Text(AMULET_BUTTONS_WIDTH, AMULET_BUTTONS_HEIGHT, amulet.getName());
                text.relocate(AMULET_BUTTONS_START_X, FIRST_AMULET_BUTTON_START_Y + amuletNumber *
                        (AMULET_BUTTONS_HEIGHT + AMULET_BUTTONS_Y_DISTANCE));
                text.setFont(AMULET_BUTTONS_FONT);
                text.setOnMouseClicked(event -> {
                    if (selectedAmulet == text) {
                        selectedAmulet = null;
                        text.setFont(AMULET_BUTTONS_FONT);
                    } else {
                        if (selectedAmulet != null)
                            selectedAmulet.setFont(AMULET_BUTTONS_FONT);
                        selectedAmulet = text;
                        text.setFont(AMULET_BUTTONS_SELECTED_MODE_FONT);
                    }
                });
                add(text);
                EditGame.this.amulets.add(text);
                amuletNumber++;
            }
    }


    private void addSpells() {
        int spellNumber = 0;
        for (Cards.Spell.Spell spell : Cards.Spell.Spell.spells)
            if (spell.custom) {
                Text text = new Text(SPELL_BUTTONS_WIDTH,SPELL_BUTTONS_HEIGHT,spell.getName());
                text.relocate(SPELL_BUTTONS_START_X, FIRST_SPELL_BUTTON_START_Y + spellNumber *
                        (SPELL_BUTTONS_HEIGHT + SPELL_BUTTONS_Y_DISTANCE));
                text.setFont(SPELL_BUTTONS_FONT);
                text.setOnMouseClicked(event -> {
                    if (selectedSpell == text) {
                        selectedSpell = null;
                        text.setFont(SPELL_BUTTONS_FONT);
                    } else {
                        if(selectedSpell!=null)
                            selectedSpell.setFont(SPELL_BUTTONS_FONT);
                        selectedSpell = text;
                        text.setFont(SPELL_BUTTONS_SELECTED_MODE_FONT);
                    }
                });
                add(text);
                EditGame.this.spells.add(text);
                spellNumber++;
            }
    }

    private void addCards() {
        int cardNumber = 0;
        for (Card card : Card.cards)
            if (card.custom) {
                String name = card.getName();
                Text text = new Text(CARD_BUTTONS_WIDTH,CARD_BUTTONS_HEIGHT,name);
                text.relocate(CARD_BUTTONS_START_X, FIRST_CARD_BUTTON_START_Y + cardNumber *
                        (CARD_BUTTONS_HEIGHT + CARD_BUTTONS_Y_DISTANCE));
                text.setFont(CARD_BUTTONS_FONT);
                text.setOnMouseClicked(event -> {
                    if (selectedCard == text) {
                        selectedCard = null;
                        text.setFont(CARD_BUTTONS_FONT);
                    } else {
                        if(selectedCard!=null)
                            selectedCard.setFont(CARD_BUTTONS_FONT);
                        selectedCard = text;
                        text.setFont(CARD_BUTTONS_SELECTED_MODE_FONT);
                    }
                });
                add(text);
                EditGame.this.cards.add(text);
                cardNumber++;
            }
    }
    @Override
    public void refresh(){}//todo
}