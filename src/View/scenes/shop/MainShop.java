package View.scenes.shop;

import Cards.ComponentType;
import View.scenes.Scene;
import View.scenes.inventory.InventoryMenu;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import static View.Graphics.goToScene;
import static data.constants.scenes.shop.MainShop.*;


public class MainShop extends Scene {
    public MainShop() {
        super();
        showGil();
        addCardShopButton();
        addAmuletShopButton();
        addItemShopButton();
    }

    private void addItemShopButton() {
        Button button = createButton(ITEM_SHOP_BUTTON_TEXT,ITEM_SHOP_BUTTON_START_X,ITEM_SHOP_BUTTON_START_Y,ITEM_SHOP_BUTTON_X,ITEM_SHOP_BUTTON_Y,ITEM_SHOP_FONT);
        button.setOnAction(event -> goToScene(new ComponentShop(ComponentType.Item)));
        add(button);
    }

    private void addAmuletShopButton() {
        Button button = createButton(AMULET_SHOP_BUTTON_TEXT,AMULET_SHOP_BUTTON_START_X,AMULET_SHOP_BUTTON_START_Y,AMULET_SHOP_BUTTON_X,AMULET_SHOP_BUTTON_Y,AMULET_SHOP_FONT);
        button.setOnAction(event -> goToScene(new ComponentShop(ComponentType.Amulet)));
        add(button);
    }

    private void addCardShopButton() {
        Button button = createButton(CARD_SHOP_BUTTON_TEXT,CARD_SHOP_BUTTON_START_X,CARD_SHOP_BUTTON_START_Y,CARD_SHOP_BUTTON_X,CARD_SHOP_BUTTON_Y,CARD_SHOP_FONT);
        button.setOnAction(event -> goToScene(new ComponentShop(ComponentType.Card)));
        add(button);
    }
    @Override
    public void refresh(){
        //todo
    }
}
