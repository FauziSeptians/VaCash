package com.example.vacash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import org.w3c.dom.Text;

public class Detail extends AppCompatActivity {

    Integer qty = 1;
    private double hargaItem = 1500;
    private TextView hargaItemTextView;

    private void showAlertDialog(String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(Detail.this);
        builder.setTitle("Error").setMessage(message);

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void updateHargaItemTextView() {
        hargaItemTextView = findViewById(R.id.hargaItem);
        double totalHarga = hargaItem * qty;
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
                    Toast.makeText(Detail.this, "Succesfully submitted", Toast.LENGTH_SHORT).show();
                }

//                dialogVal.setContentView(R.layout.dialog_validation);
//                dialogVal.show();
            }

        });






    }

}