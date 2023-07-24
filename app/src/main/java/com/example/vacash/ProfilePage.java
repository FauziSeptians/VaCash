package com.example.vacash;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.ArrayList;
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
                        Integer IntInput = Integer.parseInt(InputValueTopup.getText().toString());
                        TotalAmountBalance = Integer.parseInt(InputValueTopup.getText().toString()) + TotalAmountBalance;
                        textView.setText((formatCurrency(TotalAmountBalance,new Locale("id", "ID"))));
                        if(ExpensesPay < IntInput) {
                            ExpensesPay = IntInput;
                            MostExpenses.setText(formatCurrency(ExpensesPay,new Locale("id", "ID")));
                        }
//        }
                        customDialog.dismiss();

                    }
                });
            }
        });

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

    private void setup(){
        String[] DataNameGame = getResources().getStringArray(R.array.GameName);
        int[] QtyGame = getResources().getIntArray(R.array.QtyGame);
        int[] PriceGame = getResources().getIntArray(R.array.PriceGame);

//        int[] ImageGame = {R.drawable.cod};


        for(int i = 0; i < DataNameGame.length; i++){
            data.add(new DataItemModel(DataNameGame[i], QtyGame[i], PriceGame[i]));
        }

    }
}
