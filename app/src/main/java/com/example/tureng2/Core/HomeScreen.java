package com.example.tureng2.Core;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tureng2.R;


public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);

    }

    public void practiseOnClick(View view) {
        try {
            Intent intent = new Intent(this, Practise.class);
            startActivity(intent);
        }
        catch (Exception e)
        {
            Log.e("Core/HomeScreen","Intent Exception", e);
        }
    }

    public void grammerOnClick(View view) {
        try {
            Intent intent = new Intent(this, Grammar.class);
            startActivity(intent);
        }
        catch (Exception e)
        {
            Log.e("Core/HomeScreen","Intent Exception", e);
        }

    }

    public void userOnClick(View view) {
        try {
            Intent intent = new Intent(this, UserScreen.class);
            startActivity(intent);
        }
        catch (Exception e)
        {
            Log.e("Core/HomeScreen","Intent Exception", e);
        }
    }

    public void speechOnClick(View view) {
        try {
            Intent intent = new Intent(this, Speech.class);
            startActivity(intent);
        }
        catch (Exception e)
        {
            Log.e("Core/HomeScreen","Intent Exception", e);
        }
    }
}
