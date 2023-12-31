package com.example.vacash;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.time.LocalTime;

import android.widget.ScrollView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MenuHamburgerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MenuHamburgerFragment extends Fragment {

    private ScrollView scrollView;

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
    static MenuHamburgerFragment newInstance(String param1, String param2) {
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
        View viewConsole = inflater.inflate(R.layout.fragment_game_console, container, false);
        View viewMobile = inflater.inflate(R.layout.fragment_game_mobile, container, false);
        View viewPC = inflater.inflate(R.layout.fragment_game_p_c, container, false);
        View viewMain = inflater.inflate(R.layout.homepage,container,false);

        scrollView = viewMain.findViewById(R.id.scrollview);

        RecyclerView sc1 = viewConsole.findViewById(R.id.recyclerID2);
        RecyclerView sc2 = viewMobile.findViewById(R.id.recyclerID2);
        RecyclerView sc3 = viewPC.findViewById(R.id.recyclerID2);

        Log.d(TAG, "sc1 : " + sc1);

        sc2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true; // Jika isScrollEnabled false, touch event akan diintercept dan scroll akan dihentikan
            }
        });



        LinearLayout HomeButton = view.findViewById(R.id.HomeMenuButton);
        HomeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent intent = new Intent(view.getContext(), Homepage.class);
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
//                UserModel username = (UserModel) intent.getSerializableExtra("userdata");
//                Log.d(TAG, "onClick: " + username.getName());
                intent.putExtra("keyItem","mobile");
//                intent.putExtra("userdate",);
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

        sc1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true; // Disable scrolling
            }
        });

        sc2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true; // Disable scrolling
            }
        });

        sc3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;     // Disable scrolling
            }
        });







        return view;

    }

    private void closeFragment() {
        // Make sure the fragment is attached to a hosting activity or fragment
        if (isAdded() && getParentFragmentManager() != null) {
            scrollView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    return false; // Mematikan scroll saat Anda membuka fragment
                }
            });
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

