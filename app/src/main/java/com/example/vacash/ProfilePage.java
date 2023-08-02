package com.example.vacash;

import static android.content.ContentValues.TAG;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Locale;


public class ProfilePage extends AppCompatActivity {

    ArrayList<DataItemModel> data = new ArrayList<>();
    Integer TotalAmountBalance = 0;
    String NamaPemilik = "Nanskuyy";
    String ID = "";
    Integer ExpensesPay = 20000;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profilepage);



//        RecyclerView recyclerView = findViewById(R.id.recyclerview1);
//
//        setup();

//        DataItemAdapter adapter = new DataItemAdapter(this,data);
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));\
        TextView Nama = findViewById(R.id.Nama);
        Nama.setText(NamaPemilik);
        TextView Id = findViewById(R.id.Id);
        Random random = new Random();
        int Intid = random.nextInt(100);
        Id.setText("NS"+Integer.toString(Intid));

        // MOST EXPENSES TAB
        TextView MostExpenses = findViewById(R.id.MostExpenses);
        MostExpenses.setText(formatCurrency(ExpensesPay,new Locale("id", "ID")));


        Button popupbutton = findViewById(R.id.buttontopup);
        TextView textView = findViewById(R.id.AmountBalance);
        textView.setText((formatCurrency(TotalAmountBalance,new Locale("id", "ID"))));

        popupbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Dialog customDialog = new Dialog(ProfilePage.this);
                customDialog.setContentView(R.layout.customdialog);

                customDialog.show();
                Button topup = customDialog.findViewById(R.id.SumbitButtonTopup);
                topup.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v) {
                        EditText InputValueTopup = customDialog.findViewById(R.id.inputvalue);

                        Log.d(TAG, "InputValueTopup :" + InputValueTopup.getText().toString());
                        if(InputValueTopup.getText().toString().isEmpty()){
                            Log.d(TAG, "InputValueTopup1 :" + InputValueTopup.getText().toString());
                            TextView Eror = customDialog.findViewById(R.id.erormassage);
                            Log.d(TAG, "InputValueTopup1 :" + Eror);

                            Eror.setText("Please Input Value");



                        }else{
                            Integer IntInput = Integer.parseInt(InputValueTopup.getText().toString());

                            TotalAmountBalance = Integer.parseInt(InputValueTopup.getText().toString()) + TotalAmountBalance;
                            textView.setText((formatCurrency(TotalAmountBalance,new Locale("id", "ID"))));
                            if(ExpensesPay < IntInput) {
                                ExpensesPay = IntInput;
                                MostExpenses.setText(formatCurrency(ExpensesPay,new Locale("id", "ID")));
                            }
                            customDialog.dismiss();
                        }
//        }
//                        customDialog.dismiss();

                    }
                });
            }
        });

        ImageButton buttonImage = findViewById(R.id.HamburgerButton);

        buttonImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHamburgerMenu(new GameMobileFragment());
            }
        });

        List<TransactionTopUp> HistoryItem =  new ArrayList<TransactionTopUp>();
        HistoryItem.add(new TransactionTopUp("Fortnite","V-bucks",10000));
        HistoryItem.add(new TransactionTopUp("Valorant","R-radiant",20000));
        RecyclerView recyclerView;
        recyclerView = findViewById(R.id.historytopup);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setAdapter(new TransactionAdapter(HistoryItem));

    }

    public static String formatCurrency(double amount, Locale locale) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(locale);
        symbols.setCurrencySymbol("Rp "); // Set the currency symbol to "Rp"
        symbols.setGroupingSeparator('.');
        symbols.setDecimalSeparator(',');

        DecimalFormat currencyFormatter = (DecimalFormat) NumberFormat.getCurrencyInstance(locale);
        currencyFormatter.setDecimalFormatSymbols(symbols);

        return currencyFormatter.format(amount);
    }


    private void openHamburgerMenu(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.HamburgerFrame, fragment);
        fragmentTransaction.commit();
    }
}
