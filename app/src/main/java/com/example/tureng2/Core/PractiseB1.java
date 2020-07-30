package com.example.tureng2.Core;

import android.os.Bundle;
import android.util.Log;
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

        try {
            mainScreen = findViewById(R.id.groupMain);

            db = new DbOperations(PractiseB1.this);
            sideMenu = new SideMenu(PractiseB1.this);
            sideMenu.createDrawer();
        }
        catch (Exception e)
        {
            Log.e("Core/PractiseB1","OnCreate Exception", e);
        }
    }

    public void prepareFragment()
    {
        try {
            mainScreen.setVisibility(View.GONE);
            fm = getSupportFragmentManager();
        }
        catch (Exception e)
        {
            Log.e("Core/PractiseB1","Prepare Fragment Exception", e);
        }
    }

    public void trueFalseOnClick(View view)
    {
        prepareFragment();

        try {
            TrueFalseExercise_B1 fragment_truefalse = new TrueFalseExercise_B1();
            fm.beginTransaction().replace(R.id.practise_levelb1, fragment_truefalse).commit();
        }
        catch(Exception e)
        {
            Log.e("Core/PractiseB1","Fragment Exception", e);
        }
    }

    public void fillgapsOnClick(View view)
    {
        prepareFragment();

        try {
            FillGapsExerciseB1 fragment_fillgaps = new FillGapsExerciseB1();
            fm.beginTransaction().replace(R.id.practise_levelb1, fragment_fillgaps).commit();
        }
        catch (Exception e)
        {
            Log.e("Core/PractiseB1","Fragment Exception", e);
        }
    }

    public void adverbexerciseOnClick(View view)
    {
        prepareFragment();

        try {
            AdverbExerciseB1 fragment_adverbexercise = new AdverbExerciseB1();
            fm.beginTransaction().replace(R.id.practise_levelb1, fragment_adverbexercise).commit();
        }
        catch (Exception e)
        {
            Log.e("Core/PractiseB1","Fragment Exception", e);
        }
    }

    public void sendAnswer(View view)
    {
        try {
            switch (view.getId()) {
                case(R.id.answer12):
                case(R.id.answer18):
                case(R.id.answer23):
                case(R.id.answer32):
                case(R.id.answer36):
                case(R.id.answer46):
                    Toast.makeText(this, "Tebrikler, doğru cevap verdiniz.", Toast.LENGTH_SHORT).show();
                    break;
                default: Toast.makeText(this, "Yanlış cevap verdiniz.", Toast.LENGTH_SHORT).show();
            }
        }
        catch (Exception e)
        {
            Log.e("Core/PractiseB1","Send Answer Exception", e);
        }
    }

    public void emergencyOnClick(View view)
    {
        prepareFragment();

        try {
            EmergencyExerciseB1 fragment_emergencyExerciseB1 = new EmergencyExerciseB1();
            fm.beginTransaction().replace(R.id.practise_levelb1, fragment_emergencyExerciseB1).commit();
        }
        catch (Exception e)
        {
            Log.e("Core/PractiseB1","Fragment Exception", e);
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
            Log.e("Core/PractiseB1","Navigation Item Selected Exception", e);
            return false;
        }
    }
}
