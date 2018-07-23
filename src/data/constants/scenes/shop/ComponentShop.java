package data.constants.scenes.shop;

import data.constants.GamePlay;
import javafx.scene.image.Image;
import javafx.scene.text.Font;

import java.lang.reflect.GenericArrayType;

public class ComponentShop {
    public static final double COMPONENT_BUTTONS_WIDTH = 200;
    public static final double COMPONENT_BUTTONS_HEIGHT = 200;

    public static final double SHOP_ACTION_BUTTONS_START_X = 400;
    public static final double SHOP_ACTION_BUTTONS_Y_DISTANCE = 30;
    public static final double SHOP_ACTION_BUTTONS_X = GamePlay.SHOP_ACTION_BUTTONS_X;
    public static final double SHOP_ACTION_BUTTONS_Y = GamePlay.SHOP_ACTION_BUTTONS_Y;
    public static final double SHOP_ACTION_BUTTONS_START_Y_DISTANCE = SHOP_ACTION_BUTTONS_Y_DISTANCE + SHOP_ACTION_BUTTONS_Y;


    public static final double SHOP_COMPONENT_BUTTONS_WIDTH = COMPONENT_BUTTONS_WIDTH;
    public static final double SHOP_COMPONENT_BUTTONS_HEIGHT = COMPONENT_BUTTONS_HEIGHT;
    public static final double SHOP_COMPONENTS_START_X = 150;
    public static final double SHOP_COMPONENT_BUTTONS_Y_DISTANCE = 10;
    public static final double SHOP_CATDS_START_Y = 200;
    public static final int SHOP_COMPONENT_BUTTONS_FONT_SIZE = 10;
    public static final Font SHOP_COMPONENT_BUTTONS_FONT = new Font(SHOP_COMPONENT_BUTTONS_FONT_SIZE);
    public static final int SHOP_COMPONENT_BUTTONS_SELECTED_MODE_FONT_SIZE = 15;
    public static final Font SHOP_COMPONENT_BUTTONS_SELECTED_MODE_FONT = new Font(SHOP_COMPONENT_BUTTONS_SELECTED_MODE_FONT_SIZE);


    public static final double PLAYER_COMPONENT_BUTTONS_WIDTH = COMPONENT_BUTTONS_WIDTH;
    public static final double PLAYER_COMPONENT_BUTTONS_HEIGHT = COMPONENT_BUTTONS_HEIGHT;
    public static final double PLAYER_COMPONENTS_START_X = 500;
    public static final double PLAYER_COMPONENT_BUTTONS_Y_DISTANCE = 10;
    public static final double PLAYER_CATDS_START_Y = 200;
    public static final int PLAYER_COMPONENT_BUTTONS_FONT_SIZE = 10;
    public static final Font PLAYER_COMPONENT_BUTTONS_FONT = new Font(PLAYER_COMPONENT_BUTTONS_FONT_SIZE);
    public static final int PLAYER_COMPONENT_BUTTONS_SELECTED_MODE_FONT_SIZE = 15;
    public static final Font PLAYER_COMPONENT_BUTTONS_SELECTED_MODE_FONT = new Font(PLAYER_COMPONENT_BUTTONS_SELECTED_MODE_FONT_SIZE);


    public static final double BUY_BUTTON_START_X = SHOP_ACTION_BUTTONS_START_X;
    public static final double BUY_BUTTON_START_Y = 100;
    public static final double BUY_BUTTON_X = GamePlay.BUY_BUTTON_X;
    public static final double BUY_BUTTON_Y = GamePlay.BUY_BUTTON_Y;
    public static final Image BUY_BUTTON_IMAGE = GamePlay.BUY_BUTTON_IMAGE;


    public static final double SELL_BUTTON_START_X = SHOP_ACTION_BUTTONS_START_X;
    public static final double SELL_BUTTON_START_Y = BUY_BUTTON_START_Y+SHOP_ACTION_BUTTONS_START_Y_DISTANCE;
    public static final double SELL_BUTTON_X = GamePlay.SELL_BUTTON_X;
    public static final double SELL_BUTTON_Y = GamePlay.SELL_BUTTON_Y;
    public static final Image SELL_BUTTON_IMAGE = GamePlay.SELL_BUTTON_IMAGE;


    public static final double SHOP_COMPONENTS_INFO_BUTTON_START_X = SHOP_ACTION_BUTTONS_START_X;
    public static final double SHOP_COMPONENTS_INFO_BUTTON_START_Y = BUY_BUTTON_START_Y+2*SHOP_ACTION_BUTTONS_START_Y_DISTANCE;
    public static final double SHOP_COMPONENTS_INFO_BUTTON_X = GamePlay.INFO_BUTTON_X;
    public static final double SHOP_COMPONENTS_INFO_BUTTON_Y = GamePlay.INFO_BUTTON_Y;
    public static final Image SHOP_COMPONENTS_INFO_BUTTON_IMAGE = GamePlay.INFO_BUTTON_IMAGE;


    public static final double PLAYER_COMPONENTS_INFO_BUTTON_START_X = 470;
    public static final double PLAYER_COMPONENTS_INFO_BUTTON_START_Y = 500;
    public static final double PLAYER_COMPONENTS_INFO_BUTTON_X = GamePlay.INFO_BUTTON_X;
    public static final double PLAYER_COMPONENTS_INFO_BUTTON_Y = GamePlay.INFO_BUTTON_Y;
    public static final Image PLAYER_COMPONENTS_INFO_BUTTON_IMAGE = GamePlay.INFO_BUTTON_IMAGE;
}
