package com.example.tureng2.Sub_Core;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.example.tureng2.Database_Operations.DbOperations;
import com.example.tureng2.R;

public class BodyPartsExerciseA1 extends AppCompatActivity {

    private BootstrapEditText answer;
    private ImageView question;
    private int question_counter = 0;
    private int[] questionPics = {R.drawable.brain, R.drawable.eyes, R.drawable.hand, R.drawable.lungs};
    private String[] trueAnswers = {"Beyin", "Göz", "El", "Akciğer"};
    private String[] low_trueAnswers = {"beyin", "göz", "el", "akciğer"};
    private DbOperations db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bodyparts_exercise);

        answer = findViewById(R.id.answerBody);
        question = findViewById(R.id.brainQ);
        db = new DbOperations(BodyPartsExerciseA1.this);
    }

    public void answerButtonOnClick(View view) {
        try {
            String written_answer = answer.getText().toString();
            if (written_answer.equals(trueAnswers[question_counter]) || written_answer.equals(low_trueAnswers[question_counter])) {
                db.increaseScore(4);
            } else {
                db.wrongAnswer();
            }
        } catch (Exception e) {
            Log.e("SubCore/BodyParts", "AnswerButton Exception", e);
        }
    }

    public void nextQuestionOnClick(View view) {
        try {
            if (question_counter == 3) {
                Toast.makeText(this, "Bitirdiniz tebrikler.", Toast.LENGTH_SHORT).show();
            } else {
                question_counter++;
                question.setImageResource(questionPics[question_counter]);
            }
        } catch (Exception e) {
            Log.e("SubCore/BodyParts", "NextQuestionOnClick Exception", e);
        }
    }
}
