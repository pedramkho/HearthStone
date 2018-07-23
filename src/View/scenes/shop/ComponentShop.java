package View.scenes.shop;

import Cards.Component;
import Cards.ComponentType;
import Player.Player;
import View.scenes.Scene;
import View.scenes.TextContainer;
import com.company.Main;
import exceptions.shopExceptions.ShopException;
import javafx.scene.Group;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Optional;

import static Cards.Component.*;
import static data.constants.scenes.shop.ComponentShop.*;

public class ComponentShop extends Scene {
    public ScrollPane shopCOMPONENTsScrollPane;
    public ScrollPane playerCOMPONENTsScrollPane;
    public final TextContainer selectedShopCOMPONENT = new TextContainer();
    public final TextContainer selectedPlayerCOMPONENT = new TextContainer();
    public ComponentType componentType;
    private Text gil;
    public ComponentShop(ComponentType componentType){
        super();
        gil = showGil();
        this.componentType = componentType;
        addBackButton(new MainShop());
        showShopComponents();
        showPlayerComponents();
        addBuyOrSellButton(true,BUY_BUTTON_IMAGE,BUY_BUTTON_START_X,BUY_BUTTON_START_Y,BUY_BUTTON_X,BUY_BUTTON_Y,selectedShopCOMPONENT,
                Main.player,"COMPONENT",SHOP_COMPONENT_BUTTONS_FONT);
        addBuyOrSellButton(false,SELL_BUTTON_IMAGE,SELL_BUTTON_START_X,SELL_BUTTON_START_Y,SELL_BUTTON_X,SELL_BUTTON_Y,
                selectedPlayerCOMPONENT,Main.player,"COMPONENT",SHOP_COMPONENT_BUTTONS_FONT);
        addInfoButton(SHOP_COMPONENTS_INFO_BUTTON_IMAGE,SHOP_COMPONENTS_INFO_BUTTON_START_X,SHOP_COMPONENTS_INFO_BUTTON_START_Y,
                SHOP_COMPONENTS_INFO_BUTTON_X,SHOP_COMPONENTS_INFO_BUTTON_Y,selectedShopCOMPONENT);
        addInfoButton(PLAYER_COMPONENTS_INFO_BUTTON_IMAGE,PLAYER_COMPONENTS_INFO_BUTTON_START_X,PLAYER_COMPONENTS_INFO_BUTTON_START_Y,
                PLAYER_COMPONENTS_INFO_BUTTON_X,PLAYER_COMPONENTS_INFO_BUTTON_Y,selectedPlayerCOMPONENT);
        //todo : addTitle
    }

    private void showPlayerComponents() {
        playerCOMPONENTsScrollPane = showObjects(getPlayerComponents(componentType,true),PLAYER_COMPONENTS_START_X,PLAYER_CATDS_START_Y,PLAYER_COMPONENT_BUTTONS_WIDTH,
                PLAYER_COMPONENT_BUTTONS_HEIGHT,PLAYER_COMPONENT_BUTTONS_Y_DISTANCE,PLAYER_COMPONENT_BUTTONS_FONT,PLAYER_COMPONENT_BUTTONS_SELECTED_MODE_FONT,
                selectedPlayerCOMPONENT,true,false,false);
    }

    private void showShopComponents() {
        shopCOMPONENTsScrollPane = showObjects(getShopComponents(componentType),SHOP_COMPONENTS_START_X,SHOP_CATDS_START_Y,SHOP_COMPONENT_BUTTONS_WIDTH,
                SHOP_COMPONENT_BUTTONS_HEIGHT,SHOP_COMPONENT_BUTTONS_Y_DISTANCE,SHOP_COMPONENT_BUTTONS_FONT,SHOP_COMPONENT_BUTTONS_SELECTED_MODE_FONT,
                selectedShopCOMPONENT ,true,true,false);
    }

    private Component[] getShopComponents(ComponentType componentType){
        ArrayList<Component> components = new ArrayList<>();
        Component[] gameComponents = getGameComponents(componentType);
        for(Component component : gameComponents)
            if(component.isThereInShop())
                components.add(component);
        return components.toArray(new Component[components.size()]);
    }

    public void addBuyOrSellButton(boolean buy, Image image, double startX, double startY, double width, double height,
                                   TextContainer selectedTextContainer, Player player, String shopComponentType, Font defaultModeFont) {
        ToggleButton button = createButton(image, startX, startY, width, height);
        button.setOnAction(event -> {
            if (selectedTextContainer.text != null) {
                TextInputDialog numberToTrade = new TextInputDialog("number");
                numberToTrade.setTitle((buy ? "Buy " : "Sell ") + shopComponentType);
                numberToTrade.setHeaderText("Enter numbers to " +(buy?"Buy":"Sell")+ ":");
                numberToTrade.setContentText("number:");
                Optional<String> name = numberToTrade.showAndWait();
                name.ifPresent(name1 -> {
                    try {
                        if(buy)
                            Shops.Shop.buy(player, Integer.parseInt(name1), getComponent(selectedTextContainer.text.getText()));
                        else
                            Shops.Shop.sell(player, Integer.parseInt(name1), getComponent(selectedTextContainer.text.getText()));
                        changeSelectedText(selectedTextContainer,selectedTextContainer.text,defaultModeFont,null);
                    } catch (ShopException e) {
                        //todo
                    }
                });
                refresh();
            }
        });
        add(button);
    }


    @Override
    public void refresh(){
        remove(gil);
        remove(shopCOMPONENTsScrollPane);
        remove(playerCOMPONENTsScrollPane);
        gil = showGil();
        showShopComponents();
        showPlayerComponents();
    }
}
