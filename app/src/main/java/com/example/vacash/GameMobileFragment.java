package com.example.vacash;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GameMobileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GameMobileFragment extends Fragment {

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    List<String> listData;
    GameAdapter data;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public GameMobileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GameMobileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GameMobileFragment newInstance(String param1, String param2) {
        GameMobileFragment fragment = new GameMobileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game_mobile, container, false);
        // Inflate the layout for this fragment
        recyclerView = view.findViewById(R.id.recyclerID2);
        listData = new ArrayList<>();


//        for(int i = 0; i < 10; i++){
//            listData.add("Data Ke" + i);
//        }

        List<CardItemGame> items =  new ArrayList<CardItemGame>();
        items.add(new CardItemGame("Mobile Legends: Bang Bang",R.drawable.ml));
        items.add(new CardItemGame("Call of Duty: Mobile - Garena",R.drawable.cod));
        items.add(new CardItemGame("Free Fire",R.drawable.freefire));
        items.add(new CardItemGame("PUBG MOBILE",R.drawable.pubg));
        items.add(new CardItemGame("Genshin Impact",R.drawable.genshin));

//        linearLayoutManager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(), 2));


        data = new GameAdapter(items);
        recyclerView.setAdapter(data);
        data.notifyDataSetChanged();

        return view;
    }
}