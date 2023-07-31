package com.example.vacash;
import static android.content.ContentValues.TAG;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
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



            holder.cardgame.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Get the context from the itemView
                    Context context = view.getContext();

                    Intent intent = new Intent(context, Item.class);
                    intent.putExtra("NameGame",listdata.get(position));
                    Log.d(TAG, "onClick: " + listdata.get(position));
                    intent.putExtra("ImageGame",listdata.get(position).getImage());
                    context.startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return listdata.size();
        }

        public static class HolderData extends RecyclerView.ViewHolder{

            TextView NamaGames;
            ImageView images;
            LinearLayout cardgame;

            public HolderData(@NonNull View itemView) {
                super(itemView);

                NamaGames = itemView.findViewById(R.id.namagames);
                images = itemView.findViewById(R.id.Imagegame);
                cardgame = itemView.findViewById(R.id.cardgame);
            }


        }
    }
