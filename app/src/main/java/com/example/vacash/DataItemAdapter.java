package com.example.vacash;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class DataItemAdapter extends RecyclerView.Adapter<DataItemAdapter.MyViewHolder> {



    Context context;
    ArrayList<DataItemModel> data;

    public DataItemAdapter(Context context, ArrayList<DataItemModel> data){
        this.context = context;
        this.data = data;
    }


    @NonNull
    @Override
    public DataItemAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view  = inflater.inflate(R.layout.carditemhistory,parent, false);
        return new DataItemAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataItemAdapter.MyViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: " + data);
        holder.GameName.setText(UserModel.HistoryItem.get(position).getGameNama());
        holder.GamePrice.setText(UserModel.HistoryItem.get(position).getPriceGame());
        holder.GameQTY.setText(UserModel.HistoryItem.get(position).getQty());
        holder.image.setBackgroundResource(UserModel.HistoryItem.get(position).getImage());

        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the context from the itemView
                Context context = view.getContext();

                Intent intent = new Intent(context, Item.class);
                intent.putExtra("Item",UserModel.HistoryItem.get(position));
//                Log.d(TAG, "onClick: " + UserModel.HistoryItem.get(position));
//                intent.putExtra("ImageGame",UserModel.HistoryItem.get(position));
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView GameName, GamePrice, GameQTY;
        LinearLayout card;
        ImageView image;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            GameName = itemView.findViewById(R.id.GameNama);
            GamePrice = itemView.findViewById(R.id.PriceGame);
            GameQTY = itemView.findViewById(R.id.qtys);
            card = itemView.findViewById(R.id.card);
            image = itemView.findViewById(R.id.images);




        }
    }

    public static String formatCurrency(double amount, Locale locale) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(locale);
        symbols.setCurrencySymbol("IDR "); // Set the currency symbol to "Rp"
        symbols.setGroupingSeparator(',');
   /*     symbols.setDecimalSeparator(',');*/

        DecimalFormat currencyFormatter = (DecimalFormat) NumberFormat.getCurrencyInstance(locale);
        currencyFormatter.setDecimalFormatSymbols(symbols);

        return currencyFormatter.format(amount);
    }


}
