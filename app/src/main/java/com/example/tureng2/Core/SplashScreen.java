package com.example.tureng2.Core;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tureng2.Authentication.Login;

import static java.lang.Thread.sleep;

public class SplashScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            sleep(3 * 1000);
            Intent intent = new Intent(this, Login.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {
            Log.e("Core/SplashScreen", "SplashScreen Exception", e);
        }

    }
}
