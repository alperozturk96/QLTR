package com.example.tureng2.Sub_Core;


import android.os.Bundle;
import android.view.View;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.TypefaceProvider;
import com.example.tureng2.MediaPlayer.MPAs;
import com.example.tureng2.R;

public class ListeningExampleA1 extends MPAs {

    private BootstrapButton refresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listening_example_a1);

        TypefaceProvider.registerDefaultIconSets();


        refresh = findViewById(R.id.refresh);

        if (isConnected()) {
            refresh.setVisibility(View.INVISIBLE);
        }

    }

    public void listen(View view) {
        switch (view.getId()) {
            case (R.id.gokhan):
                mpstart("https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Sample_dialogs%2Fgokali.wav?alt=media&token=4c48ad00-5e11-420d-8429-dce3b1da0499");
                break;
            case (R.id.altan):
                mpstart("https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Sample_dialogs%2Faltan.wav?alt=media&token=97ca50aa-fb6e-49f0-a8bd-df5c66132a91");
                break;
            case (R.id.ali):
                mpstart("https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Sample_dialogs%2FaliMee.wav?alt=media&token=b3ee22ad-4ed9-4bc3-b515-5435e1f1b1a1");
                break;
        }
    }
}
