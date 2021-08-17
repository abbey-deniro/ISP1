package Inventory.Main;

public class Item {
    String name;
    int Quantity;
    int price;
    int minNumber;
    int ItemNumber;

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
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Item(String name, int quantity, int price,int minNumber,int itemNumber) {
        if(quantity<minNumber){
            //turnBoxred
        }else{
            //boxisgreen
        }
        this.name = name;
        Quantity = quantity;
        this.price = price;
        this.ItemNumber = itemNumber;
    }
    public Item(){}
}
