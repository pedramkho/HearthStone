package View.scenes.inventory;

import Cards.Card;
import Cards.ComponentType;
import ItemsAndAmulets.Amulet;
import View.scenes.Scene;
import View.scenes.TextContainer;
import com.company.Main;
import exceptions.inventoryExceptions.DeckIsFull;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToggleButton;
import javafx.scene.text.Text;

import java.util.Optional;

import static Cards.Component.getComponent;
import static data.constants.scenes.inventory.ComponentInventory.*;
import static java.lang.Integer.parseInt;

public class ComponentInventory extends Scene {
    private ScrollPane inventoryComponentsScrollPane;
    private ScrollPane deckCardsScrollPane = null;
    private final TextContainer selectedCOMPONENT = new TextContainer();
    private final TextContainer selectedDeckCard = new TextContainer();
    private Text equippedAmulet = null;
    private ComponentType componentType;
    public ComponentInventory(ComponentType componentType){
        super();
        this.componentType = componentType;
        addBackButton(new InventoryMenu());
        addInventoryComponentsButtons();
        addInventoryComponentInfoButton();
        switch (componentType){
            case Card:
                addDeckCardButtons();
                addAddToDeckButton();
                addRemoveFromDeckButton();
                addDeckCardInfoButton();
                addChangeNumberButton();
                break;
            case Amulet:
                addEquipAmuletButton();
                addRemoveEquippedAmuletButton();
                showEquippedAmulet();
        }
    }

    private void addEquipAmuletButton() {
        ToggleButton button = createButton(EQUIP_BUTTON_IMAGE,EQUIP_BUTTON_START_X,EQUIP_BUTTON_START_Y,EQUIP_BUTTON_X,
                EQUIP_BUTTON_Y);
        button.setOnAction(event -> {
            if(selectedCOMPONENT.text!=null){
                Main.player.inventory.equipAmulet((Amulet)getComponent(selectedCOMPONENT.text.getText()));
                refresh();
            }
        });
        add(button);
    }
    private void addRemoveEquippedAmuletButton(){
        ToggleButton button = createButton(DEEQUIP_BUTTON_IMAGE,DEEQUIP_BUTTON_START_X,DEEQUIP_BUTTON_START_Y,
                DEEQUIP_BUTTON_X,DEEQUIP_BUTTON_Y);
        button.setOnAction(event -> {
            Main.player.inventory.removeEquippedAmulet();
            refresh();
        });
        add(button);
    }

    private void addDeckCardButtons() {
        deckCardsScrollPane = showObjects(Main.player.inventory.getDeck(),DECK_COMPONENTS_START_X,
                DECK_COMPONENT_START_Y,DECK_COMPONENT_BUTTONS_WIDTH,DECK_COMPONENT_BUTTONS_HEIGHT,
                DECK_COMPONENT_BUTTONS_Y_DISTANCE,DECK_COMPONENT_BUTTONS_FONT,DECK_COMPONENT_BUTTONS_SELECTED_MODE_FONT,
                selectedDeckCard,false,false,true);
    }

    private void addChangeNumberButton() {
        ToggleButton button = createButton(CHANGE_NUMBER_BUTTON_IMAGE,CHANGE_NUMBER_BUTTON_START_X,CHANGE_NUMBER_BUTTON_START_Y,
                CHANGE_NUMBER_BUTTON_X,CHANGE_NUMBER_BUTTON_Y);
        button.setOnAction(event -> {
            if(selectedDeckCard!=null){
                TextInputDialog textInputDialog = new TextInputDialog("number");
                textInputDialog.setTitle("Slot Number");
                textInputDialog.setHeaderText("Enter slot number:");
                textInputDialog.setContentText("Number::");
                Optional<String> name = textInputDialog.showAndWait();
                name.ifPresent(number -> {
                    if(isNumber(number)) {
                        String inputNumber = selectedDeckCard.text.getText();
                        inputNumber = inputNumber.substring(0,inputNumber.indexOf("."));
                        Main.player.inventory.swapDeckCards(parseInt(inputNumber)-1,parseInt(number)-1);
                        selectedDeckCard.text = null;
                        refresh();
                    }
                });
            }
        });
        add(button);
    }

    private void addDeckCardInfoButton() {
        ToggleButton button = createButton(DECK_CARDS_INFO_BUTTON_IMAGE,DECK_CARDS_INFO_BUTTON_START_X,
                DECK_CARDS_INFO_BUTTON_START_Y,DECK_CARDS_INFO_BUTTON_X,DECK_CARDS_INFO_BUTTON_Y);
        button.setOnAction(event -> {
            if(selectedDeckCard.text!=null)
                showMessage(getComponent(selectedDeckCard.text.getText()).getInfo(),componentType);
        });
        add(button);
    }

    private void addInventoryComponentsButtons() {
        inventoryComponentsScrollPane = showObjects(getPlayerComponents(componentType,false),INVENTORY_COMPONENTS_START_X,
                INVENTORY_COMPONENT_START_Y,INVENTORY_COMPONENT_BUTTONS_WIDTH,INVENTORY_COMPONENT_BUTTONS_HEIGHT,
                INVENTORY_COMPONENT_BUTTONS_Y_DISTANCE,INVENTORY_COMPONENT_BUTTONS_FONT,INVENTORY_COMPONENT_BUTTONS_SELECTED_MODE_FONT,
                selectedCOMPONENT,false,false,false);
    }
    private void addInventoryComponentInfoButton() {
        ToggleButton button = createButton(INVENTORY_COMPONENTS_INFO_BUTTON_IMAGE,INVENTORY_COMPONENTS_INFO_BUTTON_START_X,
                INVENTORY_COMPONENTS_INFO_BUTTON_START_Y,INVENTORY_COMPONENTS_INFO_BUTTON_X,INVENTORY_COMPONENTS_INFO_BUTTON_Y);
        button.setOnAction(event -> {
            if(selectedCOMPONENT.text!=null)
                showMessage(getComponent(selectedCOMPONENT.text.getText()).getInfo(),componentType);
        });
        add(button);
    }
    private void addAddToDeckButton(){
        ToggleButton button = createButton(ADD_TO_DECK_BUTTON_IMAGE,ADD_TO_DECK_BUTTON_START_X,ADD_TO_DECK_BUTTON_START_Y,
                ADD_TO_DECK_BUTTON_X,ADD_TO_DECK_BUTTON_Y);
        button.setOnAction(event -> {
            if(selectedCOMPONENT.text!=null){
                try {
                    Card card = (Card) getComponent(selectedCOMPONENT.text.getText());
                    Main.player.inventory.addToDeck(card);
                    selectedCOMPONENT.text = null;
                    refresh();
                }catch (DeckIsFull exception){
                    exception.printStackTrace();
                }
            }
        });
        add(button);
    }
    private void addRemoveFromDeckButton(){
        ToggleButton button = createButton(REMOVE_FROM_DECK_BUTTON_IMAGE,REMOVE_FROM_DECK_BUTTON_START_X,
                REMOVE_FROM_DECK_BUTTON_START_Y,REMOVE_FROM_DECK_BUTTON_X,REMOVE_FROM_DECK_BUTTON_Y);
        button.setOnAction(event -> {
            if(selectedDeckCard.text!=null){
                Card card = (Card) getComponent(selectedDeckCard.text.getText());
                Main.player.inventory.removeFromDeck(card);
                selectedDeckCard.text = null;
                refresh();
            }
        });
        add(button);
    }
    private void showEquippedAmulet(){
        Text equippedAmuletText = createText(EQUIPPED_AMULET_TEXT_TEXT,EQUIPPED_AMULET_TEXT_START_X,EQUIPPED_AMULET_TEXT_START_Y);
        equippedAmulet = createText((Main.player.inventory.equippedAmulet!=null)?Main.player.inventory.equippedAmulet.getName():
                        AMULET_NOT_EQUIPEED_TEXT, EQUIPPED_AMULET_START_X,EQUIPPED_AMULET_START_Y);
        add(equippedAmuletText);
        add(equippedAmulet);
    }
    @Override
    public void refresh(){
        switch (componentType){
            case Card:
                remove(deckCardsScrollPane);
                addDeckCardButtons();
                break;
            case Amulet:
                remove(equippedAmulet);
                showEquippedAmulet();
        }
        remove(inventoryComponentsScrollPane);
        addInventoryComponentsButtons();
    }
}