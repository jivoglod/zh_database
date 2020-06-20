package com.example.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class HelperDB extends SQLiteOpenHelper
{

    public HelperDB(Context context) {
        super(context, "database", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table main ( _id integer primary key, place text, addres text)");
        db.execSQL("INSERT INTO main ( city, country) VALUES ('Los-Angeles', 'USA');");
        db.execSQL("INSERT INTO main ( city, country) VALUES ('Moscow', 'Russia');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }


}