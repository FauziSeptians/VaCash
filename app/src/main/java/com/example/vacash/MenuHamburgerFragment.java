package com.example.vacash;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.time.LocalTime;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MenuHamburgerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MenuHamburgerFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MenuHamburgerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MenuHamburgerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MenuHamburgerFragment newInstance(String param1, String param2) {
        MenuHamburgerFragment fragment = new MenuHamburgerFragment();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu_hamburger, container, false);


        LinearLayout HomeButton = view.findViewById(R.id.HomeMenuButton);
        HomeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });


        ImageButton buttonimg = view.findViewById(R.id.CloseButton);
        buttonimg.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                closeFragment();
            }
        });

        LinearLayout dropdown = view.findViewById(R.id.AccountMenuButton);
        dropdown.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                openNestedFragment();
            }
        });

        Button button = view.findViewById(R.id.mobile);
        Button console = view.findViewById(R.id.console);
        Button pc = view.findViewById(R.id.Pc);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Homepage.class);
                intent.putExtra("keyItem","mobile");
                startActivity(intent);
            }
        });
        console.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),Homepage.class);
                intent.putExtra("keyItem","console");
                startActivity(intent);
            }
        });

        pc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Homepage.class);
                intent.putExtra("keyItem","pc");
                startActivity(intent);
            }
        });





        return view;

    }

    private void closeFragment() {
        // Make sure the fragment is attached to a hosting activity or fragment
        if (isAdded() && getParentFragmentManager() != null) {
            FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
            fragmentTransaction.remove(this); // 'this' refers to the current fragment
            fragmentTransaction.commit();
        }
    }

    private void openNestedFragment() {
        // Mendapatkan child FragmentManager untuk mengelola fragment di dalam fragment ini
        FragmentManager childFragmentManager = getChildFragmentManager();

        // Membuat instance fragment yang ingin ditampilkan (MyNestedFragment)
        accountragment myNestedFragment = new accountragment();

        // Melakukan transaksi fragment untuk menambahkan MyNestedFragment ke dalam hierarki fragment ini
        FragmentTransaction transaction = childFragmentManager.beginTransaction();
        transaction.replace(R.id.LayoutingAccount, myNestedFragment); // Menggantikan fragment saat ini di dalam container dengan MyNestedFragment
        transaction.addToBackStack(null); // Menambahkan transaksi ini ke dalam back stack, sehingga fragment bisa dikembalikan dengan tombol back
        transaction.commit();
    }

//    private void openProfileMenu(Fragment fragment){
//        FragmentManager fragmentManager = getChildFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.LayoutingAccount, fragment);
//        fragmentTransaction.commit();
//    }


}

