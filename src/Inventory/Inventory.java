package Inventory;

import java.io.*;
import java.util.ArrayList;

public class Inventory extends Item implements Serializable {

    private ArrayList<Item> items = new ArrayList<Item>();


    public void addItems(String name, int quantity, float price, int minNumber, int itemNumber, String category) {
        items.add(new Item(name,quantity,price,minNumber,itemNumber, category));
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
    public ArrayList<Item> getItems() {
        return items;
    }

    public void write() {
        System.out.println(items);
        try {
            FileOutputStream fos = new FileOutputStream("Inventory.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
//            for (T w : t){
//                System.out.println(w.toString());
//            }
            oos.writeObject(this.items);
            oos.close();
            fos.close();
        }
        catch(Exception e)
        {

        }
    }

    public void read() {
        try {
            FileInputStream fis = new FileInputStream("Inventory.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);

            this.items = (ArrayList<Item>) ois.readObject();
            //System.out.println(t.toString());
            ois.close();
            fis.close();
        }
        catch (Exception e) {
        }

//        for (T T : this.t) {
//            System.out.println(T.toString());
//        }
    }
}
