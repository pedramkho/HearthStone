package data.constants.scenes.inventory;

import data.constants.GamePlay;
import javafx.scene.image.Image;
import javafx.scene.text.Font;

public class ComponentInventory {

        public static final double COMPONENT_BUTTONS_WIDTH = 200;
        public static final double COMPONENT_BUTTONS_HEIGHT = 200;

        public static final double INVENTORY_ACTION_BUTTONS_START_X = 450;
        public static final double INVENTORY_ACTION_BUTTONS_Y_DISTANCE = 30;
        public static final double INVENTORY_ACTION_BUTTONS_X = GamePlay.INVENTORY_ACTION_BUTTONS_X;
        public static final double INVENTORY_ACTION_BUTTONS_Y = GamePlay.INVENTORY_ACTION_BUTTONS_Y;
        public static final double INVENTORY_ACTION_BUTTONS_START_Y_DISTANCE = INVENTORY_ACTION_BUTTONS_Y_DISTANCE + INVENTORY_ACTION_BUTTONS_Y;


        public static final double INVENTORY_COMPONENT_BUTTONS_WIDTH = COMPONENT_BUTTONS_WIDTH;
        public static final double INVENTORY_COMPONENT_BUTTONS_HEIGHT = COMPONENT_BUTTONS_HEIGHT;
        public static final double INVENTORY_COMPONENTS_START_X = 240;
        public static final double INVENTORY_COMPONENT_BUTTONS_Y_DISTANCE = 10;
        public static final double INVENTORY_COMPONENT_START_Y = 200;
        public static final int INVENTORY_COMPONENT_BUTTONS_FONT_SIZE = 10;
        public static final Font INVENTORY_COMPONENT_BUTTONS_FONT = new Font(INVENTORY_COMPONENT_BUTTONS_FONT_SIZE);
        public static final int INVENTORY_COMPONENT_BUTTONS_SELECTED_MODE_FONT_SIZE = 15;
        public static final Font INVENTORY_COMPONENT_BUTTONS_SELECTED_MODE_FONT = new Font(INVENTORY_COMPONENT_BUTTONS_SELECTED_MODE_FONT_SIZE);

        public static final double DECK_COMPONENT_BUTTONS_WIDTH = COMPONENT_BUTTONS_WIDTH;
        public static final double DECK_COMPONENT_BUTTONS_HEIGHT = COMPONENT_BUTTONS_HEIGHT;
        public static final double DECK_COMPONENTS_START_X = 500;
        public static final double DECK_COMPONENT_BUTTONS_Y_DISTANCE = 10;
        public static final double DECK_COMPONENT_START_Y = 200;
        public static final int DECK_COMPONENT_BUTTONS_FONT_SIZE = 10;
        public static final Font DECK_COMPONENT_BUTTONS_FONT = new Font(DECK_COMPONENT_BUTTONS_FONT_SIZE);
        public static final int DECK_COMPONENT_BUTTONS_SELECTED_MODE_FONT_SIZE = 15;
        public static final Font DECK_COMPONENT_BUTTONS_SELECTED_MODE_FONT = new Font(DECK_COMPONENT_BUTTONS_SELECTED_MODE_FONT_SIZE);

        public static final double ADD_TO_DECK_BUTTON_START_X = INVENTORY_ACTION_BUTTONS_START_X;
        public static final double ADD_TO_DECK_BUTTON_START_Y = 200;
        public static final double ADD_TO_DECK_BUTTON_X = GamePlay.ADD_BUTTON_X;
        public static final double ADD_TO_DECK_BUTTON_Y = GamePlay.ADD_BUTTON_Y;
        public static final Image ADD_TO_DECK_BUTTON_IMAGE = GamePlay.ADD_BUTTON_IMAGE;

        public static final double REMOVE_FROM_DECK_BUTTON_START_X = 720;
        public static final double REMOVE_FROM_DECK_BUTTON_START_Y = 220;
        public static final double REMOVE_FROM_DECK_BUTTON_X = GamePlay.REMOVE_BUTTON_X;
        public static final double REMOVE_FROM_DECK_BUTTON_Y = GamePlay.REMOVE_BUTTON_Y;
        public static final Image REMOVE_FROM_DECK_BUTTON_IMAGE = GamePlay.REMOVE_BUTTON_IMAGE;

        public static final double INVENTORY_COMPONENTS_INFO_BUTTON_START_X = INVENTORY_ACTION_BUTTONS_START_X;
        public static final double INVENTORY_COMPONENTS_INFO_BUTTON_START_Y = ADD_TO_DECK_BUTTON_START_Y + INVENTORY_ACTION_BUTTONS_START_Y_DISTANCE;
        public static final double INVENTORY_COMPONENTS_INFO_BUTTON_X = GamePlay.INFO_BUTTON_X;
        public static final double INVENTORY_COMPONENTS_INFO_BUTTON_Y = GamePlay.INFO_BUTTON_Y;
        public static final Image INVENTORY_COMPONENTS_INFO_BUTTON_IMAGE = GamePlay.INFO_BUTTON_IMAGE;


        public static final double DECK_CARDS_INFO_BUTTON_START_X = 720;
        public static final double DECK_CARDS_INFO_BUTTON_START_Y = 300;
        public static final double DECK_CARDS_INFO_BUTTON_X = GamePlay.INFO_BUTTON_X;
        public static final double DECK_CARDS_INFO_BUTTON_Y = GamePlay.INFO_BUTTON_Y;
        public static final Image DECK_CARDS_INFO_BUTTON_IMAGE = GamePlay.INFO_BUTTON_IMAGE;


        public static final double CHANGE_NUMBER_BUTTON_START_X = 720;
        public static final double CHANGE_NUMBER_BUTTON_START_Y = 250;
        public static final double CHANGE_NUMBER_BUTTON_X = GamePlay.CHANGE_NUMBER_BUTTON_X;
        public static final double CHANGE_NUMBER_BUTTON_Y = GamePlay.CHANGE_NUMBER_BUTTON_Y;
        public static final Image CHANGE_NUMBER_BUTTON_IMAGE = GamePlay.CHANGE_NUMBER_BUTTON_IMAGE;


        public static final double EQUIP_BUTTON_START_X = INVENTORY_ACTION_BUTTONS_START_X;
        public static final double EQUIP_BUTTON_START_Y = 300;
        public static final double EQUIP_BUTTON_X = GamePlay.EQUIP_BUTTON_X;
        public static final double EQUIP_BUTTON_Y = GamePlay.EQUIP_BUTTON_Y;
        public static final Image EQUIP_BUTTON_IMAGE = GamePlay.EQUIP_BUTTON_IMAGE;


        public static final double DEEQUIP_BUTTON_START_X = INVENTORY_ACTION_BUTTONS_START_X;
        public static final double DEEQUIP_BUTTON_START_Y = 350;
        public static final double DEEQUIP_BUTTON_X = GamePlay.DEEQUIP_BUTTON_X;
        public static final double DEEQUIP_BUTTON_Y = GamePlay.DEEQUIP_BUTTON_Y;
        public static final Image DEEQUIP_BUTTON_IMAGE = GamePlay.DEEQUIP_BUTTON_IMAGE;


        public static final String EQUIPPED_AMULET_TEXT = "";
        public static final double EQUIPPED_AMULET_START_X = 450;
        public static final double EQUIPPED_AMULET_START_Y = 150;
        public static final double EQUIPPED_AMULET_X = 0;
        public static final double EQUIPPED_AMULET_Y = 0;
        public static final String AMULET_NOT_EQUIPEED_TEXT = "No amulet equipped";
        public static final String EQUIPPED_AMULET_TEXT_TEXT = "Equipped Amulet : ";
        public static final double EQUIPPED_AMULET_TEXT_START_X = 300;
        public static final double EQUIPPED_AMULET_TEXT_START_Y = 150;
        public static final double EQUIPPED_AMULET_TEXT_X = 0;
        public static final double EQUIPPED_AMULET_TEXT_Y = 0;
}