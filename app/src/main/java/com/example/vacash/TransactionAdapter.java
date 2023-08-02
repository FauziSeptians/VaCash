package com.example.vacash;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.List;


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
        holder.PriceGame.setText(Integer.toString(transcation.get(position).getPriceGame()));
    }

    @Override
    public int getItemCount() {
        return transcation.size();
    }

    public static class HolderData extends RecyclerView.ViewHolder{

        TextView GameNama;
        TextView ItemGame;
        TextView PriceGame;


        public HolderData(@NonNull View itemView) {
            super(itemView);

            GameNama = itemView.findViewById(R.id.GameNama);
            ItemGame = itemView.findViewById(R.id.ItemGame);
            PriceGame = itemView.findViewById(R.id.PriceGame);
        }


    }
}
