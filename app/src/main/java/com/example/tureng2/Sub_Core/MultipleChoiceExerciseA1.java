package com.example.tureng2.Sub_Core;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapWell;
import com.beardedhen.androidbootstrap.TypefaceProvider;
import com.example.tureng2.Core.HomeScreen;
import com.example.tureng2.Database_Operations.DbOperations;
import com.example.tureng2.R;

public class MultipleChoiceExerciseA1 extends AppCompatActivity {

    private BootstrapButton answer1, answer2, answer3, answer4, nextPages, goBackHome;
    private ImageView questionPic;
    private DbOperations db;
    private BootstrapWell questionText;

    private int question_counter = 0;
    private int[] questions = {R.drawable.car, R.drawable.carpet, R.drawable.vase, R.drawable.owl};
    private String[][] choices = {
            {"ARACI", "ARABA", "ARABE", "ARABI"},
            {"HALI", "HALİ", "HALU", "HALO"},
            {"VAZÖ", "VAZO", "VAZÜ", "VAZU"},
            {"BAYKİŞ", "BAYKÜŞ", "BAYKUŞ", "BAYKIŞ"}
    };

    private String[] correctAnswers = {"ARABA", "HALI", "VAZO", "BAYKUŞ"};
    private String trueAnswer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplechoice_exercise_a1);


        TypefaceProvider.registerDefaultIconSets();

        db = new DbOperations(MultipleChoiceExerciseA1.this);

        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);
        answer4 = findViewById(R.id.answer4);
        nextPages = findViewById(R.id.nextPage);
        goBackHome = findViewById(R.id.backHome);
        questionText = findViewById(R.id.question1);
        questionPic = findViewById(R.id.img_carss);

        questionPic.setVisibility(View.INVISIBLE);
        questionText.setVisibility(View.INVISIBLE);
        goBackHome.setVisibility(View.INVISIBLE);


        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answer1.getText() == trueAnswer) {
                    db.increaseScore(2);
                    setNextQuestionInfos(view);
                } else {
                    db.wrongAnswer();
                    setNextQuestionInfos(view);
                }
            }
        });

        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answer2.getText() == trueAnswer) {
                    db.increaseScore(2);
                    setNextQuestionInfos(view);
                } else {
                    db.wrongAnswer();
                    setNextQuestionInfos(view);
                }
            }
        });

        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answer3.getText() == trueAnswer) {
                    db.increaseScore(2);
                    setNextQuestionInfos(view);
                } else {
                    db.wrongAnswer();
                    setNextQuestionInfos(view);
                }
            }
        });

        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answer4.getText() == trueAnswer) {
                    db.increaseScore(2);
                    setNextQuestionInfos(view);
                } else {
                    db.wrongAnswer();
                    setNextQuestionInfos(view);
                }
            }
        });

    }

    public String getChoice1(int a) {
        return choices[a][0];
    }

    public String getChoice2(int a) {
        return choices[a][1];
    }

    public String getChoice3(int a) {
        return choices[a][2];
    }

    public String getChoice4(int a) {
        return choices[a][3];
    }

    public String getCorrectAnswer(int a) {
        return correctAnswers[a];
    }

    public void nextPageOnClick(View view) {
        if (question_counter == 4) {
            Toast.makeText(this, "Bitirdiniz tebrikler.", Toast.LENGTH_SHORT).show();
        } else {
            setNextQuestionInfos(view);
        }
    }

    public void goHome(View view) {
        Intent intent = new Intent(this, HomeScreen.class);
        startActivity(intent);
    }

    public void setNextQuestionInfos(View view) {
        if (question_counter == 4) {
            Toast.makeText(this, "Bitirdiniz tebrikler.", Toast.LENGTH_SHORT).show();
            questionPic.setVisibility(View.INVISIBLE);
            questionText.setVisibility(View.INVISIBLE);
            answer1.setVisibility(View.INVISIBLE);
            answer2.setVisibility(View.INVISIBLE);
            answer3.setVisibility(View.INVISIBLE);
            answer4.setVisibility(View.INVISIBLE);
            goBackHome.setText("ANA MENÜ");
            goBackHome.setVisibility(View.VISIBLE);
        } else {
            nextPages.setText("");
            questionPic.setImageResource(questions[question_counter]);
            questionPic.setVisibility(View.VISIBLE);
            questionText.setVisibility(View.VISIBLE);
            answer1.setText(getChoice1(question_counter));
            answer2.setText(getChoice2(question_counter));
            answer3.setText(getChoice3(question_counter));
            answer4.setText(getChoice4(question_counter));

            trueAnswer = getCorrectAnswer(question_counter);
            question_counter++;
        }
    }
}
