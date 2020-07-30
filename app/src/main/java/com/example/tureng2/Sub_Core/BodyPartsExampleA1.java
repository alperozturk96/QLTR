package com.example.tureng2.Sub_Core;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.beardedhen.androidbootstrap.BootstrapLabel;
import com.example.tureng2.Core.GlobalAlertDialog;
import com.example.tureng2.R;

public class BodyPartsExampleA1 extends AppCompatActivity {

    private GlobalAlertDialog gad = new GlobalAlertDialog(BodyPartsExampleA1.this);
    private ConstraintLayout interior, outer;
    private BootstrapLabel a1, a2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bodyparts_example);


        a1 = findViewById(R.id.interiorParts);
        a2 = findViewById(R.id.externalParts);
        interior = findViewById(R.id.interior_organs);
        outer = findViewById(R.id.external_organs);

    }

    public void interiorpartClick(View view) {
        a1.setVisibility(View.GONE);
        a2.setVisibility(View.GONE);
        outer.setVisibility(View.GONE);
        interior.setVisibility(View.VISIBLE);
    }

    public void externalpartClick(View view) {
        a1.setVisibility(View.GONE);
        a2.setVisibility(View.GONE);
        interior.setVisibility(View.GONE);
        outer.setVisibility(View.VISIBLE);
    }

    public void showInfo(View view) {
        switch (view.getId()) {
            case (R.id.kidney):
                gad.showInfo(view, "Böbrek", "", BodyPartsExampleA1.this);
                break;
            case (R.id.bowel):
                gad.showInfo(view, "Bağırsak", "", BodyPartsExampleA1.this);
                break;
            case (R.id.ear):
                gad.showInfo(view, "Kulak", "", BodyPartsExampleA1.this);
                break;
            case (R.id.brain):
                gad.showInfo(view, "Beyin", "", BodyPartsExampleA1.this);
                break;
            case (R.id.eyes):
                gad.showInfo(view, "Göz", "", BodyPartsExampleA1.this);
                break;
            case (R.id.lungs):
                gad.showInfo(view, "Akciğer", "", BodyPartsExampleA1.this);
                break;
            case (R.id.shoulder):
                gad.showInfo(view, "Omuz", "", BodyPartsExampleA1.this);
                break;
            case (R.id.foot):
                gad.showInfo(view, "Ayak", "", BodyPartsExampleA1.this);
                break;
            case (R.id.stomach):
                gad.showInfo(view, "Mide", "", BodyPartsExampleA1.this);
                break;
            case (R.id.hand):
                gad.showInfo(view, "El", "", BodyPartsExampleA1.this);
                break;
            case (R.id.heart):
                gad.showInfo(view, "Kalp", "", BodyPartsExampleA1.this);
                break;
            case (R.id.nose):
                gad.showInfo(view, "Burun", "", BodyPartsExampleA1.this);
                break;
        }
    }
}
