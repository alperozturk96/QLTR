package com.example.tureng2.Core;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.tureng2.Authentication.Login;
import com.example.tureng2.R;

public class Practise extends Login {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practise);


    }

    public void practise_levela1OnClick(View view) {
        Intent intent = new Intent(this, PractiseA1.class);
        startActivity(intent);
    }

    public void practise_levela2OnClick(View view) {
        if (loggedScore > 25) {
            Intent intent = new Intent(this, PractiseA2.class);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "Yeterli puanınız olmadığı için bu bölüme geçemezsiniz.", Toast.LENGTH_SHORT).show();
        }
    }

    public void practise_levelb1OnClick(View view) {
        if (loggedScore > 50) {
            Intent intent = new Intent(this, PractiseB1.class);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "Yeterli puanınız olmadığı için bu bölüme geçemezsiniz.", Toast.LENGTH_SHORT).show();
        }
    }
}
