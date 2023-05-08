package com.android.tybca.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final String dbName = "college.db";
    public static final String tableName = "students";
    public static final String col1 = "id",col2 = "s_name",col3="mobile",col4="email";
    SQLiteDatabase sqLiteDatabase;

    //Context refers to the page from where it is called
    public DBHelper(@Nullable Context context) {
        super(context, dbName, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //create table students(id text,name text,mobile text, email text);
       sqLiteDatabase.execSQL("create table "+ tableName + "("+col1+" text,"+col2+" text,"+col3+" text,"+col4+" text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //On Upgrade is done when we want to destroy our table and create a new fresh table
        sqLiteDatabase.execSQL("drop table if exists " + tableName);
    }
    public Boolean insertData(String id,String name,String contact,String email)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        //Type of Array data, Map
        ContentValues contentValues = new ContentValues();
        contentValues.put(col1,id);
        contentValues.put(col2,name);
        contentValues.put(col3,contact);
        contentValues.put(col4,email);

        long result = db.insert(tableName,null,contentValues);
        //Resultset -> -1 Data is not inserted, 1 Data is inserted
        if(result == -1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public Boolean updateData(String id,String name,String email,String contact)
    {
        SQLiteDatabase db1 = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(col2,name);
//        contentValues.put(col3,contact);
//        contentValues.put(col4,email);
//
//        long result = db1.update(tableName,contentValues,"id=?",new String[]{id});
//        if(result == -1)
//        {
//            return false;
//        }
//        else
//        {
//            return true;
//        }


//        String updateQuery = "update " + tableName + " set "+ col2 + " = " + name + ","+ col3 + "="+contact+","+col4+"="+email+" where" + col1 + "="+id;
//        db1.execSQL(updateQuery);
//        if(result == -1)
//        {
//            return false;
//        }
//        else
//        {
//            return true;
//        }
        return true;
    }

    public Boolean deleteData(String id)
    {
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.execSQL("delete from "+ tableName + " where "+col1 + " = " + id);
        return true;
    }
    public Boolean deleteAll()
    {
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.execSQL("delete from "+ tableName);
        return true;
    }

    //which reads the data using index form and stores it in array format,
    public Cursor readData()
    {
        sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from "+ tableName,null);
        return cursor;
    }
    public Cursor readIdData(String id)
    {
        sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from "+ tableName + " where "+ col1 + "="+ id,null);
        return cursor;
    }


}
