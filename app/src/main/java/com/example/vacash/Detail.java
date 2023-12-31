package com.example.vacash;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

import org.w3c.dom.Text;

public class Detail extends AppCompatActivity {
    UserModel user = new UserModel();


    private Integer qty = 1;
    private Integer hargaItem;
    private TextView hargaItemTextView;
    private Integer totalHarga ;

    private void showAlertDialog(String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(Detail.this);
        builder.setTitle("Error").setMessage(message);

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void updateHargaItemTextView() {
        hargaItemTextView = findViewById(R.id.hargaItem);
        totalHarga = hargaItem * qty;
        String formattedHarga = formatCurrency(totalHarga, new Locale("id", "ID"));
        hargaItemTextView.setText(formattedHarga);
    }

    private String formatRupiah(double harga) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
        String formattedHarga = formatter.format(harga);
        return formattedHarga.replace("Rp", "Rp ");
    }

    public static String formatCurrency(Integer amount, Locale locale) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(locale);
        symbols.setCurrencySymbol("IDR "); // Set the currency symbol to "Rp"
        symbols.setGroupingSeparator(',');
        symbols.setDecimalSeparator('.');

        DecimalFormat currencyFormatter = (DecimalFormat) NumberFormat.getCurrencyInstance(locale);
        currencyFormatter.setDecimalFormatSymbols(symbols);

        return currencyFormatter.format(amount);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        AppCompatButton plusBtn = findViewById(R.id.plusBtn);
        AppCompatButton minBtn = findViewById(R.id.minBtn);
        TextView val = findViewById(R.id.qty);
        Button payBtn = findViewById(R.id.payBtn);
        TextView val2 = findViewById(R.id.qty2);

        Intent i = getIntent();

        String namaItem = i.getStringExtra("NameItem");
        String gameItem = i.getStringExtra("GameItem");
//        Log.d(TAG, "gameItem: " + namaItem);
        Integer priceItem = i.getExtras().getInt("PriceItem");
        Integer imageItem = i.getExtras().getInt("ImageItem");


        hargaItem = priceItem;
        totalHarga = hargaItem ;

        TextView namaItemtampil = findViewById(R.id.namaItem);
        TextView namaItemtampil2 = findViewById(R.id.namaItem2);
        TextView priceItemtampil = findViewById(R.id.priceItem);
        TextView priceItemtampil2 = findViewById(R.id.hargaItem);
        TextView desc = findViewById(R.id.descGame);
        ImageView itemGambar = findViewById(R.id.imageItem);
        TextView namaGame = findViewById(R.id.namaGame);

        namaItemtampil.setText(namaItem);
        namaItemtampil2.setText(namaItem);
        priceItemtampil.setText(formatCurrency(priceItem, new Locale("id", "ID")));
        priceItemtampil2.setText(formatCurrency(priceItem, new Locale("id", "ID")));
        itemGambar.setBackgroundResource(imageItem);
        namaGame.setText(gameItem);

        if (gameItem.equals("Mobile Legends")){
            desc.setText("Mobile Legends: Bang Bang is a mobile game with the multiplayer online battle arena (MOBA) genre. This game is developed and published by a company called Moonton. Diamonds are one of the in-game currencies that can be used to buy various game accessories, such as skins, etc");
        } else if (gameItem.equals("COD")) {
            desc.setText("Call of Duty: Mobile, commonly referred to as CODM, is a free-to-play first-person shooter (POP) video game developed by Timi Studio. COD Points are one of the in-game currencies that can be used to buy various game accessories");
        } else if (gameItem.equals("Free Fire")) {
            desc.setText("Free Fire, often abbreviated as FF, is a battle royale game developed by 111 Dots Studio and published by Garena for Android and iOS platforms. Diamonds are one of the in-game currencies that can be used to buy various game accessories, such as skins, etc");
        } else if (gameItem.equals("Genshin Impact")) {
            desc.setText("Genshin Impact is an MMORPG mobile game developed and published by the MiHoYo company. Genesis Crystal is one of the in-game currencies that can be used to buy various game accessories");
        } else if (gameItem.equals("PUBG MOBILE")) {
            desc.setText("PUBG Mobile is a free-to-play battle royale video game developed by LightSpeed & Quantum Studio, a division of Tencent Games. UC is one of the in-game currencies that can be used to buy various game accessories");
        } else if (gameItem.equals("Fortnite")) {
            desc.setText("Fortnite is a game developed by Epic Games. The game was released as a separate software package offering a variety of different game modes. V-bucks is one of the in-game currencies that can be used to buy various game accessories.");
        } else if (gameItem.equals("Ragnarok Origin")) {
            desc.setText("Ragnarok Origin is an MMORPG game that offers a variety of activities that involve you so that you are entertained and don't feel bored while playing it. Nyan Berry is one of the in-game currencies that can be used to buy various game accessories.");
        } else if (gameItem.equals("Need For Speed: No Limits")) {
            desc.setText("Need for Speed: No Limits is a racing game released in 2015. It was developed by Firemonkeys Studios and published by Electronic Arts. Gold is one of the in-game currencies that can be used to buy various game accessories");
        } else if (gameItem.equals("Apex Legends")) {
            desc.setText("Apex Legends is a free-to-play battle royale game developed by Respawn Entertainment and published by Electronic Arts. Apex Coins are one of the in-game currencies that can be used to buy various game accessories");
        } else if (gameItem.equals("Call of Duty: War Zone")) {
            desc.setText("Call of Duty Warzone is an online battle royale game announced by Raven Software and released by Activision. COD Points are one of the in-game currencies that can be used to buy various game accessories.");
        } else if (gameItem.equals("Black Desert Online")) {
            desc.setText("Black Desert Online is an MMORPG game developed by video game developer from Korea, Pearl Abyss. Acoin is one of the in-game currencies that can be used to buy various game accessories");
        } else if (gameItem.equals("E-Football 2023")) {
            desc.setText("eFootball is a soccer video game developed and published by Konami since 1995. E-Football coin is one of the in-game currencies that can be used to buy various game accessories.");
        } else if (gameItem.equals("Grand Theft Auto Five (GTA V)")) {
            desc.setText("Grand Theft Auto V (GTA 5) is a 2013 action-adventure game developed by Rockstar North and published by Rockstar Games.Card is one of the in-game currencies that can be used to buy various game accessories.");
        } else if (gameItem.equals("Valorant")) {
            desc.setText("Valorant is a free multiplayer tactical POP (first-person shooter) video game developed and published by Riot Games. Valorant points are one of the in-game currencies that can be used to purchase various game accessories");
        } else if (gameItem.equals("Point Blank")) {
            desc.setText("Point Blank is a fast-paced online first person shooter game, and has gameplay similar to Counter-Strike. Point Blank Cash is one of the in-game currencies that can be used to purchase various game accessories.");
        }




        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qty++;
                val.setText(Integer.toString(qty));
                val2.setText(Integer.toString(qty));
                updateHargaItemTextView();
            }

        });

        minBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (qty > 1) {
                    qty--;
                    val.setText(Integer.toString(qty));
                    val2.setText(Integer.toString(qty));
                    updateHargaItemTextView();
                }
            }

        });

        Dialog dialogVal = new Dialog(Detail.this);
        EditText usernameEdt = findViewById(R.id.usernameEdt);
        EditText emailEdt = findViewById(R.id.emailEdt);

        payBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String username = usernameEdt.getText().toString();
                String email = emailEdt.getText().toString();
                Log.d(TAG, "total dan balance" + totalHarga + user.Balance);

                if (username.isEmpty()) {
                    showAlertDialog("Username must be filled");
                } else if (email.isEmpty()) {
                    showAlertDialog("Email must be filled");
                } else if (!email.endsWith(".com")) {
                    showAlertDialog("E-mail must end with \".com\"");
                } else if (!email.contains("@")) {
                    showAlertDialog("E-mail must contain \"@\"");
                } else if (totalHarga > user.Balance) {
                    showAlertDialog("Total payment must be less than or equals to the user’s account balance");
                } else {
                    Context context = view.getContext();
                    Intent i = new Intent(context, ProfilePage.class);
                    i.putExtra("namaItem", namaItem);
                    i.putExtra("namaGame", gameItem);
                    i.putExtra("priceItem", priceItem );
                    i.putExtra("totalPrice", totalHarga );
                    i.putExtra("qty", qty);
                    user.Balance = user.Balance - totalHarga;

                    Log.d(TAG, "gamenya namanya:"+ gameItem);

                    if(gameItem.equals("Mobile Legend")){
                        user.HistoryItem.add(new TransactionTopUp(gameItem,namaItem,totalHarga,qty,R.drawable.ml));
                    }else if(gameItem.equals("COD")){
                        user.HistoryItem.add(new TransactionTopUp(gameItem,namaItem,totalHarga,qty,R.drawable.cod));
                    }else if(gameItem.equals("Free Fire")){
                        user.HistoryItem.add(new TransactionTopUp(gameItem,namaItem,totalHarga,qty,R.drawable.freefire));
                    }else if(gameItem.equals("PUBG MOBILE")){
                        user.HistoryItem.add(new TransactionTopUp(gameItem,namaItem,totalHarga,qty,R.drawable.pubg));
                    }else if(gameItem.equals("Genshin Impact")){
                        user.HistoryItem.add(new TransactionTopUp(gameItem,namaItem,totalHarga,qty,R.drawable.genshin));
                    }else if(gameItem.equals("Fortnite")){
                        user.HistoryItem.add(new TransactionTopUp(gameItem,namaItem,totalHarga,qty,R.drawable.fortnite));
                    }else if(gameItem.equals("Ragnarok Origin")){
                        user.HistoryItem.add(new TransactionTopUp(gameItem,namaItem,totalHarga,qty,R.drawable.ro));
                    }else if(gameItem.equals("Need For Speed: No Limits")){
                        user.HistoryItem.add(new TransactionTopUp(gameItem,namaItem,totalHarga,qty,R.drawable.nfs));
                    }else if(gameItem.equals("Apex Legends")){
                        user.HistoryItem.add(new TransactionTopUp(gameItem,namaItem,totalHarga,qty,R.drawable.apex));
                    }else if(gameItem.equals("Apex Legends")){
                        user.HistoryItem.add(new TransactionTopUp(gameItem,namaItem,totalHarga,qty,R.drawable.apex));
                    }else if(gameItem.equals("Call of Duty: War Zone")){
                        user.HistoryItem.add(new TransactionTopUp(gameItem,namaItem,totalHarga,qty,R.drawable.war));
                    }else if(gameItem.equals("Black Desert Online")){
                        user.HistoryItem.add(new TransactionTopUp(gameItem,namaItem,totalHarga,qty,R.drawable.bd));
                    }else if(gameItem.equals("E-Football 2023")){
                        user.HistoryItem.add(new TransactionTopUp(gameItem,namaItem,totalHarga,qty,R.drawable.pes));
                    }else if(gameItem.equals("Grand Theft Auto Five (GTA V)")){
                        user.HistoryItem.add(new TransactionTopUp(gameItem,namaItem,totalHarga,qty,R.drawable.gta));
                    }else if(gameItem.equals("Valorant")){
                        user.HistoryItem.add(new TransactionTopUp(gameItem,namaItem,totalHarga,qty,R.drawable.valo));
                    }else if(gameItem.equals("Point Blank")){
                        user.HistoryItem.add(new TransactionTopUp(gameItem,namaItem,totalHarga,qty,R.drawable.pb));
                    }

                    startActivity(i);
//                    Toast.makeText(Detail.this, "Succesfully submitted", Toast.LENGTH_SHORT).show();
                }

            }

        });

        ImageView backBtn = findViewById(R.id.backdetail);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Item.class);
                intent.putExtra("NameGame", getIntent().getSerializableExtra("game"));
                startActivity(intent);
            }
        });

        ImageButton buttonImage = findViewById(R.id.HamburgerButton);

        buttonImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHamburgerMenu(new MenuHamburgerFragment());
            }
        });







    }

    private void openHamburgerMenu(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.HamburgerFrame, fragment);
        fragmentTransaction.commit();
    }


}