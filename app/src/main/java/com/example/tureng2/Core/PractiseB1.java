package com.example.tureng2.Core;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.FragmentManager;

import com.example.tureng2.Database_Operations.DbOperations;
import com.example.tureng2.R;
import com.example.tureng2.Sub_Core.AdverbExerciseB1;
import com.example.tureng2.Sub_Core.EmergencyExerciseB1;
import com.example.tureng2.Sub_Core.FillGapsExerciseB1;
import com.example.tureng2.Sub_Core.TrueFalseExercise_B1;
import com.google.android.material.navigation.NavigationView;


public class PractiseB1 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private FragmentManager fm;
    private Group mainScreen;
    private DbOperations db;
    private SideMenu sideMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practise_b1);

        mainScreen = findViewById(R.id.groupMain);

        db = new DbOperations(PractiseB1.this);
        sideMenu = new SideMenu(PractiseB1.this);
        sideMenu.createDrawer();
    }

    public void prepareFragment() {
        mainScreen.setVisibility(View.GONE);
        fm = getSupportFragmentManager();
    }

    public void trueFalseOnClick(View view) {
        prepareFragment();
        TrueFalseExercise_B1 fragment_truefalse = new TrueFalseExercise_B1();
        fm.beginTransaction().replace(R.id.practise_levelb1, fragment_truefalse).commit();
    }

    public void fillgapsOnClick(View view) {
        prepareFragment();

        FillGapsExerciseB1 fragment_fillgaps = new FillGapsExerciseB1();
        fm.beginTransaction().replace(R.id.practise_levelb1, fragment_fillgaps).commit();
    }

    public void adverbexerciseOnClick(View view) {
        prepareFragment();
        AdverbExerciseB1 fragment_adverbexercise = new AdverbExerciseB1();
        fm.beginTransaction().replace(R.id.practise_levelb1, fragment_adverbexercise).commit();
    }

    public void sendAnswer(View view) {
        switch (view.getId()) {
            case (R.id.answer12):
            case (R.id.answer18):
            case (R.id.answer23):
            case (R.id.answer32):
            case (R.id.answer36):
            case (R.id.answer46):
                Toast.makeText(this, "Tebrikler, doğru cevap verdiniz.", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(this, "Yanlış cevap verdiniz.", Toast.LENGTH_SHORT).show();
        }
    }

    public void emergencyOnClick(View view) {
        prepareFragment();
        EmergencyExerciseB1 fragment_emergencyExerciseB1 = new EmergencyExerciseB1();
        fm.beginTransaction().replace(R.id.practise_levelb1, fragment_emergencyExerciseB1).commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        sideMenu.onNavigationItemSelected(menuItem);
        return true;
    }
}
