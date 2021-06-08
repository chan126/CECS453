package com.example.assignment1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    public static final String USERNAME = "com.example.assignment1.Login";
    private Button btnLogin;
    private Button btnSignUp;
    private EditText editTextUsername;
    private EditText editTextPassword;
    private String inputUsername;
    private String inputPassword;
    private Data data;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.login);
        btnSignUp = findViewById(R.id.signup);

        editTextUsername = findViewById(R.id.username);
        editTextPassword = findViewById(R.id.password);

        context = getApplicationContext();

        data = new Data();

        btnLogin.setOnClickListener(v -> {
            inputUsername = editTextUsername.getText().toString();
            inputPassword = editTextPassword.getText().toString();

            if (inputUsername.isEmpty() || inputPassword.isEmpty()) {
                Toast.makeText
                        (context, "Username and password fields cannot be empty", Toast.LENGTH_LONG).
                        show();

            } else if (data.checkCredentials(inputUsername, inputPassword)) {
                Intent intent = new Intent(context, Welcome.class);
                intent.putExtra("USERNAME", inputUsername);
                startActivity(intent);
            } else {
                Toast.makeText
                        (context, "Username and/or password invalid.\nTry again", Toast.LENGTH_LONG).
                        show();
            }
        });

        btnSignUp.setOnClickListener(v -> {
            Intent intent = new Intent(context, SignUp.class);
            startActivity(intent);
        });
    }
}