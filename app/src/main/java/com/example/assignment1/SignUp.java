package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
        Button sign_me_up = findViewById(R.id.sign_me_up);

        Data sign_user_up = new Data();



        sign_me_up.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                boolean validated = error_check();
                //if no error, go to the login activity
                if( validated == true){
                    sign_user_up.addCredential(username.getText().toString(), password.getText().toString());
                    Intent intent = new Intent(getApplicationContext(), Login.class);
                    startActivity(intent);
                } else{
                    Toast.makeText(getApplicationContext(), "Please check errors", Toast.LENGTH_LONG).show();
                }

            }
        });


    }

    /*
    check if there is any from any of the textboxes in this activty
    if no error, proceed to login
     */
    private boolean error_check(){

        boolean validate = true;

        if (email.getText().toString().isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher( email.getText().toString() ).matches()) {
            email.setError("enter a valid email address");
            validate = false;
        } else {
            email.setError(null);
        }

        if (password.getText().toString().isEmpty() || password.length() < 4 || password.length() > 14) {
            password.setError("between 4 and 14 alphanumeric characters");
            validate = false;
        } else {
            password.setError(null);
        }

        if(retype_password.getText().toString().isEmpty() ){
            validate = false;
        }

        if(retype_password.getText().toString() != password.getText().toString()){
            retype_password.setError("Password does not match");
        } else{
            retype_password.setError(null);
        }

        if(username.getText().toString().isEmpty()){
            username.setError("Please enter a user name");
            validate = false;
        }else{
            username.setError(null);
        }

        if(!android.util.Patterns.PHONE.matcher( phone.getText().toString() ).matches() || phone.getText().toString().isEmpty()){
            phone.setError("Please enter correct phone number");
        }else{
            phone.setError(null);
        }

        return validate;
    }
}