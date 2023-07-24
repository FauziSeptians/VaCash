package com.example.vacash;

public class CardItemGame {
    String GameName;
    int image;


    public CardItemGame(String gameName, int image) {
        GameName = gameName;
        this.image = image;
    }

    public String getGameName() {
        return GameName;
    }

    public int getImage() {
        return image;
    }

    public void setGameName(String gameName) {
        GameName = gameName;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
