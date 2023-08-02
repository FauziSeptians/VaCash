package com.example.vacash;

import java.io.Serializable;

public class TransactionTopUp implements Serializable {
    String GameNama;
    String ItemGame;
    int PriceGame;


    public TransactionTopUp(String gameNama, String itemGame, int priceGame) {
        GameNama = gameNama;
        ItemGame = itemGame;
        PriceGame = priceGame;
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
}
