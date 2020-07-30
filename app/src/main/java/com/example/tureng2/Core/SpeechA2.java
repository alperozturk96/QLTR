package com.example.tureng2.Core;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.TypefaceProvider;
import com.example.tureng2.MediaPlayer.MPAs;
import com.example.tureng2.R;
import com.example.tureng2.Sub_Core.TimeCasesListeningA2;
import com.google.android.material.navigation.NavigationView;

public class SpeechA2 extends MPAs implements NavigationView.OnNavigationItemSelectedListener {

    private BootstrapButton refresh,section1,section2,section3;
    private ListView lv_speechLevelA2;
    private ConstraintLayout speechLevelA2Main;
    private SideMenu sideMenu;
    private DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speech_a2);

        try {
            TypefaceProvider.registerDefaultIconSets();

            refresh = findViewById(R.id.refresh);
            lv_speechLevelA2 = findViewById(R.id.listViewSpeechA2);
            section1 = findViewById(R.id.sectionAdjectivePart);
            section2 = findViewById(R.id.sectionObjectsPart);
            section3 = findViewById(R.id.sectionTimeCases);
            speechLevelA2Main = findViewById(R.id.speech_levela2);
            drawerLayout = findViewById(R.id.drawer_layout);

            sideMenu = new SideMenu(SpeechA2.this);
            sideMenu.createDrawer();

            if (isConnected()) {
                refresh.setVisibility(View.GONE);
            }
            else
            {
                section1.setVisibility(View.GONE);
                section2.setVisibility(View.GONE);
                section3.setVisibility(View.GONE);
            }
        }
        catch (Exception e)
        {
            Log.e("Core/SpeechA2","OnCreate Exception", e);
        }
    }

    public void clearBackground()
    {
        try {
            section3.setVisibility(View.GONE);
            section2.setVisibility(View.GONE);
            section1.setVisibility(View.GONE);

            lv_speechLevelA2.setVisibility(View.VISIBLE);
            speechLevelA2Main.setBackground(ContextCompat.getDrawable(this, R.drawable.white));
            drawerLayout.setBackground(ContextCompat.getDrawable(this, R.drawable.white));
        }
        catch (Exception e)
        {
            Log.e("Core/SpeechA2","ClearBackground Exception", e);
        }
    }

    public void listenTimeCasesOnClick(View view)
    {
        try {
            FragmentManager fm = getSupportFragmentManager();
            TimeCasesListeningA2 fragment_timecases_listening_a2 = new TimeCasesListeningA2();
            fm.beginTransaction().replace(R.id.speech_levela2, fragment_timecases_listening_a2).commit();
        }
        catch (Exception e)
        {
            Log.e("Core/SpeechA2","Fragment Exception", e);
        }
    }

    public void listenAdjectives(View view)
    {
        try {
            clearBackground();

            final String[] addressList = {"https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Adjectives%2Fbuaksam.wav?alt=media&token=47376da6-d468-4b11-8a80-0eea5a873687",
                    "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Adjectives%2Fbukitabi.wav?alt=media&token=57a299f6-a34e-4155-8625-a09e8ce88d50",
                    "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Adjectives%2Fcaliskan.wav?alt=media&token=ebaee3e3-8830-4fda-96a3-f0d3b9cca246",
                    "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Adjectives%2Fhangiaraba.wav?alt=media&token=2ad0e2b8-0116-4cb2-a721-e2863d146f79",
                    "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Adjectives%2Fkarabulutlar.wav?alt=media&token=27e54378-497b-476c-b24f-c2c59673ed7f",
                    "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Adjectives%2Fsayfaokuyorum.wav?alt=media&token=35124d2f-cbc2-4cf8-ae60-45c19f13f918"};

            String [] headerList = {"Bu akşam eski bir arkadaşımla masmavi denizi seyrettik.","Bu kitabı senin için aldım.","Çalışkan öğrenci sınavda birinci oldu.","Hangi araba daha pahalı ?",
                    "Gökyüzünü aniden kara bulutlar kaplamıştı.","Her akşam on yedi sayfa kitap okurum."};

            createListView(R.id.listViewSpeechA2,addressList,headerList);
        }
        catch (Exception e)
        {
            Log.e("Core/SpeechA2","Listen Adjectives Exception", e);
        }
    }

    public void listenObjects(View view)
    {
        try {
            clearBackground();

            final String[] addressList = {"https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Objects%2Fcantayeryoj.wav?alt=media&token=c637ecca-9635-45e2-9005-7dacc399beff",
                    "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Objects%2Fkoltukhicrhaat.wav?alt=media&token=5079f442-0836-439c-b0d9-9fec73cd387a",
                    "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Objects%2Fmakasi.wav?alt=media&token=40dd728a-bb26-4e5f-b2a9-5a95d6b0589e",
                    "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Objects%2Fmor%20eldiven.wav?alt=media&token=6cb3f9ed-71b6-45e1-8366-71d80ef1a7b1",
                    "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Objects%2Fsaatkac.wav?alt=media&token=0ce91187-73f7-4536-bc17-492f83b502f7",
                    "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Objects%2Fyenibirsandalye.wav?alt=media&token=2ae52d75-ff1a-4fe2-b151-90b28a95a441"};

            String [] headerList = {"Çantamda hiç yer yok.","Koltuk hiç rahat değil.","Makası uzatır mısın ?","Filmdeki mor eldiveni çok seviyorum.",
                    "Saat kaç ?", "Yeni bir sandalye almamız gerek."};

            createListView(R.id.listViewSpeechA2,addressList,headerList);
        }
        catch (Exception e)
        {
            Log.e("Core/SpeechA2","Listen Objects Exception", e);
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
            Log.e("Core/SpeechA2","Navigation Item Selected Exception", e);
            return false;
        }
    }
}
