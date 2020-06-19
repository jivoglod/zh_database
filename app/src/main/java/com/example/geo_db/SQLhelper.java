package com.example.geo_db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLhelper extends SQLiteOpenHelper
{

    public SQLhelper(Context context) {
        super(context, "geodb", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table main ( _id integer primary key, place text, addres text)");
        db.execSQL("INSERT INTO main ( place, addres) VALUES ('Клевер', 'Семеновская 15');");
        db.execSQL("INSERT INTO main ( place, addres) VALUES ('Искра', 'Пр-кт Столетия 42а');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("drop table main");
        onCreate(db);
    }


}