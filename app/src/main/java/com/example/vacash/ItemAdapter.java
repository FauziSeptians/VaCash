package com.example.vacash;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemView>{

    Context context;
    List<ItemModel> items;

    public ItemAdapter(Context context, List<ItemModel> items) {
        this.context = context;
        this.items = items;
    }


    @NonNull
    @Override
    public ItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemView(LayoutInflater.from(context).inflate(R.layout.item_option,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemView holder, int position) {
        holder.nameItem.setText(items.get(position).getItemName());
        holder.priceItem.setText(items.get(position).getPrice());
        holder.imageItem.setImageResource(items.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
