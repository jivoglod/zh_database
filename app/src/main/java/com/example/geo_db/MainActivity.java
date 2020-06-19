package com.example.geo_db;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.LauncherActivity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.TwoLineListItem;

public class MainActivity extends AppCompatActivity
{
    SQLhelper sqLhelper;
    EditText edittext1;
    EditText edittext2;
    ListView listview1;
    Button button1;
    Cursor cursor;
    SimpleCursorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edittext1 = findViewById(R.id.editText1);
        edittext2 = findViewById(R.id.editText2);
        listview1 = findViewById(R.id.listview1);
        button1 = findViewById(R.id.button1);
        sqLhelper = new SQLhelper(this);
        selectall();
        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                click();
            }
        });
    }


    public void selectall() {

        SQLiteDatabase db = sqLhelper.getWritableDatabase();
        cursor = db.rawQuery("SELECT * FROM main;", null);

        String[] column = new String[] {"place", "addres"};

        adapter = new SimpleCursorAdapter
                (this, android.R.layout.simple_list_item_2, cursor, column, new int[]{android.R.id.text1, android.R.id.text2}, 0);
        listview1.setAdapter(adapter);
    }

    public void click() {

        SQLiteDatabase db = sqLhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        String place = edittext1.getText().toString();
        String addr = edittext2.getText().toString();

        contentValues.put("place", place);
        contentValues.put("addres", addr);
        db.insert("main", null, contentValues);

        selectall();
    }

}