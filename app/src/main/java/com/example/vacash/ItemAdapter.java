package com.example.vacash;

import static android.content.ContentValues.TAG;

import static com.example.vacash.ItemAdapter.HolderData.formatCurrency;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.HolderData>{


    List<ItemModel> items;

    public ItemAdapter(List<ItemModel> items) {
        this.items = items;
    }


    @NonNull
    @Override
    public ItemAdapter.HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HolderData(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_option,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.HolderData holder, int position) {
        holder.nameItem.setText(items.get(position).getItemName());
        holder.imageItem.setImageResource(items.get(position).getImage());
        holder.priceItem.setText(formatCurrency(items.get(position).getPrice(),new Locale("id", "ID")));

        holder.keDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "wakwaw: " + 1);
                // Get the context from the itemView
                Context context = view.getContext();

                Intent intent = new Intent(context, Detail.class);
                intent.putExtra("NameItem",items.get(position).getItemName());
                intent.putExtra("GameItem",items.get(position).getNamaGame());
//                Log.d(TAG, "onClick: " + listdata.get(position));
                intent.putExtra("ImageItem",items.get(position).getImage());
                intent.putExtra("PriceItem",items.get(position).getPrice());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class HolderData extends RecyclerView.ViewHolder{

        TextView nameItem;
        TextView priceItem;
        ImageView imageItem;

        LinearLayout keDetail;


        public HolderData(@NonNull View itemView) {
            super(itemView);

            nameItem = itemView.findViewById(R.id.nameItem);
            priceItem = itemView.findViewById(R.id.priceItem);
            imageItem = itemView.findViewById(R.id.imageItem);

            keDetail = itemView.findViewById(R.id.keDetail);
        }

        public static String formatCurrency(double amount, Locale locale) {
            DecimalFormatSymbols symbols = new DecimalFormatSymbols(locale);
            symbols.setCurrencySymbol("IDR "); // Set the currency symbol to "Rp"
            symbols.setGroupingSeparator(',');
            symbols.setDecimalSeparator('.');

            DecimalFormat currencyFormatter = (DecimalFormat) NumberFormat.getCurrencyInstance(locale);
            currencyFormatter.setDecimalFormatSymbols(symbols);

            return currencyFormatter.format(amount);
        }


    }
}
