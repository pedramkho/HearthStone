package exceptions.shopExceptions;

import Cards.Component;

public class IsNotTradable extends ShopException {
    public IsNotTradable(Component component){
        super(component.getName() + " is not tradable!");
    }
}
