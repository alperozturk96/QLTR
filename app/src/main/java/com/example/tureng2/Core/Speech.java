package com.example.tureng2.Core;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.tureng2.MediaPlayer.MPAs;
import com.example.tureng2.R;
import com.example.tureng2.Sub_Core.DailyTalks;

import static com.example.tureng2.Authentication.Login.loggedScore;


public class Speech extends MPAs {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speech);
    }

    public void speech_levela1OnClick(View view) {
        Intent intent = new Intent(this, SpeechA1.class);
        startActivity(intent);
    }

    public void speech_levela2OnClick(View view) {
        if (loggedScore > 25) {
            Intent intent = new Intent(this, SpeechA2.class);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "Yeterli puanınız olmadığı için bu bölüme geçemezsiniz.", Toast.LENGTH_SHORT).show();
        }
    }

    public void dailytalks(View view) {
        Intent intent = new Intent(this, DailyTalks.class);
        startActivity(intent);
    }
}
