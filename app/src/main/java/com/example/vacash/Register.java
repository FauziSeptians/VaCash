package com.example.vacash;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Register extends AppCompatActivity {

    EditText name;
    EditText email;
    EditText password;
    EditText confPassword;
    TextView errorMsg;
    Button btnSignUp;
    TextView signIn;

    UserModel user = new UserModel();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = findViewById(R.id.name);
        email  =findViewById(R.id.email);
        password = findViewById(R.id.password);
        confPassword = findViewById(R.id.confPassword);
        errorMsg = findViewById(R.id.errorMsg);
        btnSignUp = findViewById(R.id.btnSignUp);
        signIn = findViewById(R.id.signIn);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (name.length() == 0){
                    errorMsg.setText("Please input your username");
                    errorMsg.setVisibility(View.VISIBLE);
                } else if (email.length() == 0) {
                    errorMsg.setText("Please input your e-mail");
                    errorMsg.setVisibility(View.VISIBLE);
                } else if (password.length() == 0) {
                    errorMsg.setText("Please input your password");
                    errorMsg.setVisibility(View.VISIBLE);
                } else if (confPassword.length() == 0) {
                    errorMsg.setText("Please confirm your password");
                    errorMsg.setVisibility(View.VISIBLE);
                } else if (name.length() < 8) {
                    errorMsg.setText("Name's length must be more than 8");
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
                } else if (!confPassword.getText().toString().equals(password.getText().toString())) {
                    errorMsg.setText("The password confirmation does not match");
                    errorMsg.setVisibility(View.VISIBLE);
                } else{
                    // redirect
                    Intent i = new Intent(Register.this, Login.class);
//                    i.putExtra("username", name.toString());
//                    i.putExtra("email",email.toString());
                    user.Name = name.getText().toString();
                    user.Password = password.getText().toString();
                    user.Email = email.getText().toString();

                    startActivity(i);
                }
            }
        });

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Register.this, Login.class);
                startActivity(i);
            }
        });
    }
}