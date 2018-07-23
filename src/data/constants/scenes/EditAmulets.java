package data.constants.scenes;

import View.scenes.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

import java.awt.*;

import static data.constants.GamePlay.*;

public class EditAmulets {
    public static final Paint BACKGROUND = null;

    public static final String TITLE = "Create new custom amulet";
    public static final int TITLE_FONT_SIZE = 20;
    public static final Font TITLE_FONT = new Font(TITLE_FONT_SIZE);
    public static final double TITILE_START_X = 400;
    public static final double TITILE_START_Y = 50;

    public static final double TEXTS_OF_TEXTFIELDS_START_X = 300;
    public static final double TEXT_FIELDS_Y_DISTANCE = 50;
    public static final double TEXTFIELDS_X = 100;
    public static final double TEXTFIELDS_Y = 30;
    public static final double TEXTS_X = 50;

    public static final String NAME_TEXTFIELD_TEXT = "Amulet name";
    public static final double NAME_TEXTFIELD_START_X = TEXTS_OF_TEXTFIELDS_START_X;
    public static final double NAME_TEXTFIELD_START_Y = 100;
    public static final double NAME_TEXTFIELD_X = TEXTFIELDS_X;
    public static final double NAME_TEXTFIELD_Y = TEXTFIELDS_Y;
    public static final String NAME_TEXT_TEXT = "Name:";
    public static final double NAME_TEXT_START_X = TEXTS_X;
    public static final double NAME_TEXT_START_Y = NAME_TEXTFIELD_START_Y;
    public static final double NAME_TEXT_X = 0;
    public static final double NAME_TEXT_Y = 0;

    public static final String MAX_HP_CHANGE_TEXTFIELD_TEXT = "Max HP change amount";
    public static final double MAX_HP_CHANGE_TEXTFIELD_START_X = TEXTS_OF_TEXTFIELDS_START_X;
    public static final double MAX_HP_CHANGE_TEXTFIELD_START_Y = NAME_TEXTFIELD_START_Y + TEXT_FIELDS_Y_DISTANCE;
    public static final double MAX_HP_CHANGE_TEXTFIELD_X = TEXTFIELDS_X;
    public static final double MAX_HP_CHANGE_TEXTFIELD_Y = TEXTFIELDS_Y;
    public static final String MAX_HP_CHANGE_TEXT_TEXT = "enter Max Hp change amount:";
    public static final double MAX_HP_CHANGE_TEXT_START_X = TEXTS_X;
    public static final double MAX_HP_CHANGE_TEXT_START_Y = MAX_HP_CHANGE_TEXTFIELD_START_Y;
    public static final double MAX_HP_CHANGE_TEXT_X = 0;
    public static final double MAX_HP_CHANGE_TEXT_Y = 0;

    public static final String PRICE_TEXTFIELD_TEXT = "Max HP change amount";
    public static final double PRICE_TEXTFIELD_START_X = TEXTS_OF_TEXTFIELDS_START_X;
    public static final double PRICE_TEXTFIELD_START_Y = NAME_TEXTFIELD_START_Y + 3* TEXT_FIELDS_Y_DISTANCE;
    public static final double PRICE_TEXTFIELD_X = TEXTFIELDS_X;
    public static final double PRICE_TEXTFIELD_Y = TEXTFIELDS_Y;
    public static final String PRICE_TEXT_TEXT = "enter Max Hp change amount:";
    public static final double PRICE_TEXT_START_X = TEXTS_X;
    public static final double PRICE_TEXT_START_Y = PRICE_TEXTFIELD_START_Y;
    public static final double PRICE_TEXT_X = 0;
    public static final double PRICE_TEXT_Y = 0;

    public static final String MAX_MP_CHANGE_TEXTFIELD_TEXT = "Max MP change amount";
    public static final double MAX_MP_CHANGE_TEXTFIELD_START_X = TEXTS_OF_TEXTFIELDS_START_X;
    public static final double MAX_MP_CHANGE_TEXTFIELD_START_Y = NAME_TEXTFIELD_START_Y + 2* TEXT_FIELDS_Y_DISTANCE;
    public static final double MAX_MP_CHANGE_TEXTFIELD_X = TEXTFIELDS_X;
    public static final double MAX_MP_CHANGE_TEXTFIELD_Y = TEXTFIELDS_Y;
    public static final String MAX_MP_CHANGE_TEXT_TEXT = "enter Max Mp change amount:";
    public static final double MAX_MP_CHANGE_TEXT_START_X = TEXTS_X;
    public static final double MAX_MP_CHANGE_TEXT_START_Y = MAX_MP_CHANGE_TEXTFIELD_START_Y;
    public static final double MAX_MP_CHANGE_TEXT_X = 0;
    public static final double MAX_MP_CHANGE_TEXT_Y = 0;

    public static final double BACK_BUTTON_START_X = DEFAULT_BACK_BUTTON_START_X;
    public static final double BACK_BUTTON_START_Y = DEFAULT_BACK_BUTTON_START_Y;
    public static final double BACK_BUTTON_X = DEFAULT_BACK_BUTTON_X;
    public static final double BACK_BUTTON_Y = DEFAULT_BACK_BUTTON_Y;
    public static final Image BACK_BUTTON_IMAGE = DEFAULT_BACK_BUTTON_IMAGE;

    public static final double SAVE_BUTTON_START_X = 500;
    public static final double SAVE_BUTTON_START_Y = 600;
    public static final double SAVE_BUTTON_X = 100;
    public static final double SAVE_BUTTON_Y = 50;
    public static final Image SAVE_BUTTON_IMAGE = null;
    public static final String SAVE_BUTTON_Text = "SAVE";


    public static final double CREATE_BUTTON_START_X = 400;
    public static final double CREATE_BUTTON_START_Y = 500;
    public static final double CREATE_BUTTON_X = 30;
    public static final double CREATE_BUTTON_Y = 30;
    public static final String CREATE_BUTTON_TEXT = "Create";
    public static final Font CREATE_BUTTON_FONT = DEFAULT_FONT;
}
