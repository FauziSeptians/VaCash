package com.example.vacash;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.BreakIterator;
import java.util.List;


public class GameAdapter  extends RecyclerView.Adapter<GameAdapter.HolderData> {

    List<CardItemGame> listdata;
    LayoutInflater inflater;
    Context context;
    public GameAdapter(List<CardItemGame> listdata) {
        this.listdata = listdata;
    }


    @NonNull
    @Override
    public GameAdapter.HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = inflater.inflate(R.layout.cardgame,parent, false);
        return new HolderData(LayoutInflater.from(parent.getContext()).inflate(R.layout.cardgame, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull GameAdapter.HolderData holder, int position) {
        holder.NamaGames.setText(listdata.get(position).getGameName());
        holder.images.setImageResource(listdata.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public static class HolderData extends RecyclerView.ViewHolder{

        TextView NamaGames;
        ImageView images;

        public HolderData(@NonNull View itemView) {
            super(itemView);

            NamaGames = itemView.findViewById(R.id.namagames);
            images = itemView.findViewById(R.id.Imagegame);
        }


    }
}
