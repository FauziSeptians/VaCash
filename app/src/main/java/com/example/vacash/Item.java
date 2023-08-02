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

import com.codesgood.views.JustifiedTextView;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Item extends AppCompatActivity {




//    int gamesImage = Integer.parseInt(intent.getStringExtra("ImageGame"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView categoryGame;
        TextView namaToko;
        TextView ratingToko;
        TextView lokasiToko;
        JustifiedTextView desc;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.item);
        Intent intent = getIntent();
        CardItemGame gamesName = (CardItemGame) intent.getSerializableExtra("NameGame");
        Log.d(TAG, "onCreate: gameName" + gamesName.getGameName());
        List<ItemModel> items = new ArrayList<ItemModel>();

        categoryGame = findViewById(R.id.categoryGame);

        namaToko = findViewById(R.id.namaToko);
        ratingToko = findViewById(R.id.ratingToko);
        lokasiToko = findViewById(R.id.lokasiToko);
//        desc = findViewById(R.id.descGame);





        if(gamesName.getGameName().equals("Mobile Legends: Bang Bang")){
            categoryGame.setText("Mobile");
            namaToko.setText("KatanyaUjiSangatOke");
            ratingToko.setText("4.8");
            lokasiToko.setText("Jakarta");
            items.add(new ItemModel(R.drawable.icon_diamonds,"5 Diamonds", 1500, "Mobile Legend"));
            items.add(new ItemModel(R.drawable.icon_diamonds,"25 Diamonds", 8000, "Mobile Legend"));
            items.add(new ItemModel(R.drawable.icon_diamonds,"77 Diamonds", 23000, "Mobile Legend"));
            items.add(new ItemModel(R.drawable.icon_diamonds,"217 Diamonds", 65000, "Mobile Legend"));
            items.add(new ItemModel(R.drawable.icon_diamonds,"503 Diamonds", 150000, "Mobile Legend"));
        }else if(gamesName.getGameName().equals("Call of Duty: Mobile - Garena")){
            categoryGame.setText("Mobile");
            namaToko.setText("NandaWakwaw05");
            ratingToko.setText("4.6");
            lokasiToko.setText("Bogor");
            items.add(new ItemModel(R.drawable.icon_points,"31 COD Points", 5000, "COD"));
            items.add(new ItemModel(R.drawable.icon_points,"63 COD Points", 10000, "COD"));
            items.add(new ItemModel(R.drawable.icon_points,"128 COD Points", 20000, "COD"));
            items.add(new ItemModel(R.drawable.icon_points,"321 COD Points", 50000, "COD"));
            items.add(new ItemModel(R.drawable.icon_points,"645 COD Points", 100000, "COD"));
        }else if(gamesName.getGameName().equals("Free Fire")){
            categoryGame.setText("Mobile");
            namaToko.setText("KeziaPalingBuFera");
            ratingToko.setText("4.8");
            lokasiToko.setText("Bekasi");
            items.add(new ItemModel(R.drawable.icon_diamonds,"15 Diamonds", 1000, "Free Fire"));
            items.add(new ItemModel(R.drawable.icon_diamonds,"50 Diamonds", 8000, "Free Fire"));
            items.add(new ItemModel(R.drawable.icon_diamonds,"140 Diamonds", 20000, "Free Fire"));
            items.add(new ItemModel(R.drawable.icon_diamonds,"355 Diamonds", 50000, "Free Fire"));
            items.add(new ItemModel(R.drawable.icon_diamonds,"720 Diamonds", 100000, "Free Fire"));
        }else if(gamesName.getGameName().equals("Genshin Impact")){
            categoryGame.setText("Mobile");
            namaToko.setText("DisuruhMajuSamaBel");
            ratingToko.setText("4.9");
            lokasiToko.setText("Surabaya");
            items.add(new ItemModel(R.drawable.icon_crystal,"60 Genesis Crystal", 16000, "Genshin Impact"));
            items.add(new ItemModel(R.drawable.icon_crystal,"300+30 Genesis Crystal", 79000, "Genshin Impact"));
            items.add(new ItemModel(R.drawable.icon_crystal,"980+110 Genesis Crystal", 249000, "Genshin Impact"));
            items.add(new ItemModel(R.drawable.icon_crystal,"1,980+260 Genesis Crystal", 479000, "Genshin Impact"));
            items.add(new ItemModel(R.drawable.icon_crystal,"3,280+600 Genesis Crystal", 799000, "Genshin Impact"));
        }else if(gamesName.getGameName().equals("PUBG MOBILE")){
            categoryGame.setText("Mobile");
            namaToko.setText("FauziNgebutinFigma");
            ratingToko.setText("4.6");
            lokasiToko.setText("Depok");
            items.add(new ItemModel(R.drawable.icon_money,"35+1 UC", 7000, "PUBG MOBILE"));
            items.add(new ItemModel(R.drawable.icon_money,"50+2 UC", 10000, "PUBG MOBILE"));
            items.add(new ItemModel(R.drawable.icon_money,"70+3 UC", 14000, "PUBG MOBILE"));
            items.add(new ItemModel(R.drawable.icon_money,"125+6 UC", 25000, "PUBG MOBILE"));
            items.add(new ItemModel(R.drawable.icon_money,"250+13 UC", 50000, "PUBG MOBILE"));
        }else if(gamesName.getGameName().equals("Fortnite")) {
            categoryGame.setText("Console");
            namaToko.setText("KisahHatiSeorangPutu");
            ratingToko.setText("4.6");
            lokasiToko.setText("Bandung");
            items.add(new ItemModel(R.drawable.icon_coin, "Fortnite 1,000 V-Bucks", 147000, "Fortnite"));
            items.add(new ItemModel(R.drawable.icon_coin, "Fortnite 2,800 V-Bucks", 466000, "Fortnite"));
            items.add(new ItemModel(R.drawable.icon_coin, "Fortnite 5,000 V-Bucks", 638000, "Fortnite"));
            items.add(new ItemModel(R.drawable.icon_coin, "Fortnite 2,800+5,000 V-Bucks", 1154000, "Fortnite"));
            items.add(new ItemModel(R.drawable.icon_coin, "Fortnite 13,500 V-Bucks", 1529000, "Fortnite"));
        }else if(gamesName.getGameName().equals("Ragnarok Origin")) {
            categoryGame.setText("Console");
            namaToko.setText("AsmaraditaSenjaBulan");
            ratingToko.setText("4.9");
            lokasiToko.setText("Yogyakarta");
            items.add(new ItemModel(R.drawable.icon_nyan, "10 Nyan Berry", 4000, "Ragnarok Origin"));
            items.add(new ItemModel(R.drawable.icon_nyan, "40 Nyan Berry", 15000, "Ragnarok Origin"));
            items.add(new ItemModel(R.drawable.icon_nyan, "125 Nyan Berry", 46000, "Ragnarok Origin"));
            items.add(new ItemModel(R.drawable.icon_nyan, "210 Nyan Berry", 75000, "Ragnarok Origin"));
            items.add(new ItemModel(R.drawable.icon_nyan, "430 Nyan Berry", 151000, "Ragnarok Origin"));
        }else if(gamesName.getGameName().equals("Need For Speed: No Limits")) {
            categoryGame.setText("Console");
            namaToko.setText("MeyliaBermainDiMei");
            ratingToko.setText("4.7");
            lokasiToko.setText("Malang");
            items.add(new ItemModel(R.drawable.icon_gold, "25 Gold", 11000, "Need For Speed: No Limits"));
            items.add(new ItemModel(R.drawable.icon_gold, "75 Gold", 35000, "Need For Speed: No Limits"));
            items.add(new ItemModel(R.drawable.icon_gold, "125 Gold", 58000, "Need For Speed: No Limits"));
            items.add(new ItemModel(R.drawable.icon_gold, "250 Gold", 116000, "Need For Speed: No Limits"));
            items.add(new ItemModel(R.drawable.icon_gold, "625 Gold", 290000, "Need For Speed: No Limits"));
        }else if(gamesName.getGameName().equals("Apex Legends")){
            categoryGame.setText("Console");
            namaToko.setText("UjiMerenungdiBandung");
            ratingToko.setText("4.9");
            lokasiToko.setText("Pontianak");
            items.add(new ItemModel(R.drawable.icon_points,"1,000 Apex Coins", 162000, "Apex Legends"));
            items.add(new ItemModel(R.drawable.icon_points,"2,000 Apex Coins", 205000, "Apex Legends"));
            items.add(new ItemModel(R.drawable.icon_points,"4,000 Apex Coins", 556000, "Apex Legends"));
            items.add(new ItemModel(R.drawable.icon_points,"6,000 Apex Coins", 954000, "Apex Legends"));
            items.add(new ItemModel(R.drawable.icon_points,"10,000 Apex Coins", 1550000, "Apex Legends"));
        }else if(gamesName.getGameName().equals("Call of Duty: War Zone")){
            categoryGame.setText("Console");
            namaToko.setText("NandanoxAsoyAsoy");
            ratingToko.setText("5.0");
            lokasiToko.setText("Tangerang");
            items.add(new ItemModel(R.drawable.icon_points,"31 COD Points", 5000, "Call of Duty: War Zone"));
            items.add(new ItemModel(R.drawable.icon_points,"128 COD Points", 20000, "Call of Duty: War Zone"));
            items.add(new ItemModel(R.drawable.icon_points,"321 COD Points", 50000, "Call of Duty: War Zone"));
            items.add(new ItemModel(R.drawable.icon_points,"645 COD Points", 100000, "Call of Duty: War Zone"));
            items.add(new ItemModel(R.drawable.icon_points,"800 COD Points", 120000, "Call of Duty: War Zone"));
        }else if(gamesName.getGameName().equals("Black Desert Online")) {
            categoryGame.setText("PC");
            namaToko.setText("OktavionidalamOkto");
            ratingToko.setText("4.5");
            lokasiToko.setText("Solo");
            items.add(new ItemModel(R.drawable.icon_coin, "23 Acoin", 9700, "Black Desert Online"));
            items.add(new ItemModel(R.drawable.icon_coin, "46 Acoin", 19600, "Black Desert Online"));
            items.add(new ItemModel(R.drawable.icon_coin, "160 Acoin", 67000, "Black Desert Online"));
            items.add(new ItemModel(R.drawable.icon_coin, "320 Acoin", 135500, "Black Desert Online"));
            items.add(new ItemModel(R.drawable.icon_coin, "640 Acoin", 273500, "Black Desert Online"));
        }else if(gamesName.getGameName().equals("E-Football 2023")) {
            categoryGame.setText("PC");
            namaToko.setText("TacoBelEnakSekali");
            ratingToko.setText("4.7");
            lokasiToko.setText("Palembang");
            items.add(new ItemModel(R.drawable.icon_coin, "100 E-Football Coin", 16000, "E-Football 2023"));
            items.add(new ItemModel(R.drawable.icon_coin, "520 E-Football Coin", 75000, "E-Football 2023"));
            items.add(new ItemModel(R.drawable.icon_coin, "1,050 E-Football Coin", 159000, "E-Football 2023"));
            items.add(new ItemModel(R.drawable.icon_coin, "2,150 E-Football Coin", 129000, "E-Football 2023"));
            items.add(new ItemModel(R.drawable.icon_coin, "3,300 E-Football Coin", 479000, "E-Football 2023"));
        }else if(gamesName.getGameName().equals("Grand Theft Auto Five (GTA V)")) {
            categoryGame.setText("PC");
            namaToko.setText("UjiDiujikanBerhari");
            ratingToko.setText("4.6");
            lokasiToko.setText("Medan");
            items.add(new ItemModel(R.drawable.icon_item, "RSCC: $100,000", 46000, "Grand Theft Auto Five (GTA V)"));
            items.add(new ItemModel(R.drawable.icon_item, "TSCC: $200,000", 80000, "Grand Theft Auto Five (GTA V)"));
            items.add(new ItemModel(R.drawable.icon_item, "BSCC: $500,000", 155000, "Grand Theft Auto Five (GTA V)"));
            items.add(new ItemModel(R.drawable.icon_item, "WSCC: $1,250,000", 310000, "Grand Theft Auto Five (GTA V)"));
            items.add(new ItemModel(R.drawable.icon_item, "WaSCC: $3,500,000", 775000, "Grand Theft Auto Five (GTA V)"));
        }else if(gamesName.getGameName().equals("Valorant")){
            categoryGame.setText("PC");
            namaToko.setText("WidiartaTelahHadir");
            ratingToko.setText("4.5");
            lokasiToko.setText("Salatiga");
            items.add(new ItemModel(R.drawable.icon_points,"125 Valorant Points", 15000, "Valorant"));
            items.add(new ItemModel(R.drawable.icon_points,"420 Valorant Points", 50000, "Valorant"));
            items.add(new ItemModel(R.drawable.icon_points,"700 Valorant Points", 80000, "Valorant"));
            items.add(new ItemModel(R.drawable.icon_points,"1,375 Valorant Points", 150000, "Valorant"));
            items.add(new ItemModel(R.drawable.icon_points,"2,400 Valorant Points", 250000, "Valorant"));
        }else if(gamesName.getGameName().equals("Point Blank")){
            categoryGame.setText("PC");
            namaToko.setText("PohonKeluargaBCA");
            ratingToko.setText("5.0");
            lokasiToko.setText("Jakarta");
            items.add(new ItemModel(R.drawable.icon_points,"1,200 PB Cash", 10000, "Point Blank"));
            items.add(new ItemModel(R.drawable.icon_points,"2,400 PB Cash", 20000, "Point Blank"));
            items.add(new ItemModel(R.drawable.icon_points,"6,000 PB Cash", 50000, "Point Blank"));
            items.add(new ItemModel(R.drawable.icon_points,"12,000 PB Cash", 100000, "Point Blank"));
            items.add(new ItemModel(R.drawable.icon_points,"24,000 PB Cash", 200000, "Point Blank"));
        }

        TextView judulgame = findViewById(R.id.JudulGame);
        ImageView image = findViewById(R.id.imageGame);

        judulgame.setText(gamesName.getGameName());
        image.setBackgroundResource(gamesName.getImage());
        Log.d(TAG, "onCreate: " + gamesName.getImage());

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ItemAdapter(items, gamesName));
    }
}