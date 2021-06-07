package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

public class SignUp extends AppCompatActivity {

    EditText username, password, retype_password, email, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        retype_password = findViewById(R.id.re_type_password);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);

        //if no error, go to the login activity
        if(error_check() == false){
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
        }


    }

    /*
    check if there is any from any of the textboxes in this activty
    if no error, proceed to login
     */
    private boolean error_check(){

        //check if any of the fields are empty
        if(username.getText().toString().isEmpty()){
            return true;
        }
        if(password.getText().toString().isEmpty()){
            return true;
        }
        if(retype_password.getText().toString().isEmpty()){
            return true;
        }
        if(email.getText().toString().isEmpty()){
            return true;
        }
        if(phone.getText().toString().isEmpty()){
            return true;
        }


        return false;
    }
}