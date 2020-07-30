package com.example.tureng2.Core;

import android.os.Bundle;
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

        sectionMainB1 = findViewById(R.id.grammar_levelb1_main);
        db = new DbOperations(GrammarB1.this);
        sideMenu = new SideMenu(GrammarB1.this);
        sideMenu.createDrawer();
    }

    public void prepareFragment() {
        sectionMainB1.setVisibility(View.GONE);
        fm = getSupportFragmentManager();
    }

    public void nounOnClick(View view) {
        prepareFragment();
        NounExamples_B1 fragment_nounverb = new NounExamples_B1();
        fm.beginTransaction().replace(R.id.grammar_levelb1, fragment_nounverb).commit();
    }

    public void verbOnClick(View view) {
        prepareFragment();
        VerbsExamples_B1 fragment_verbsExamples_b1 = new VerbsExamples_B1();
        fm.beginTransaction().replace(R.id.grammar_levelb1, fragment_verbsExamples_b1).commit();
    }

    public void adverbOnClick(View view) {
        prepareFragment();
        AdverbVerbB1 fragment_adverb = new AdverbVerbB1();
        fm.beginTransaction().replace(R.id.grammar_levelb1, fragment_adverb).commit();
    }

    public void imperfectOnClick(View view) {
        prepareFragment();
        ImperfectTenseExampleA2 fragment_imperfect = new ImperfectTenseExampleA2();
        fm.beginTransaction().replace(R.id.grammar_levelb1, fragment_imperfect).commit();
    }

    public void emergencyOnClick(View view) {
        prepareFragment();
        EmergencyNumbersB1 fragment_emergency = new EmergencyNumbersB1();
        fm.beginTransaction().replace(R.id.grammar_levelb1, fragment_emergency).commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        sideMenu.onNavigationItemSelected(menuItem);
        return true;
    }
}
