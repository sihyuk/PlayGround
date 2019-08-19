package com.example.androidplayground;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.androidplayground.DBHelper.DatabaseHelper;

public class SqlDatabase extends AppCompatActivity {

    DatabaseHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql_database);
        mydb = new DatabaseHelper(this);
    }
}
