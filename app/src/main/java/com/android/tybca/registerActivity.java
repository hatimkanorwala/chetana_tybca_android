package com.android.tybca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//SharedPreferences -> A type of localstorage which can store data for some period of time until it is destroyed
public class registerActivity extends AppCompatActivity {
    Button _registerButton;
    public static final String myPrefs = "myprefs";
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        _registerButton = findViewById(R.id.btnRegister);
        sharedPreferences = getSharedPreferences(myPrefs,MODE_PRIVATE);

        //Bundle is used to get all the collected info data from the project
        //Extract only the intent info from bundle and get the extras from it
        //Using getString or getInt we extract the data using key from the bundle object
        Bundle b = getIntent().getExtras();
        String userName = b.getString("userName");

        _registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create, Read, Delete, Update

                //Create
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("userName","hatimkanorwala");
                editor.putInt("userId",1);
                editor.commit();

                //Read
                int userId = sharedPreferences.getInt("userId",0);
                String userName = sharedPreferences.getString("userName","");

                //Delete
                editor.remove("userName");
                editor.commit();

                //Update -> Remove the existing element and add new value for it



            }
        });

    }
}