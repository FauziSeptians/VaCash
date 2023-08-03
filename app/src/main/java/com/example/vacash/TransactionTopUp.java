package com.example.vacash;

import java.io.Serializable;

public class TransactionTopUp implements Serializable {
    String GameNama;
    String ItemGame;
    int PriceGame;
    int qty = 0;
    int image;


    public TransactionTopUp(String gameNama, String itemGame, int priceGame, int qty, int image) {
        GameNama = gameNama;
        ItemGame = itemGame;
        PriceGame = priceGame;
        this.qty = qty;
        this.image = image;
    }

    public String getGameNama() {
        return GameNama;
    }

    public void setGameNama(String gameNama) {
        GameNama = gameNama;
    }

    public String getItemGame() {
        return ItemGame;
    }

    public void setItemGame(String itemGame) {
        ItemGame = itemGame;
    }

    public int getPriceGame() {
        return PriceGame;
    }

    public void setPriceGame(int priceGame) {
        PriceGame = priceGame;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
