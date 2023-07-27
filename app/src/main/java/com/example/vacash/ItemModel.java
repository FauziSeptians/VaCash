package com.example.vacash;

public class ItemModel {


    int image;
    String itemName;
    int price;

    public ItemModel(int image, String itemName, int price) {
        this.image = image;
        this.itemName = itemName;
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
