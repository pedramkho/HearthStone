package View.scenes;

import Cards.Component;
import javafx.scene.control.Button;

public class ComponentButton extends Button {
    public Component pointingComponent;
    public ComponentButton(Component pointingComponent){
        this.pointingComponent = pointingComponent;
    }
}
