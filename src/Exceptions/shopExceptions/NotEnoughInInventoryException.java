package exceptions.shopExceptions;

import Cards.Component;

public class NotEnoughInInventoryException extends ShopException {
    public NotEnoughInInventoryException(Component component){
        super("Not enough " + component.getName() + "s in inventory");
    }
}
