package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        // get intent from calling method
        Intent intent = getIntent();

        // get username from intent
        String username = intent.getExtras().getString("USERNAME");

        TextView textView = findViewById(R.id.txtWelcome);
        String welcomeMessage = "Welcome " + username + "!";

        // display welcome message
        textView.setText(welcomeMessage);
    }
}