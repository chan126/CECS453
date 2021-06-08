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

        Intent intent = getIntent();
        String username = intent.getStringExtra(Login.USERNAME);

        TextView textView = findViewById(R.id.txtWelcome);
        String welcomeMessage = "Welcome " + username + "!";
        textView.setText(welcomeMessage);
    }
}