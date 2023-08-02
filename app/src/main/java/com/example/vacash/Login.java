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

    EditText email;
    EditText password;
    TextView errorMsg;
    Button btnSignIn;
    TextView signUp;

    UserModel user = new UserModel();




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        btnSignIn = findViewById(R.id.btnSignIn);
        errorMsg = findViewById(R.id.errorMsg);
        signUp = findViewById(R.id.signup);


        ArrayList<String> itemhistory = new ArrayList<String>();


        Log.d(TAG, "onCreate: "+ email);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (email.length() == 0){
                        errorMsg.setText("Please input your e-mail");
                        errorMsg.setVisibility(View.VISIBLE);
                    } else if (password.length() == 0) {
                        errorMsg.setText("Please input your password");
                        errorMsg.setVisibility(View.VISIBLE);
                    } else if (!email.getText().toString().endsWith(".com")) {
                        errorMsg.setText("E-mail must end with \".com\"");
                        errorMsg.setVisibility(View.VISIBLE);
                    } else if (!email.getText().toString().contains("@")) {
                        errorMsg.setText("E-mail must contain \"@\"");
                        errorMsg.setVisibility(View.VISIBLE);
                    } else if (password.length() < 8) {
                        errorMsg.setText("Password's length must be more than 8");
                        errorMsg.setVisibility(View.VISIBLE);
                    } else{
                        // redirect
                    if(user.Email == null){
                        errorMsg.setText("Please Register First");
                        errorMsg.setVisibility(View.VISIBLE);
                    }else{
//
                        Log.d(TAG, "onClick1: " + email.getText().toString() + user.Email );
                        Log.d(TAG, "onClick2: " + password.getText().toString() + user.Password );

                        if(email.getText().toString().equals(user.Email) && password.getText().toString().equals(user.Password)){
                            Log.d(TAG, "onClick1: " + email.getText().toString() + user.Email );
                            Log.d(TAG, "onClick2: " + password.getText().toString() + user.Password );
                            Intent i = new Intent(Login.this, Homepage.class);

                            user.Email = email.getText().toString();

                            i.putExtra("userdata",user );
                            startActivity(i);
                        }else{
                            errorMsg.setText("Credentials are not match with our database");
                            errorMsg.setVisibility(View.VISIBLE);
                        }
                    }

                    }

            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Login.this, Register.class);
                startActivity(i);
            }
        });
    }
}