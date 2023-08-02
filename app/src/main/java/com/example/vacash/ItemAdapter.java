package com.example.vacash;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
//        LayoutInflater.from(.getContext()).inflate(R.layout.item_option,parent,false)
        // Assuming 'inflater' is an instance of LayoutInflater and 'layoutResourceId' is the ID of the XML layout resource.
//        View view = inf.inflate(R.layout.item, parent, false);

        holder.nameItem.setText(items.get(position).getItemName());
        holder.imageItem.setImageResource(items.get(position).getImage());
        holder.priceItem.setText(Integer.toString(items.get(position).getPrice()));
//        view.namaToko.setText(items.get(position).getNamaToko());
//        holder.ratingToko.setText(items.get(position).getRatingToko());
//        holder.lokasiToko.setText(items.get(position).getLokasiToko());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class HolderData extends RecyclerView.ViewHolder{

        TextView nameItem;
        TextView priceItem;
        ImageView imageItem;



        public HolderData(@NonNull View itemView) {
            super(itemView);

            nameItem = itemView.findViewById(R.id.nameItem);
            priceItem = itemView.findViewById(R.id.priceItem);
            imageItem = itemView.findViewById(R.id.imageItem);

//            priceItem.setText(formatCurrency(priceItem));
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
}
