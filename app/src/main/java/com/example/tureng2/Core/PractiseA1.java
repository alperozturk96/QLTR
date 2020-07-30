package com.example.tureng2.Core;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.tureng2.Database_Operations.DbOperations;
import com.example.tureng2.R;
import com.example.tureng2.Sub_Core.BodyPartsExerciseA1;
import com.example.tureng2.Sub_Core.MultipleChoiceExerciseA1;
import com.example.tureng2.Sub_Core.NumberMatcingExerciseA1;
import com.google.android.material.navigation.NavigationView;


public class PractiseA1 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private GlobalAlertDialog gb;
    private LayoutManager lm;
    private AlertDialog.Builder dialogBuilder;
    private AlertDialog alertDialog;
    private TextView a1, a2, a3, a4;
    private FragmentManager fm;
    private DbOperations db;
    private SideMenu sideMenu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practise_a1);


        gb = new GlobalAlertDialog(PractiseA1.this);
        lm = new LayoutManager(PractiseA1.this);
        db = new DbOperations(PractiseA1.this);
        sideMenu = new SideMenu(PractiseA1.this);
        sideMenu.createDrawer();

        a1 = findViewById(R.id.who_answer1);
        a2 = findViewById(R.id.who_answer2);
        a3 = findViewById(R.id.who_answer3);
        a4 = findViewById(R.id.who_answer4);

        dialogBuilder = new AlertDialog.Builder(this);
        alertDialog = dialogBuilder.create();
    }

    public void writeAnswerOnClick(View view) {
        Intent intent = new Intent(this, BodyPartsExerciseA1.class);
        startActivity(intent);
    }

    public void whoaretheyOnClick(View view) {
        lm.hideOrShowLayout(R.id.practiselevelA1Main, false);
        lm.hideOrShowLayout(R.id.sectionWhoAreThey, true);
    }

    public void numbersMatchesOnClick(View view) {
        fm = getSupportFragmentManager();
        NumberMatcingExerciseA1 fragment_numbermatching = new NumberMatcingExerciseA1();
        fm.beginTransaction().replace(R.id.practise_levela1, fragment_numbermatching).commit();
    }

    public void practiseWhoAreThey(View view) {
        switch (view.getId()) {
            case (R.id.who_answer1):
                showQuestions(1);
                break;
            case (R.id.who_answer2):
                showQuestions(2);
                break;
            case (R.id.who_answer3):
                showQuestions(3);
                break;
            case (R.id.who_answer4):
                showQuestions(4);
                break;
        }
    }

    public void showQuestions(int questionNumber) {
        String[] answers = {"1", "2", "3", "4"};
        dialogBuilder.setTitle("Yazı hangi resime aittir ?");

        if (questionNumber == 1) {
            dialogBuilder.setItems(answers, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    gb.controlAnswer(which, 3, a1, PractiseA1.this);
                }
            });
        } else if (questionNumber == 2) {
            dialogBuilder.setItems(answers, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    gb.controlAnswer(which, 2, a2, PractiseA1.this);
                }
            });
        } else if (questionNumber == 3) {
            dialogBuilder.setItems(answers, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    gb.controlAnswer(which, 1, a3, PractiseA1.this);
                }
            });

        } else if (questionNumber == 4) {
            dialogBuilder.setItems(answers, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    gb.controlAnswer(which, 0, a4, PractiseA1.this);
                }
            });
        }
        dialogBuilder.show();
    }

    public void multipleChoiceOnClick(View view) {
        Intent intent = new Intent(this, MultipleChoiceExerciseA1.class);
        startActivity(intent);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        sideMenu.onNavigationItemSelected(menuItem);
        return true;
    }
}
