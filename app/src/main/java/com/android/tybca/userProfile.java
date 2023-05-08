package com.android.tybca;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;

import com.android.tybca.DB.DBHelper;

public class userProfile extends AppCompatActivity {

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);


        dbHelper = new DBHelper(getApplicationContext());
        dbHelper.deleteAll();
        insertData();
       updateData();
       readData();

    }

    private void readData() {
        Cursor cursor = dbHelper.readData();
        if(cursor.getCount() == 0)
        {
            //No Data is present
        }
        else
        {
            while(cursor.moveToNext())
            {
                cursor.getString(0);
                cursor.getString(1);
                cursor.getString(2);
                cursor.getString(3);

            }
        }
    }

    private void updateData() {
        Boolean result = dbHelper.updateData("1","Hatim K","8097922009","hatimjuzerkanorwala@gmail.com");
        if(result == true)
        {
            //Data is updated
        }
        else
        {
            //Data is not updated
        }
    }

    private void insertData() {
        Boolean result = dbHelper.insertData("1","Hatim Kanorwala","8097922009","hatimkanor5253@gmail.com");
        if(result == true)
        {
            //Data is inserted
        }
        else
        {
            //Data is not inserted
        }
    }

}