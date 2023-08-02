package com.example.vacash;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

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
        holder.GameName.setText(data.get(position).getName());
        holder.GamePrice.setText(data.get(position).getPrice());
        holder.GameQTY.setText(data.get(position).getQty());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView GameName, GamePrice, GameQTY;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            GameName = itemView.findViewById(R.id.GameNama);
            GamePrice = itemView.findViewById(R.id.PriceGame);
            GameQTY = itemView.findViewById(R.id.QuantityGame);

        }
    }
}
