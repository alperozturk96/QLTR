package com.example.tureng2.Core;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tureng2.Database_Operations.DbOperations;
import com.example.tureng2.R;
import com.example.tureng2.Sub_Core.AlphabetA1;
import com.example.tureng2.Sub_Core.BodyPartsExampleA1;
import com.google.android.material.navigation.NavigationView;


public class GrammarA1 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private GlobalAlertDialog gad = new GlobalAlertDialog(GrammarA1.this);
    private LayoutManager lm;
    private DbOperations db;
    private SideMenu sideMenu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grammar_a1);

        lm = new LayoutManager(GrammarA1.this);
        db = new DbOperations(GrammarA1.this);
        sideMenu = new SideMenu(GrammarA1.this);
        sideMenu.createDrawer();

    }

    public void all_lettersOnClick(View view) {
        Intent intent = new Intent(this, AlphabetA1.class);
        startActivity(intent);
    }

    public void show_fullBodyOnClick(View view) {
        Intent intent = new Intent(this, BodyPartsExampleA1.class);
        startActivity(intent);
    }

    public void show_itemsOnClick(View view) {
        lm.hideOrShowLayout(R.id.grammarLevelA1Main, false);
        lm.hideOrShowLayout(R.id.sectionItems, true);
    }

    public void introduceOnClick(View view) {
        lm.hideOrShowLayout(R.id.grammarLevelA1Main, false);
        lm.hideOrShowLayout(R.id.sectionIntroduce, true);
    }

    public void chooseItem(View view) {
        switch (view.getId()) {
            case (R.id.glove):
                gad.showInfo(view, "Eldiven", "", GrammarA1.this);
                break;
            case (R.id.bag):
                gad.showInfo(view, "Çanta", "", GrammarA1.this);
                break;
            case (R.id.scissor):
                gad.showInfo(view, "Makas", "", GrammarA1.this);
                break;
            case (R.id.clock):
                gad.showInfo(view, "Saat", "", GrammarA1.this);
                break;
            case (R.id.sofa):
                gad.showInfo(view, "Koltuk", "", GrammarA1.this);
                break;
            case (R.id.camera):
                gad.showInfo(view, "Kamera", "", GrammarA1.this);
                break;
            case (R.id.table):
                gad.showInfo(view, "Masa", "", GrammarA1.this);
                break;
            case (R.id.chair):
                gad.showInfo(view, "Sandalye", "", GrammarA1.this);
                break;
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        try {
            sideMenu.onNavigationItemSelected(menuItem);
            return true;
        } catch (Exception e) {
            Log.e("Core/GrammarA1", "On Navigation Exception", e);
            return false;
        }
    }
}
