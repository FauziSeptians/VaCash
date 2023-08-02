package com.example.vacash;

import java.io.Serializable;

public class ItemModel implements Serializable {


    int image;
    String itemName;
    int price;

    String namaGame;

    public ItemModel(int image, String itemName, int price, String namaGame) {
        this.image = image;
        this.itemName = itemName;
        this.price = price;
        this.namaGame = namaGame;
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

    public String getNamaGame() {
        return namaGame;
    }

    public void setNamaGame(String namaGame) {
        this.namaGame = namaGame;
    }
}
