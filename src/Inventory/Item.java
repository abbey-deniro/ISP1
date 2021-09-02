package Inventory;

import java.io.Serializable;
import java.text.NumberFormat;

public class Item implements Serializable {
    String name;
    String category;
    int quantity;
    float price;
    int minNumber;

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public int getMinNumber() {
        return minNumber;
    }

    public void setMinNumber(int minNumber) {
        this.minNumber = minNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Item(String name, int quantity, float price,int minNumber, String category) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.category = category;
        this.minNumber = minNumber;
    }
    public Item(){}

    @Override
    public String toString(){
        return this.name + ": " + NumberFormat.getCurrencyInstance().format(this.price) + " Quantity: " + this.quantity;
    }
}
