package View.scenes.CustomGame;

import ItemsAndAmulets.Amulet;
import View.scenes.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.text.Text;

import static ItemsAndAmulets.Amulet.amulets;
import static ItemsAndAmulets.Amulet.createNewCustomAmulet;
import static View.Graphics.goToScene;
import static data.constants.scenes.EditAmulets.*;

public class EditAmulets extends Scene {
    private TextField name = null;
    private TextField maxHpChange = null;
    private TextField maxMpChange = null;
    private TextField price = null;
    private Amulet editingAmulet = null;

    public EditAmulets() {
        super();
        setFill(BACKGROUND);
        addTitle(TITLE,TITILE_START_X,TITILE_START_Y,TITLE_FONT);
        addNameTextField();
        addMaxHpChangeTextField();
        addMaxMpChangeTextField();
        addPriceTextFiled();
        addCreateButton();
        addBackButton();
    }

    private void addPriceTextFiled() {
        Text text = createText(PRICE_TEXT_TEXT, PRICE_TEXT_START_X, PRICE_TEXT_START_Y);
        price = createTextFiled(PRICE_TEXTFIELD_TEXT, PRICE_TEXTFIELD_START_X,
                PRICE_TEXTFIELD_START_Y, PRICE_TEXTFIELD_X,PRICE_TEXTFIELD_Y);
        if(editingAmulet!=null)
            price.setText(Integer.toString(editingAmulet.getPrice()));
        add(text);
        add(price);
    }

    public EditAmulets(String amuletName){
        this();
        for(Amulet amulet:Amulet.amulets)
            if(amulet.getName().equals(amuletName)){
                editingAmulet = amulet;
                break;
            }
        if(editingAmulet == null)
            System.out.println("Error");
    }

    public void addBackButton() {
        ToggleButton button = createButton(BACK_BUTTON_IMAGE,BACK_BUTTON_START_X,BACK_BUTTON_START_Y,BACK_BUTTON_X,BACK_BUTTON_Y);
        button.setOnAction(event -> goToScene(new EditGame()));
        add(button);
    }
    private void addCreateButton() {
        Button button = createButton(CREATE_BUTTON_TEXT,CREATE_BUTTON_START_X,CREATE_BUTTON_START_Y,CREATE_BUTTON_X,CREATE_BUTTON_Y,CREATE_BUTTON_FONT);
        button.setOnAction(event -> {
            if(areInputsValid()){
                if(editingAmulet != null){
                    editingAmulet.name = name.getText();
                    editingAmulet.maxMpChange = Integer.parseInt(maxMpChange.getText());
                    editingAmulet.maxHpChange = Integer.parseInt(maxHpChange.getText());
                    editingAmulet.setPrice(Integer.parseInt(price.getText()));
                }else
                    createNewCustomAmulet(name.getText(),Integer.parseInt(maxHpChange.getText()),Integer.parseInt(maxMpChange.getText()),Integer.parseInt(price.getText()));
                goToScene(new EditGame());
            }else{
                //todo
            }
        });
        add(button);
    }
    private void addMaxMpChangeTextField() {
        Text text = createText(MAX_MP_CHANGE_TEXT_TEXT, MAX_MP_CHANGE_TEXT_START_X, MAX_MP_CHANGE_TEXT_START_Y);
        maxMpChange = createTextFiled(MAX_MP_CHANGE_TEXTFIELD_TEXT, MAX_MP_CHANGE_TEXTFIELD_START_X,
                MAX_MP_CHANGE_TEXTFIELD_START_Y, MAX_MP_CHANGE_TEXTFIELD_X,MAX_MP_CHANGE_TEXTFIELD_Y);
        if(editingAmulet!=null)
            maxMpChange.setText(Integer.toString(editingAmulet.maxMpChange));
        add(text);
        add(maxMpChange);
    }
    private void addMaxHpChangeTextField() {
        Text text = createText(MAX_HP_CHANGE_TEXT_TEXT, MAX_HP_CHANGE_TEXT_START_X, MAX_HP_CHANGE_TEXT_START_Y);
        maxHpChange = createTextFiled(MAX_HP_CHANGE_TEXTFIELD_TEXT, MAX_HP_CHANGE_TEXTFIELD_START_X,
                MAX_HP_CHANGE_TEXTFIELD_START_Y, MAX_HP_CHANGE_TEXTFIELD_X,MAX_HP_CHANGE_TEXTFIELD_Y);
        if(editingAmulet!=null)
            maxHpChange.setText(Integer.toString(editingAmulet.maxHpChange));
        add(text);
        add(maxHpChange);
    }
    private void addNameTextField() {
        Text text = createText(NAME_TEXT_TEXT, NAME_TEXT_START_X, NAME_TEXT_START_Y);
        name = createTextFiled(NAME_TEXTFIELD_TEXT, NAME_TEXTFIELD_START_X, NAME_TEXTFIELD_START_Y, NAME_TEXTFIELD_X, NAME_TEXTFIELD_Y);
        if(editingAmulet!=null)
            name.setText(editingAmulet.name);
        add(text);
        add(name);
    }
    private boolean areInputsValid(){
        return isNameValid()&&isNumber(maxHpChange.getText())&&isNumber(maxMpChange.getText())&&isNumber(price.getText());
    }
    private boolean isNameValid(){
        if(editingAmulet!=null && name.getText().equals(editingAmulet.name))
            return true;
        for(Amulet amulet:amulets)
            if(amulet.getName().equals(name.getText()))
                return false;
        return true;
    }
    @Override
    public void refresh(){
        //todo
    }

}