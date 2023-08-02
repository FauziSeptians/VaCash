package com.example.vacash;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserModel implements Serializable {
    static String Name;
    static String Password;
    static String Email;
    static Integer MostTopUp = 0;
    static Integer Balance = 0;

    ArrayList<ItemModel> HistoryItem = new ArrayList<>();

    HashMap<String, Integer> occurrencesMap = new HashMap<>();

//     HistoryItem.add(new TransactionTopUp("Fortnite","V-bucks",10000));
//     HistoryItem.add(new TransactionTopUp("Valorant","R-radiant",20000));




}
