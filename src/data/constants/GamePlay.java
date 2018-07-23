package data.constants;

import View.Graphics;
import javafx.scene.image.Image;
import javafx.scene.text.Font;

public class GamePlay {
    public static final double WIDTH = Graphics.Width;
    public static final double HEIGHT = Graphics.Height;

    public static final double SHOP_ACTION_BUTTONS_X = 20;
    public static final double SHOP_ACTION_BUTTONS_Y = 20;

    public static final double INVENTORY_ACTION_BUTTONS_X = 20;
    public static final double INVENTORY_ACTION_BUTTONS_Y = 20;

    public static final double DEFAULT_BACK_BUTTON_START_X = 30;
    public static final double DEFAULT_BACK_BUTTON_START_Y = 30;
    public static final double DEFAULT_BACK_BUTTON_X = 30;
    public static final double DEFAULT_BACK_BUTTON_Y = 30;
    public static final Image DEFAULT_BACK_BUTTON_IMAGE = new Image("data/images/general/back button.png",
            DEFAULT_BACK_BUTTON_X, DEFAULT_BACK_BUTTON_Y, false, false);

    public static final int DEFAULT_FONT_SIZE = 15;
    public static final Font DEFAULT_FONT = new Font(DEFAULT_FONT_SIZE);

    public static final double REMOVE_BUTTON_X = SHOP_ACTION_BUTTONS_X;
    public static final double REMOVE_BUTTON_Y = SHOP_ACTION_BUTTONS_Y;
    public static final Image REMOVE_BUTTON_IMAGE = new Image("data/images/general/remove button.png",REMOVE_BUTTON_X,REMOVE_BUTTON_Y,false,false);


    public static final double EDIT_BUTTON_X = SHOP_ACTION_BUTTONS_X;
    public static final double EDIT_BUTTON_Y = SHOP_ACTION_BUTTONS_Y;
    public static final Image EDIT_BUTTON_IMAGE = new Image("data/images/general/edit button.png",EDIT_BUTTON_X,EDIT_BUTTON_Y,false,false);

    public static final double NEW_BUTTON_X = SHOP_ACTION_BUTTONS_X;
    public static final double NEW_BUTTON_Y = SHOP_ACTION_BUTTONS_Y;
    public static final Image NEW_BUTTON_IMAGE = new Image("data/images/general/new button.png",NEW_BUTTON_X,NEW_BUTTON_Y,false,false);

    public static final double BUY_BUTTON_X = SHOP_ACTION_BUTTONS_X;
    public static final double BUY_BUTTON_Y = SHOP_ACTION_BUTTONS_Y;
    public static final Image BUY_BUTTON_IMAGE = new Image("data/images/shop/buy.png",BUY_BUTTON_X,BUY_BUTTON_Y,false,false);

    public static final double SELL_BUTTON_X = SHOP_ACTION_BUTTONS_X;
    public static final double SELL_BUTTON_Y = SHOP_ACTION_BUTTONS_Y;
    public static final Image SELL_BUTTON_IMAGE = new Image("data/images/shop/sell.png",SELL_BUTTON_X,SELL_BUTTON_Y,false,false);

    public static final double INFO_BUTTON_X = SHOP_ACTION_BUTTONS_X;
    public static final double INFO_BUTTON_Y = SHOP_ACTION_BUTTONS_Y;
    public static final Image INFO_BUTTON_IMAGE = new Image("data/images/shop/info.png",INFO_BUTTON_X,INFO_BUTTON_Y,false,false);
    
    public static final double ADD_BUTTON_X = INVENTORY_ACTION_BUTTONS_X;
    public static final double ADD_BUTTON_Y = INVENTORY_ACTION_BUTTONS_Y;
    public static final Image ADD_BUTTON_IMAGE = new Image("data/images/general/new button.png",ADD_BUTTON_X,ADD_BUTTON_Y,false,false);


    public static final double CHANGE_NUMBER_BUTTON_X = INVENTORY_ACTION_BUTTONS_X;
    public static final double CHANGE_NUMBER_BUTTON_Y = INVENTORY_ACTION_BUTTONS_Y;
    public static final Image CHANGE_NUMBER_BUTTON_IMAGE = new Image("data/images/Inventory/change number.png",CHANGE_NUMBER_BUTTON_X,CHANGE_NUMBER_BUTTON_Y,false,false);

    public static final double EQUIP_BUTTON_X = INVENTORY_ACTION_BUTTONS_X;
    public static final double EQUIP_BUTTON_Y = INVENTORY_ACTION_BUTTONS_Y;
    public static final Image EQUIP_BUTTON_IMAGE = new Image("data/images/Inventory/equip.png",EQUIP_BUTTON_X,EQUIP_BUTTON_Y,false,false);

    public static final double DEEQUIP_BUTTON_X = INVENTORY_ACTION_BUTTONS_X;
    public static final double DEEQUIP_BUTTON_Y = INVENTORY_ACTION_BUTTONS_Y;
    public static final Image DEEQUIP_BUTTON_IMAGE = new Image("data/images/Inventory/deequip.png",DEEQUIP_BUTTON_X,DEEQUIP_BUTTON_Y,false,false);

    public static final double GIL_TEXT_X = 780;
    public static final double GIL_TEXT_Y = 30;
    public static final int GIL_FONT_SIZE = 15;
    public static final Font GIL_FONT = new Font(GIL_FONT_SIZE);

    public static final double GIL_IMAGE_X = 780;
    public static final double GIL_IMAGE_Y = 40;
    public static final double GIL_IMAGE_WIDTH = 30;
    public static final double GIL_IMAGE_HEIGHT = 30;
    public static final Image GIL_IMAGE = new Image("data/images/shop/gil.png",GIL_IMAGE_WIDTH,GIL_IMAGE_HEIGHT,false,false);
}