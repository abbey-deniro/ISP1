package Inventory;

import java.io.Serializable;

public class Item implements Serializable {
    String name;
    String category;
    int quantity;
    float price;
    int minNumber;
    int ItemNumber;

    public String getCategory() {
        return category;
    }

    public int getItemNumber() {
        return ItemNumber;
    }

    public void setItemNumber(int itemNumber) {
        ItemNumber = itemNumber;
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
        quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Item(String name, int quantity, float price,int minNumber, String category) {
        if(quantity<minNumber){
            //turnBoxred
        }else{
            //boxisgreen
        }
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        //this.ItemNumber = itemNumber;
        this.category = category;
    }
    public Item(){}
}
