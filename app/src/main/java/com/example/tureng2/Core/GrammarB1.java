package com.example.tureng2.Core;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;

import com.example.tureng2.Database_Operations.DbOperations;
import com.example.tureng2.R;
import com.example.tureng2.Sub_Core.AdverbVerbB1;
import com.example.tureng2.Sub_Core.EmergencyNumbersB1;
import com.example.tureng2.Sub_Core.ImperfectTenseExampleA2;
import com.example.tureng2.Sub_Core.NounExamples_B1;
import com.example.tureng2.Sub_Core.VerbsExamples_B1;
import com.google.android.material.navigation.NavigationView;


public class GrammarB1 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private FragmentManager fm;
    private ConstraintLayout sectionMainB1;
    private DbOperations db;
    private SideMenu sideMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grammar_b1);

        try {
            sectionMainB1 = findViewById(R.id.grammar_levelb1_main);
            db = new DbOperations(GrammarB1.this);
            sideMenu = new SideMenu(GrammarB1.this);
            sideMenu.createDrawer();
        }
        catch (Exception e)
        {
            Log.e("Core/GrammarB1","OnCreate Exception", e);
        }
    }

    public void prepareFragment()
    {
        try {
            sectionMainB1.setVisibility(View.GONE);
            fm = getSupportFragmentManager();
        }
        catch (Exception e)
        {
            Log.e("Core/GrammarB1","Prepare Fragment Exception", e);
        }
    }

    public void nounOnClick(View view)
    {
        try {
            prepareFragment();
            NounExamples_B1 fragment_nounverb = new NounExamples_B1();
            fm.beginTransaction().replace(R.id.grammar_levelb1,fragment_nounverb).commit();
        }
        catch (Exception e)
        {
            Log.e("Core/GrammarB1","Noun OnClick Exception", e);
        }
    }

    public void verbOnClick(View view)
    {
        try {
            prepareFragment();
            VerbsExamples_B1 fragment_verbsExamples_b1 = new VerbsExamples_B1();
            fm.beginTransaction().replace(R.id.grammar_levelb1,fragment_verbsExamples_b1).commit();
        }
        catch (Exception e)
        {
            Log.e("Core/GrammarB1","Verb On Click Exception", e);
        }
    }

    public void adverbOnClick(View view)
    {
        try {
            prepareFragment();
            AdverbVerbB1 fragment_adverb = new AdverbVerbB1();
            fm.beginTransaction().replace(R.id.grammar_levelb1,fragment_adverb).commit();
        }
        catch (Exception e)
        {
            Log.e("Core/GrammarB1","Adverb On Click Exception", e);
        }
    }

    public void imperfectOnClick(View view)
    {
        try {
            prepareFragment();
            ImperfectTenseExampleA2 fragment_imperfect = new ImperfectTenseExampleA2();
            fm.beginTransaction().replace(R.id.grammar_levelb1,fragment_imperfect).commit();
        }
        catch (Exception e)
        {
            Log.e("Core/GrammarB1","Imperfect On Click Exception", e);
        }
    }

    public void emergencyOnClick(View view) {
        try {
            prepareFragment();
            EmergencyNumbersB1 fragment_emergency = new EmergencyNumbersB1();
            fm.beginTransaction().replace(R.id.grammar_levelb1, fragment_emergency).commit();
        }
        catch (Exception e)
        {
            Log.e("Core/GrammarB1","Emergency On Click Exception", e);
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
            Log.e("Core/GrammarB1","Navigation Item Selected Exception", e);
            return false;
        }
    }
}
