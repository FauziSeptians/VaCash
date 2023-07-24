package com.example.vacash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewSwitcher;

import java.util.ArrayList;
import java.util.List;

public class MainActivity<test> extends AppCompatActivity {


    int [] images = {
            R.drawable.imageiklan1,
            R.drawable.imageiklan3,
            R.drawable.imageiklan4,
            R.drawable.imageiklan5,
    };

    private ImageSwitcher imageSwitcher;
    private int currentIndex = 0;
    private final long delayTime = 3000;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);

        View mobile = getLayoutInflater().inflate(R.layout.fragment_game_mobile, null);

        // DEFAULT KONTEN - FRAGMENT
        replaceFragment(new GameMobileFragment());

        Button MobileBottom = findViewById(R.id.mobile);
        MobileBottom.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                MobileBottom.setSelected(true);
                replaceFragment(new GameMobileFragment()
                );
            }
        });

        Button Consolebutton = findViewById(R.id.console);
        Consolebutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                replaceFragment(new GameConsoleFragment());
            }
        });


        Button PCbutton = findViewById(R.id.Pc);
        PCbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                replaceFragment(new GamePCFragment());
            }
        });


        imageSwitcher = findViewById(R.id.imageSwitcher);

        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                return new ImageView(MainActivity.this);
            }
        });

        // Start the slideshow
        startSlideshow();

        // recycle view

    }

    private void startSlideshow() {
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            public void run() {
                imageSwitcher.setImageResource(images[currentIndex]);
                currentIndex = (currentIndex + 1) % images.length;
                handler.postDelayed(this, delayTime);
            }
        };
        handler.postDelayed(runnable, delayTime);
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framelayoutID, fragment);
        fragmentTransaction.commit();
    }


}