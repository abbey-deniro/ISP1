package Inventory;

import java.util.ArrayList;

public class Inventory extends Item {
    ArrayList<Item> items = new ArrayList<Item>();


    public void addItems(String name, int quantity, int price, int minNumber, int itemNumber) {
        items.add(new Item(name,quantity,price,minNumber,itemNumber));
    }

    public void removeItems(int itemNumber) {
        items.remove(itemNumber--);
    }

    public void editItems(String name, int quantity, int price, int minNumber, int itemNumber) {
        itemNumber--;
        items.get(itemNumber).setName(name);
        items.get(itemNumber).setQuantity(quantity);
        items.get(itemNumber).setPrice(price);
        items.get(itemNumber).setMinNumber(minNumber);

    }
}
