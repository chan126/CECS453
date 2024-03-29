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

import static com.example.assignment1.Login.data;

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

        // get static data object from Login.java
        Data sign_user_up = data;

        sign_me_up.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // check text fields for validation
                boolean validated = error_check();
                //if no error, go to the login activity
                if (validated == true) {
                    sign_user_up.addCredential(username.getText().toString(), password.getText().toString());

                    //sign_user_up.print_hashmap(); //change to public to print this

                    Intent intent = new Intent(getApplicationContext(), Login.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Please check errors", Toast.LENGTH_LONG).show();
                }
            }
        });
    }


    /**
     * @return true if all text boxes contain valid data in correct format, as well as if password
     * field and retyped password fields match
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

        if(!retype_password.getText().toString().equals(password.getText().toString()) ){
            retype_password.setError("Password does not match");
            validate = false;
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
            validate = false;
        }else{
            phone.setError(null);
        }

        return validate;
    }
}