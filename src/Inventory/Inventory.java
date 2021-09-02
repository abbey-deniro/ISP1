package Inventory;

import java.io.*;
import java.util.ArrayList;

public class Inventory extends Item implements Serializable {

    ArrayList<Item> items = new ArrayList<Item>();


    public void addItems(String name, int quantity, float price, int minNumber,  String category) {
        items.add(new Item(name,quantity,price,minNumber, category));
    }

    public void write() {
        try {
            FileOutputStream fos = new FileOutputStream("Inventory.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

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

            ois.close();
            fis.close();
        }
        catch (Exception e) {
        }
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}
