package exceptions.inventoryExceptions;

import Inventory.Inventory;

public class DeckIsFull extends InventoryException {
    public DeckIsFull(){
        super("Deck is full");
    }
}
