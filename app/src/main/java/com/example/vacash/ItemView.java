package com.example.vacash;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemView extends RecyclerView.ViewHolder {

    ImageView imageItem;
    TextView nameItem, priceItem;

    public ItemView(@NonNull View itemView) {
        super(itemView);

        imageItem = itemView.findViewById(R.id.imageItem);
        nameItem = itemView.findViewById(R.id.nameItem);
        priceItem = itemView.findViewById(R.id.priceItem);
    }
}
