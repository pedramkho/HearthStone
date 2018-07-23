package exceptions.shopExceptions;

import Cards.Component;

public class NotEnoghInStock extends ShopException {
    public NotEnoghInStock(Component component){
        super("Not enough " + component.getName() +"s in shop");
    }
}
