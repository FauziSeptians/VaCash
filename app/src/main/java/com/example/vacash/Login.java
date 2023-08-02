package com.example.vacash;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class Login extends AppCompatActivity {

    EditText username;
    EditText password;
    TextView errorMsg;
    Button btnSignIn;

    UserModel user = new UserModel();




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        btnSignIn = findViewById(R.id.btnSignIn);
        errorMsg = findViewById(R.id.errorMsg);


        ArrayList<String> itemhistory = new ArrayList<String>();


        Log.d(TAG, "onCreate: "+ username);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.length() == 0){
                    errorMsg.setText("Please input your username");
                    errorMsg.setVisibility(View.VISIBLE);
                } else if (password.length() == 0) {
                    errorMsg.setText("Please input your password");
                    errorMsg.setVisibility(View.VISIBLE);
                } else if (username.length() < 8) {
                    errorMsg.setText("Username's length must be more than 8");
                    errorMsg.setVisibility(View.VISIBLE);
                } else if (password.length() < 8) {
                    errorMsg.setText("Password's length must be more than 8");
                    errorMsg.setVisibility(View.VISIBLE);
                } else{
                    // redirect
                    Intent i = new Intent(Login.this, Homepage.class);
                    Log.d(TAG, "usernamenyaapa" + username.getText().toString());
//                    UserModel User = new UserModel(username.getText().toString(),"password",20,itemhistory);
                    user.Name = username.getText().toString();

                    i.putExtra("userdata",user );
                    startActivity(i);
                }
            }
        });
    }
}