package View.scenes.CustomGame;

import View.scenes.Scene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import static data.constants.scenes.AddMonsterCard.*;

public class AddMonsterCard extends Scene {
    TextField apTextField = null;
    TextField mpTextField = null;
    TextField hpTextField = null;
    TextField priceTextField = null;
    public AddMonsterCard(){
        super();
        setFill(BACKGROUND);
        addSwitchToAddSpellCardButton();
        addTitle(TITLE,TITILE_START_X,TITILE_START_Y,TITLE_FONT);
        addPhylumButtonsAndText();
        addMpTextField();
        addPriceTextField();
        addHpTextField();
        addApTextField();
        addChooseCartType();
        addChooseSpell();
        addCreateButton();
        addBackButton();
    }

    public void addBackButton() {

    }//todo
    private void addCreateButton() {

    }//todo
    private void addChooseSpell() {
    }//todo
    private void addChooseCartType() {

    }//todo
    private void addApTextField() {
        add(createTextFiled(AP_TEXT_TEXT,AP_TEXT_START_X,AP_TEXT_START_Y,AP_TEXT_X,AP_TEXT_Y));
        apTextField = createTextFiled(AP_TEXTFIELD_TEXT,AP_TEXTFIELD_START_X,AP_TEXTFIELD_START_Y,AP_TEXTFIELD_X,AP_TEXTFIELD_Y);
        add(apTextField);
    }
    private void addHpTextField() {
        add(createTextFiled(HP_TEXT_TEXT,HP_TEXT_START_X,HP_TEXT_START_Y,HP_TEXT_X,HP_TEXT_Y));
        hpTextField = createTextFiled(HP_TEXTFIELD_TEXT,HP_TEXTFIELD_START_X,HP_TEXTFIELD_START_Y,HP_TEXTFIELD_X,HP_TEXTFIELD_Y);
        add(hpTextField);
    }
    private void addPriceTextField() {
        add(createTextFiled(PRICE_TEXT_TEXT,PRICE_TEXT_START_X,PRICE_TEXT_START_Y,PRICE_TEXT_X,PRICE_TEXT_Y));
        priceTextField = createTextFiled(PRICE_TEXTFIELD_TEXT,PRICE_TEXTFIELD_START_X,PRICE_TEXTFIELD_START_Y,PRICE_TEXTFIELD_X,PRICE_TEXTFIELD_Y);
        add(priceTextField);
    }
    private void addMpTextField() {
        add(createTextFiled(MP_TEXT_TEXT,MP_TEXT_START_X,MP_TEXT_START_Y,MP_TEXT_X,MP_TEXT_Y));
        mpTextField = createTextFiled(MP_TEXTFIELD_TEXT,MP_TEXTFIELD_START_X,MP_TEXTFIELD_START_Y,MP_TEXTFIELD_X,MP_TEXTFIELD_Y);
        add(mpTextField);
    }
    private void addPhylumButtonsAndText() {

    }//todo
    private void addSwitchToAddSpellCardButton() {
        ToggleButton button = createButton(SWITCH_TO_ADD_SPELL_CARD_BUTTON_IMAGE,SWITCH_TO_ADD_SPELL_CARD_BUTTON_START_X,
                SWITCH_TO_ADD_SPELL_CARD_BUTTON_START_Y,SWITCH_TO_ADD_SPELL_CARD_BUTTON_X,SWITCH_TO_ADD_SPELL_CARD_BUTTON_Y);
        button.setOnAction(event -> {
            goToAddSpellCard();
        });
        add(button);
    }
    private void goToAddSpellCard() {
    }//todo
    @Override
    public void refresh(){
        //todo
    }
}
