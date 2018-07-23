package View.scenes.inventory;

import Cards.ComponentType;
import Shops.ShopMenu;
import View.scenes.Scene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import static View.Graphics.goToScene;
import static data.constants.scenes.inventory.InventoryMenu.*;

public class InventoryMenu extends Scene {
    public InventoryMenu() {
        super();
        addCardINVENTORYButton();
        addAmuletINVENTORYButton();
        addItemINVENTORYButton();
        addBackButton(new View.scenes.shop.MainShop());
    }

    private void addItemINVENTORYButton() {
        Button button = createButton(ITEM_INVENTORY_BUTTON_TEXT, ITEM_INVENTORY_BUTTON_START_X, ITEM_INVENTORY_BUTTON_START_Y, ITEM_INVENTORY_BUTTON_X, ITEM_INVENTORY_BUTTON_Y, ITEM_INVENTORY_FONT);
        button.setOnAction(event -> goToScene(new ComponentInventory(ComponentType.Item)));
        add(button);
    }

    private void addAmuletINVENTORYButton() {
        Button button = createButton(AMULET_INVENTORY_BUTTON_TEXT, AMULET_INVENTORY_BUTTON_START_X, AMULET_INVENTORY_BUTTON_START_Y, AMULET_INVENTORY_BUTTON_X, AMULET_INVENTORY_BUTTON_Y, AMULET_INVENTORY_FONT);
        button.setOnAction(event -> goToScene(new ComponentInventory(ComponentType.Amulet)));
        add(button);
    }

    private void addCardINVENTORYButton() {
        Button button = createButton(CARD_INVENTORY_BUTTON_TEXT, CARD_INVENTORY_BUTTON_START_X, CARD_INVENTORY_BUTTON_START_Y, CARD_INVENTORY_BUTTON_X, CARD_INVENTORY_BUTTON_Y, CARD_INVENTORY_FONT);
        button.setOnAction(event -> goToScene(new ComponentInventory(ComponentType.Card)));
        add(button);
    }

    @Override
    public void refresh() {
        //todo
    }
}