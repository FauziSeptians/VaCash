package com.example.vacash;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link accountragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class accountragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public accountragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment accountragment.
     */
    // TODO: Rename and change types and number of parameters
    public static accountragment newInstance(String param1, String param2) {
        accountragment fragment = new accountragment();
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
        View view1 = inflater.inflate(R.layout.fragment_accountragment, container, false);

        View view2 = inflater.inflate(R.layout.fragment_menu_hamburger, container, false);

        TextView button = view2.findViewById(R.id.dropdownAccount);

        UserModel user = new UserModel();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button.setBackgroundResource(R.drawable.buttonatas);
                TextView item =  view2.findViewById(R.id.item);
                item.setText("hallo");
            }
        });

        Button profilebutton = view1.findViewById(R.id.Profile);

        profilebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),ProfilePage.class);
                startActivity(intent);
            }
        });

        Button logout = view1.findViewById(R.id.Logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),Login.class);
                user.Name = null;
                user.Password = null;
                user.Email = null;
                user.MostTopUp = 0;
                user.Balance = 0;
//                static String Name;
//                static String Password;
//                static String Email;
//                static Integer MostTopUp = 0;
//                static Integer Balance = 0;
//
//                static ArrayList<TransactionTopUp> HistoryItem = new ArrayList<>();
                startActivity(intent);

            }
        });



        return view1;
    }

    private void closeFragment() {
        // Make sure the fragment is attached to a hosting activity or fragment
        if (isAdded() && getParentFragmentManager() != null) {
            FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
            fragmentTransaction.remove(this); // 'this' refers to the current fragment
            fragmentTransaction.commit();
        }
    }
}