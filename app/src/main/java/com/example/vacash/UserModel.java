package com.example.vacash;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;

public class UserModel implements Serializable {
    static String Name;
    static String Password;
    static String Email;
    static Integer MostTopUp = 0;
    static Integer Balance = 0;
    static ArrayList<String> HistoryTopupGame;

}
