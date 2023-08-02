package com.example.vacash;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import org.w3c.dom.Text;

public class Detail extends AppCompatActivity {

    Integer qty = 1;
    private double hargaItem;
    private TextView hargaItemTextView;
    private double totalHarga;

    private void showAlertDialog(String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(Detail.this);
        builder.setTitle("Error").setMessage(message);

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void updateHargaItemTextView() {
        hargaItemTextView = findViewById(R.id.hargaItem);
        totalHarga = hargaItem * qty;
        String formattedHarga = formatRupiah(totalHarga);
        hargaItemTextView.setText(formattedHarga);
    }

    private String formatRupiah(double harga) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
        String formattedHarga = formatter.format(harga);
        return formattedHarga.replace("Rp", "Rp ");
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

        TextView namaItemtampil = findViewById(R.id.namaItem);
        TextView priceItemtampil = findViewById(R.id.priceItem);
        TextView priceItemtampil2 = findViewById(R.id.hargaItem);
        TextView desc = findViewById(R.id.descGame);
        ImageView itemGambar = findViewById(R.id.imageItem);

        namaItemtampil.setText(namaItem);
        priceItemtampil.setText(formatRupiah(priceItem));
        priceItemtampil2.setText(formatRupiah(priceItem));
        itemGambar.setBackgroundResource(imageItem);

        if (gameItem.equals("Mobile Legends")){
            desc.setText("Mobile Legends: Bang Bang is a mobile game with the multiplayer online battle arena (MOBA) genre. This game is developed and published by a company called Moonton. Diamonds are one of the in-game currencies that can be used to buy various game accessories, such as skins, etc");
        } else if (gameItem.equals("COD")) {
            desc.setText("Call of Duty: Mobile, commonly referred to as CODM, is a free-to-play first-person shooter (POP) video game developed by Timi Studio. COD Points are one of the in-game currencies that can be used to buy various game accessories");
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

                if (username.isEmpty()) {
                    showAlertDialog("Username must be filled");
                } else if (email.isEmpty()) {
                    showAlertDialog("Email must be filled");
                } else {
                    Context context = view.getContext();
                    Intent i = new Intent(context, ProfilePage.class);
                    i.putExtra("namaItem", namaItem);
                    i.putExtra("namaGame", gameItem);
                    i.putExtra("priceItem", priceItem );
                    i.putExtra("totalPrice", totalHarga );
                    i.putExtra("qty", qty);
                    startActivity(i);

                    UserModel.HistoryItem.add(new TransactionTopUp(gameItem,namaItem,priceItem));

                    Log.d(TAG, "History: " + UserModel.HistoryItem);
//                    Toast.makeText(Detail.this, "Succesfully submitted", Toast.LENGTH_SHORT).show();
                }

            }

        });

        ImageView backBtn = findViewById(R.id.backdetail);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });





    }

}