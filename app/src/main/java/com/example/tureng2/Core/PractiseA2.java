package com.example.tureng2.Core;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.example.tureng2.Database_Operations.DbOperations;
import com.example.tureng2.R;
import com.example.tureng2.Sub_Core.FillGapsExerciseA2;
import com.example.tureng2.Sub_Core.FillParagraphGapsExerciseA2;
import com.example.tureng2.Sub_Core.MultipleChoiceExerciseA2;
import com.google.android.material.navigation.NavigationView;



public class PractiseA2 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private TextView a1,a2,a3,a4,a5,t;
    private ImageView i1,i2,i3,i4;
    private ConstraintLayout introduceYourself;
    private AlertDialog.Builder dialogBuilder;
    private AlertDialog alertDialog;
    private GlobalAlertDialog gb;
    private DbOperations db;
    private SideMenu sideMenu;
    private BootstrapButton b1,b2,b3,b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practise_a2);

        try {
            gb = new GlobalAlertDialog(PractiseA2.this);
            db = new DbOperations(PractiseA2.this);


            sideMenu = new SideMenu(PractiseA2.this);
            sideMenu.createDrawer();


            a1 = findViewById(R.id.getAnswer);
            a2 = findViewById(R.id.getAnswer2);
            a3 = findViewById(R.id.getAnswer3);
            a4 = findViewById(R.id.getAnswer4);
            a5 = findViewById(R.id.getAnswer5);

            b1 = findViewById(R.id.btn_whofil);
            b2 = findViewById(R.id.btn_multiple);
            b3 = findViewById(R.id.btn_paragarph);
            b4 = findViewById(R.id.btn_levelImA1);


            i1 = findViewById(R.id.multipleChoice);
            i2 = findViewById(R.id.writeLetter);
            i3 = findViewById(R.id.paragaph);
            i4 = findViewById(R.id.introduceMyself);
            introduceYourself = findViewById(R.id.introduceYourself);

            dialogBuilder = new AlertDialog.Builder(this);
            alertDialog = dialogBuilder.create();
        }
        catch (Exception e)
        {
            Log.e("Core/PractiseA2","OnCreate Exception", e);
        }
    }

    public void clearBackground()
    {
        try {
            i1.setVisibility(View.GONE);
            i2.setVisibility(View.GONE);
            i3.setVisibility(View.GONE);
            i4.setVisibility(View.GONE);

            b1.setVisibility(View.GONE);
            b2.setVisibility(View.GONE);
            b3.setVisibility(View.GONE);
            b4.setVisibility(View.GONE);
        }
        catch (Exception e)
        {
            Log.e("Core/PractiseA2","Clear Background Exception", e);
        }
    }

    public void multipleChoiceOnClick(View view) {
        Intent intent = new Intent(this, MultipleChoiceExerciseA2.class);
        startActivity(intent);
    }

    public void fillGapsOnClick(View view) {
        Intent intent = new Intent(this, FillGapsExerciseA2.class);
        startActivity(intent);
    }

    public void paragraphOnClick(View view) {
        Intent intent = new Intent(this, FillParagraphGapsExerciseA2.class);
        startActivity(intent);
    }

    public void myselfOnClick(View view)
    {
        clearBackground();
        introduceYourself.setVisibility(View.VISIBLE);
    }

    //6,4,9,1,8
    public void puttingInOrder(View view)
    {
        try {
            dialogBuilder.setTitle("Cümle kaçıncı sıradadır ?");

            switch (view.getId()) {
                case (R.id.getAnswer):
                    String[] answers = {"2", "1", "3", "5","4"};
                    dialogBuilder.setItems(answers, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            gb.controlAnswer(which,1,a1, PractiseA2.this);
                        }
                    });
                    break;
                case (R.id.getAnswer2):
                    String[] answers2 = {"4", "2", "1", "3","5"};
                    dialogBuilder.setItems(answers2, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            gb.controlAnswer(which,4,a2, PractiseA2.this);
                        }
                    });
                    break;
                case (R.id.getAnswer3):
                    String[] answers3 = {"3", "2", "5", "4","1"};
                    dialogBuilder.setItems(answers3, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            gb.controlAnswer(which,1,a3, PractiseA2.this);
                        }
                    });
                    break;
                case (R.id.getAnswer4):
                    String[] answers4 = {"1", "2", "4", "3","5"};
                    dialogBuilder.setItems(answers4, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            gb.controlAnswer(which,2,a4, PractiseA2.this);
                        }
                    });
                    break;
                case (R.id.getAnswer5):
                    String[] answers5 = {"5", "4", "3", "2","1"};
                    dialogBuilder.setItems(answers5, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            gb.controlAnswer(which,2,a5, PractiseA2.this);
                        }
                    });
                    break;
            }
            dialogBuilder.show();
        }
        catch (Exception e)
        {
            Log.e("Core/PractiseA2","GAD Exception", e);
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
            Log.e("Core/PractiseA2","Navigation Item Selected Exception", e);
            return false;
        }
    }
}
