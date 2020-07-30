package com.example.tureng2.Core;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;

import com.example.tureng2.Database_Operations.DbOperations;
import com.example.tureng2.MediaPlayer.MPAs;
import com.example.tureng2.R;
import com.example.tureng2.Sub_Core.TimeCasesExampleA2;
import com.google.android.material.navigation.NavigationView;


public class GrammarA2 extends MPAs implements NavigationView.OnNavigationItemSelectedListener {

    private LayoutManager lm;
    private DbOperations db;
    private SideMenu sideMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grammar_a2);

        try {
            lm = new LayoutManager(GrammarA2.this);
            db = new DbOperations(GrammarA2.this);
            sideMenu = new SideMenu(GrammarA2.this);
            sideMenu.createDrawer();
        }
        catch (Exception e)
        {
            Log.e("Core/GrammarA2","Intent Exception", e);
        }
    }

    public void timecasesOnClick(View view)
    {
        try {
            FragmentManager fm = getSupportFragmentManager();
            TimeCasesExampleA2 fragment_timeinfoa2 = new TimeCasesExampleA2();
            fm.beginTransaction().replace(R.id.grammar_levela2,fragment_timeinfoa2).commit();
        }
        catch (Exception e)
        {
            Log.e("Core/GrammarA2","Time Cases On Click Exception", e);
        }
    }

    public void listenSampleSentence(View view)
    {
        try {
            switch (view.getId()) {
                case (R.id.imperativeSampleSentence):
                    mpstart("https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Extras%2Flutfenderste.wav?alt=media&token=5019a87a-7646-405c-b518-c40532dadb6a");
                    break;
                case (R.id.imperativeSampleSentence2):
                    mpstart("https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Extras%2Fgokhanda.wav?alt=media&token=9cf8d186-0d08-4ade-90e3-f8403da6f3a7");
                    break;
                case (R.id.imperativeSampleSentence3):
                    mpstart("https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Extras%2Fparketmeyin.wav?alt=media&token=210fafb1-c123-46b9-bdd8-6e77984ffeae");
                    break;
            }
        }
        catch (Exception e)
        {
            Log.e("Core/GrammarA2","MPstart Exception", e);
        }
    }

    public void adjectivesOnClick(View view)
    {
        try {
            lm.hideOrShowLayout(R.id.grammarLevelA2Main,false);
            lm.hideOrShowLayout(R.id.sectionAdjectives,true);
        }
        catch (Exception e)
        {
            Log.e("Core/GrammarA2","Layout Manager Exception", e);
        }
    }

    public void imperativeOnClick(View view)
    {
        try {
            lm.hideOrShowLayout(R.id.grammarLevelA2Main,false);
            lm.hideOrShowLayout(R.id.sectionImperative,true);
        }
        catch (Exception e)
        {
            Log.e("Core/GrammarA2","Layout Manager Exception", e);
        }
    }

    public void strengtheningOnClick(View view)
    {
        try {
            lm.hideOrShowLayout(R.id.grammarLevelA2Main,false);
            lm.hideOrShowLayout(R.id.sectionStrengthening,true);
        }
        catch (Exception e)
        {
            Log.e("Core/GrammarA2","Layout Manager Exception", e);
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
            Log.e("Core/GrammarA2","Navigation Item Selected Exception", e);
            return false;
        }
    }
}
