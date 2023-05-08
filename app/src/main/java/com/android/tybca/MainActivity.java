package com.android.tybca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/*
* Layout -> Screen which user can see
Widgets -> Where you can perform any task with on screen

* Predictions -> Ctrl + Space

wrap_content -> Adjusts the space according to the size of element, \
match_parent -> Occupies the space of the screen either from left to right or top to bottom

Text -> TextView -> Text on the screen

Display color on screen
1. By default colors of android : @android:color/color_name
2. Hexadecimal Values: #FFFF0000
3. From colors.xml file: @color/color_name
*
* To import a package :- Alt + Enter
* Single line comment: Ctrl + /

* DATABASE IN ANDROID -> Local - SQLite DB #, Remote(API) - Volley, Retrofit
*
* */

public class MainActivity extends AppCompatActivity {
    EditText _userName,_password;
    Button _btnLogin,_btnRegister;
    TextView _loginMessage;
    String uname,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _userName = findViewById(R.id.userName);
        _password = findViewById(R.id.password);
        _btnLogin = findViewById(R.id.btnLogin);
        _btnRegister = findViewById(R.id.btnRegister);
        _loginMessage = findViewById(R.id.loginMessage);
        _loginMessage.setVisibility(View.GONE);

        _btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();

            }
        });
    }

    private void login() {
        uname = _userName.getText().toString().trim();
        pass = _password.getText().toString().trim();

        //If Username is blank
        if(uname.length() < 0 && uname == "")
        {
            _userName.setError("Please enter Username");
        }
        //If Password is blank
        else if(pass.length() < 0 && pass == "")
        {
            _password.setError("Password cannot be blank");
        }
        //If all validations of login matches
        else
        {
            //                    If length of password is not greater than 8
            if(pass.length() < 8)
            {
                _password.setError("Password Length should be minimum 8 characters");
            }
            else
            {
                _loginMessage.setText("");
                _loginMessage.setVisibility(View.VISIBLE);

                if(uname == "hatimkanorwala" && pass == "password")
                {
                    _loginMessage.setText("Logged in successful");
                }
                else
                {
                    _loginMessage.setText("Failed to Login");
                }
            }

        }
    }

    public void redirectRegister(View v)
    {
        // PutExtra -> Used to transfer data from one activity to another
        //Current page
        //pageName.this, getApplicationContext() -> Automatically get the source of the page


        Intent i = new Intent(getApplicationContext(),registerActivity.class);
//        i.putExtra("userName","hatimkanorwala");
        startActivity(i);
        finish();
    }
}