package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity
{
    HelperDB helperDB;
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
        helperDB = new HelperDB(this);
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

        SQLiteDatabase db = helperDB.getWritableDatabase();
        cursor = db.rawQuery("SELECT * FROM main;", null);

        String[] column = new String[] {"place", "addres"};

        adapter = new SimpleCursorAdapter
                (this, android.R.layout.simple_list_item_2, cursor, column, new int[]{android.R.id.text1, android.R.id.text2}, 0);
        listview1.setAdapter(adapter);
    }

    public void click() {

        SQLiteDatabase db = helperDB.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        String city = edittext1.getText().toString();
        String country = edittext2.getText().toString();

        contentValues.put("city", city);
        contentValues.put("country", country);
        db.insert("main", null, contentValues);

        selectall();
    }

}