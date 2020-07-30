package com.example.tureng2.Core;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.tureng2.Authentication.Login;
import com.example.tureng2.R;

public class Grammar extends Login {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grammer);

    }

    public void grammar_levela1OnClick(View view) {
        Intent intent = new Intent(this, GrammarA1.class);
        startActivity(intent);
    }

    public void grammar_levela2OnClick(View view) {
        if (loggedScore > 25) {
            Intent intent = new Intent(this, GrammarA2.class);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "Yeterli puanınız olmadığı için bu bölüme geçemezsiniz.", Toast.LENGTH_SHORT).show();
        }
    }

    public void grammar_levelb1OnClick(View view) {
        if (loggedScore > 50) {
            Intent intent = new Intent(this, GrammarB1.class);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "Yeterli puanınız olmadığı için bu bölüme geçemezsiniz.", Toast.LENGTH_SHORT).show();
        }
    }
}
