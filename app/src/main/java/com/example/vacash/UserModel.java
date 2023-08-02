package com.example.vacash;

import java.io.Serializable;
import java.util.ArrayList;

public class UserModel implements Serializable {
    String Name;
    String Password;
    Integer MostTopUp;
    ArrayList<String> HistoryTopupGame;


    public UserModel(String name, String password, Integer mostTopUp, ArrayList<String> historyTopupGame) {
        Name = name;
        Password = password;
        MostTopUp = mostTopUp;
        HistoryTopupGame = historyTopupGame;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Integer getMostTopUp() {
        return MostTopUp;
    }

    public void setMostTopUp(Integer mostTopUp) {
        MostTopUp = mostTopUp;
    }

    public ArrayList<String> getHistoryTopupGame() {
        return HistoryTopupGame;
    }

    public void setHistoryTopupGame(ArrayList<String> historyTopupGame) {
        HistoryTopupGame = historyTopupGame;
    }
}
