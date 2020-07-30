package com.example.tureng2.Core;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.example.tureng2.MediaPlayer.MPAs;
import com.example.tureng2.R;
import com.example.tureng2.Sub_Core.AlphabetExamples;
import com.example.tureng2.Sub_Core.ListeningExampleA1;
import com.google.android.material.navigation.NavigationView;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class SpeechA1 extends MPAs implements NavigationView.OnNavigationItemSelectedListener {

    private ConstraintLayout sectionItems;
    private ImageView a2,a3,a5,a1;
    private TextView a4;
    private ConstraintLayout sectionDialogs,sectionDialogs2;
    private SideMenu sideMenu;
    private BootstrapButton b1,b2,b3,b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speech_a1);


        try {
            a1 = findViewById(R.id.whoami);
            a2 = findViewById(R.id.itemsSpeech);
            a3 = findViewById(R.id.sampleWords);
            a4 = findViewById(R.id.items_Text);
            a5 = findViewById(R.id.sampleDialogss);



            b1 = findViewById(R.id.btn_sampleSentenceImage);
            b2 = findViewById(R.id.btn_whoamiImage);
            b3 = findViewById(R.id.btn_items_Text);
            b4 = findViewById(R.id.btn_items_dialogs);

            sideMenu = new SideMenu(SpeechA1.this);
            sideMenu.createDrawer();


            sectionDialogs = findViewById(R.id.sectionSimpleDialogs);
            sectionDialogs2 = findViewById(R.id.sectionSimpleDialogs2);
            sectionItems = findViewById(R.id.sectionItemsListen);
        }
        catch (Exception e)
        {
            Log.e("Core/SpeechA1","OnCreate Exception", e);
        }
    }

    public void listenSampleWords(View view) {
        try {
            Intent intent = new Intent(this, AlphabetExamples.class);
            startActivity(intent);
        }
        catch (Exception e)
        {
            Log.e("Core/SpeechA1","Intent Exception", e);
        }
    }

    public void listenwhoami(View view) {
        try {
            Intent intent = new Intent(this, ListeningExampleA1.class);
            startActivity(intent);
        }
        catch (Exception e)
        {
            Log.e("Core/SpeechA1","Intent Exception", e);
        }
    }

    public void clearBackground()
    {
        try {
            a1.setVisibility(GONE);
            a2.setVisibility(GONE);
            a3.setVisibility(GONE);
            a5.setVisibility(GONE);

            b1.setVisibility(GONE);
            b2.setVisibility(GONE);
            b3.setVisibility(GONE);
            b4.setVisibility(GONE);
        }
        catch (Exception e)
        {
            Log.e("Core/SpeechA1","ClearBackground Exception", e);
        }
    }

    public void listenDialog(View view)
    {
      mpstart("https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Sample_dialogs%2Ftanisma.wav?alt=media&token=4679d861-b5e0-4451-b92a-ff9b31c92447");
    }

    public void listenDialog2(View view)
    {
        mpstart("https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Sample_dialogs%2Fgomlek.wav?alt=media&token=8ed1446b-5a8e-4be3-bbc1-38f36ae6bd59");
    }

    public void setNextListeningSection(View view)
    {
        try {
            sectionDialogs.setVisibility(GONE);
            sectionDialogs2.setVisibility(VISIBLE);
        }
        catch (Exception e)
        {
            Log.e("Core/SpeechA1","NextListeningSection Exception", e);
        }
    }

    public void listen_sampleDialog(View view)
    {
        try {
            clearBackground();
            sectionDialogs.setVisibility(VISIBLE);
        }
        catch (Exception e)
        {
            Log.e("Core/SpeechA1","ListenSampleDialog Exception", e);
        }
    }

    public void listen_items(View view)
    {
        try {
            clearBackground();
            sectionItems.setVisibility(VISIBLE);

            switch (view.getId()) {
                case (R.id.bag):
                    mpstart("https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Objects2%2Fcanta.wav?alt=media&token=345da531-c5ee-49db-981c-fa80e27aa8cd");
                    break;
                case (R.id.chair):
                    mpstart("https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Objects2%2Fsandalye.wav?alt=media&token=2dbcac22-2728-457a-aaa0-32a4a8a61cca");
                    break;
                case (R.id.camera):
                    mpstart("https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Objects2%2Fkamera.wav?alt=media&token=a7c93a68-6b03-4d1d-bc52-664d64d5e526");
                    break;
                case (R.id.sofa):
                    mpstart("https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Objects2%2Fkanepe.wav?alt=media&token=258b72ca-f606-44cf-9ad8-dc2518729507");
                    break;
                case (R.id.clock):
                    mpstart("https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Objects2%2Fsaat.wav?alt=media&token=8ea4903b-39b7-41c1-b42c-3d84c9aa19a6");
                    break;
                case (R.id.table):
                    mpstart("https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Objects2%2Fmasa.wav?alt=media&token=8acd1d7d-8222-41d0-adce-3774ac3433d6");
                    break;
                case (R.id.glove):
                    mpstart("https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Objects2%2Feldiven.wav?alt=media&token=6388dfd1-f5a9-43a5-8e92-75eb6dd829f6");
                    break;
                case (R.id.scissor):
                    mpstart("https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Objects2%2Fmakas.wav?alt=media&token=3dfcaae7-1c91-41b6-8f3b-91587d38f150");
                    break;
            }
        }
        catch (Exception e)
        {
            Log.e("Core/SpeechA1","MPstart Exception", e);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        try {
            sideMenu.onNavigationItemSelected(menuItem);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
}
