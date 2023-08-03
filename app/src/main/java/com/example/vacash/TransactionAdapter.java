package com.example.vacash;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.util.Log;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;


public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.HolderData> {

    List<TransactionTopUp> transcation;

    public TransactionAdapter(List<TransactionTopUp> transcation) {
        this.transcation = transcation;
    }


    @NonNull
    @Override
    public TransactionAdapter.HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TransactionAdapter.HolderData(LayoutInflater.from(parent.getContext()).inflate(R.layout.carditemhistory, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionAdapter.HolderData holder, int position) {
        holder.GameNama.setText(transcation.get(position).getGameNama());
        holder.ItemGame.setText(transcation.get(position).getItemGame());
        holder.PriceGame.setText((formatCurrency(transcation.get(position).getPriceGame(),new Locale("id", "ID"))));
        holder.qty.setText("("+Integer.toString(transcation.get(position).getQty())+")");
        holder.images.setBackgroundResource(transcation.get(position).getImage());
        Log.d(TAG, "onBindViewHolder: " + transcation.get(position).getQty());

        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the context from the itemView
                Context context = view.getContext();

                Intent intent = new Intent(context, Item.class);
                intent.putExtra("NameGame",transcation.get(position));
                intent.putExtra("Item",UserModel.HistoryItem.get(position));
//                Log.d(TAG, "onClick: " + UserModel.HistoryItem.get(position));
//                intent.putExtra("ImageGame",UserModel.HistoryItem.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return transcation.size();
    }

    public static class HolderData extends RecyclerView.ViewHolder{

        TextView GameNama;
        TextView ItemGame;
        TextView PriceGame;
        TextView qty;
        ImageView images;
        LinearLayout card;


        public HolderData(@NonNull View itemView) {
            super(itemView);

            GameNama = itemView.findViewById(R.id.GameNama);
            ItemGame = itemView.findViewById(R.id.ItemGame);
            PriceGame = itemView.findViewById(R.id.PriceGame);
            qty = itemView.findViewById(R.id.qtys);
            images = itemView.findViewById(R.id.images);
            card = itemView.findViewById(R.id.card);

        }


    }

    public static String formatCurrency(double amount, Locale locale) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(locale);
        symbols.setCurrencySymbol("IDR "); // Set the currency symbol to "Rp"
        symbols.setGroupingSeparator('.');
        symbols.setDecimalSeparator(',');

        DecimalFormat currencyFormatter = (DecimalFormat) NumberFormat.getCurrencyInstance(locale);
        currencyFormatter.setDecimalFormatSymbols(symbols);

        return currencyFormatter.format(amount);
    }
}
