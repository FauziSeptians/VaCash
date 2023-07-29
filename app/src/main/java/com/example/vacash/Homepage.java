package com.example.vacash;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.View;

import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import java.io.Console;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Homepage extends AppCompatActivity {


    int [] images = {
            R.drawable.imageiklan1,
            R.drawable.imageiklan3,
            R.drawable.imageiklan4,
            R.drawable.imageiklan5,
    };

    private ImageSwitcher imageSwitcher;
    private int currentIndex = 0;
    private final long delayTime = 1000;
    private int ToggleConsole = 0;
    protected int TogglePC = 0;
    protected int ToggleMobile = 1;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);


        // direct dari hamburger menu ke item yang ada di homepage
        Button MobileBottom = findViewById(R.id.mobile);
        Button Consolebutton = findViewById(R.id.console);
        Button PCbutton = findViewById(R.id.Pc);
        Intent intent = getIntent();
        String massage = intent.getStringExtra("keyItem");


        if(massage != null){
            if(intent.getStringExtra("keyItem").equals("mobile")){
                ToggleConsole = 0;
                ToggleMobile = 1;
                TogglePC = 0;


                if(ToggleMobile == 1){
                    MobileBottom.setBackgroundResource(R.drawable.clickedbutton);
                    MobileBottom.setTextColor(Color.BLACK);
                }
                Consolebutton.setBackgroundResource(R.drawable.borderbutton);
                Consolebutton.setTextColor(Color.WHITE);
                PCbutton.setBackgroundResource(R.drawable.borderbutton);
                PCbutton.setTextColor(Color.WHITE);
                replaceFragment(new GameMobileFragment()
                );
            }else if(intent.getStringExtra("keyItem").equals("console")){
                ToggleConsole = 1;
                ToggleMobile = 0;
                TogglePC = 0;


                if(ToggleConsole == 1){
                    Consolebutton.setBackgroundResource(R.drawable.clickedbutton);
                    Consolebutton.setTextColor(Color.BLACK);
                }
                PCbutton.setBackgroundResource(R.drawable.borderbutton);
                PCbutton.setTextColor(Color.WHITE);
                MobileBottom.setBackgroundResource(R.drawable.borderbutton);
                MobileBottom.setTextColor(Color.WHITE);
                replaceFragment(new GameConsoleFragment());
            }else{
                PCbutton.setBackgroundResource(R.drawable.clickedbutton);
                PCbutton.setTextColor(Color.BLACK);
                Consolebutton.setBackgroundResource(R.drawable.borderbutton);
                Consolebutton.setTextColor(Color.WHITE);
                MobileBottom.setBackgroundResource(R.drawable.borderbutton);
                MobileBottom.setTextColor(Color.WHITE);
                replaceFragment(new GamePCFragment());
            }

        }

        if( ToggleMobile == 1 && (massage == null)){
            MobileBottom.setBackgroundResource(R.drawable.clickedbutton);
            MobileBottom.setTextColor(Color.BLACK);
            Fragment fg = new GameMobileFragment();
            replaceFragment(fg);
        }




        LocalTime CurrentTime = LocalTime.now();

        TextView ClockIndicator = findViewById(R.id.clock);
        // VALIDASI JAM

        LocalTime startTimeMoring = LocalTime.of(0, 0);
        LocalTime endTimeMoring = LocalTime.of(10, 59);
        LocalTime startTimeSiang = LocalTime.of(11, 0);
        LocalTime endTimeSiang = LocalTime.of(15, 0);
        LocalTime startTimeSore = LocalTime.of(15, 0);
        LocalTime endTimeSore = LocalTime.of(18, 0);
        LocalTime startTimeNight = LocalTime.of(18, 0);
        LocalTime endTimeNight = LocalTime.of(23, 59);

        if(CurrentTime.isAfter(startTimeMoring) && CurrentTime.isBefore(endTimeMoring)){
            ClockIndicator.setText("Good Morning");
        }else if(CurrentTime.isAfter(startTimeSiang) && CurrentTime.isBefore(endTimeSiang)){
            ClockIndicator.setText("Good Afternoon");
        }else if(CurrentTime.isAfter(startTimeSore) && CurrentTime.isBefore(endTimeSore)){
            ClockIndicator.setText("Good Noon");
        }else{
            ClockIndicator.setText("Good Night");
        }











        View mobile = getLayoutInflater().inflate(R.layout.fragment_game_mobile, null);

        // CLIKCED BUTTON
        MobileBottom.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                ToggleConsole = 0;
                ToggleMobile = 1;
                TogglePC = 0;


                if(ToggleMobile == 1){
                    MobileBottom.setBackgroundResource(R.drawable.clickedbutton);
                    MobileBottom.setTextColor(Color.BLACK);
                }
                Consolebutton.setBackgroundResource(R.drawable.borderbutton);
                Consolebutton.setTextColor(Color.WHITE);
                PCbutton.setBackgroundResource(R.drawable.borderbutton);
                PCbutton.setTextColor(Color.WHITE);
                replaceFragment(new GameMobileFragment()
                );
            }
        });


        Consolebutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                ToggleConsole = 1;
                ToggleMobile = 0;
                TogglePC = 0;


                if(ToggleConsole == 1){
                    Consolebutton.setBackgroundResource(R.drawable.clickedbutton);
                    Consolebutton.setTextColor(Color.BLACK);
                }
                PCbutton.setBackgroundResource(R.drawable.borderbutton);
                PCbutton.setTextColor(Color.WHITE);
                MobileBottom.setBackgroundResource(R.drawable.borderbutton);
                MobileBottom.setTextColor(Color.WHITE);
                replaceFragment(new GameConsoleFragment()
                );
            }
        });




        PCbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                ToggleConsole = 0;
                ToggleMobile = 0;
                TogglePC = 1;


                if(TogglePC == 1){
                    PCbutton.setBackgroundResource(R.drawable.clickedbutton);
                    PCbutton.setTextColor(Color.BLACK);
                }
                Consolebutton.setBackgroundResource(R.drawable.borderbutton);
                Consolebutton.setTextColor(Color.WHITE);
                MobileBottom.setBackgroundResource(R.drawable.borderbutton);
                MobileBottom.setTextColor(Color.WHITE);
                replaceFragment(new GamePCFragment());
            }
        });


        imageSwitcher = findViewById(R.id.imageSwitcher);

        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                return new ImageView(Homepage.this);
            }
        });

        // Start the slideshow
        startSlideshow();

        // HamburgerMenu
        ImageButton buttonImage = findViewById(R.id.HamburgerButton);

        buttonImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHamburgerMenu(new MenuHamburgerFragment());
            }
        });

    }

    private void startSlideshow() {
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            public void run() {
                imageSwitcher.setBackgroundResource(images[currentIndex]);
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

    private void openHamburgerMenu(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.HamburgerFrame, fragment);
        fragmentTransaction.commit();
    }






}