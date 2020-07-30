package com.example.tureng2.Sub_Core;


import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.example.tureng2.Database_Operations.DbOperations;
import com.example.tureng2.R;

public class FillGapsExerciseA2 extends AppCompatActivity {

    private BootstrapEditText answer;
    private TextView questionHeader;
    private DbOperations db;
    private int question_counter = 0;
    private String[] trueAnswers = {"önce", "meden önce", "dikten sonra"};
    private String[] questions = {"1) Hastalıktan..........sağlığın kıymetini bilelim.", "2) Git..........bana haber ver.", "3) Gömleğini ütüle..........giydi."};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fillgaps_a2);

        answer = findViewById(R.id.answerText);
        questionHeader = findViewById(R.id.questionHeader);

        db = new DbOperations(FillGapsExerciseA2.this);
    }

    public void nextQuestionOnClick(View view) {
        if (question_counter == 2) {
            Toast.makeText(this, "Bitirdiniz tebrikler.", Toast.LENGTH_SHORT).show();
        } else {
            question_counter++;
            questionHeader.setText(questions[question_counter]);
        }
    }

    public void sendAnswer(View view) {
        String written_answer = answer.getText().toString();

        if (written_answer.equals(trueAnswers[question_counter])) {
            db.increaseScore(4);
        } else {
            db.wrongAnswer();
        }
    }
}
