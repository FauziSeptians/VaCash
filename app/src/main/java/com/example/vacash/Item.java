package com.example.vacash;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Item extends AppCompatActivity {




//    int gamesImage = Integer.parseInt(intent.getStringExtra("ImageGame"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item);
        Intent intent = getIntent();
        CardItemGame gamesName = (CardItemGame) intent.getSerializableExtra("NameGame");
        Log.d(TAG, "onCreate: gameName" + gamesName.getGameName());

        List<ItemModel> items = new ArrayList<ItemModel>();
        items.add(new ItemModel(R.drawable.icon_diamonds,"10 Diamonds", 1500));
        items.add(new ItemModel(R.drawable.icon_diamonds,"15 Diamonds", 2500));

        TextView judulgame = findViewById(R.id.JudulGame);
        ImageView image = findViewById(R.id.imageGame);

        judulgame.setText(gamesName.getGameName());
        image.setBackgroundResource(gamesName.getImage());
        Log.d(TAG, "onCreate: " + gamesName.getImage());





        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ItemAdapter(items));
    }
}