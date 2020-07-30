package com.example.tureng2.Sub_Core;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tureng2.Core.GlobalAlertDialog;
import com.example.tureng2.R;

public class FillParagraphGapsExerciseA2 extends AppCompatActivity {

    private TextView a1, a2, a3, a4, a5, a6, a7;
    private AlertDialog.Builder dialogBuilder;
    private AlertDialog alertDialog;
    private GlobalAlertDialog gb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fillgaps_paragraph_a2);

        gb = new GlobalAlertDialog(FillParagraphGapsExerciseA2.this);

        a1 = findViewById(R.id.questionParagraph00);
        a2 = findViewById(R.id.questionParagraph01);
        a3 = findViewById(R.id.questionParagraph02);
        a4 = findViewById(R.id.questionParagraph03);
        a5 = findViewById(R.id.questionParagraph04);
        a6 = findViewById(R.id.questionParagraph05);
        a7 = findViewById(R.id.questionParagraph06);

        dialogBuilder = new AlertDialog.Builder(this);
        alertDialog = dialogBuilder.create();
    }

    public void selectQuestions(View view) {
        try {
            switch (view.getId()) {
                case (R.id.questionParagraph00):
                    showQuestionOfFirstParagraph(1);
                    break;
                case (R.id.questionParagraph01):
                    showQuestionOfFirstParagraph(2);
                    break;
                case (R.id.questionParagraph02):
                    showQuestionOfFirstParagraph(3);
                    break;
                case (R.id.questionParagraph03):
                    showQuestionOfFirstParagraph(4);
                    break;
                case (R.id.questionParagraph04):
                    showQuestionOfSecParagraph(5);
                    break;
                case (R.id.questionParagraph05):
                    showQuestionOfSecParagraph(6);
                    break;
                case (R.id.questionParagraph06):
                    showQuestionOfSecParagraph(7);
                    break;
            }
        } catch (Exception e) {
            Log.e("SubCore/FillGappsA2", "SelectQuestions Exception", e);
        }
    }

    public void showQuestionOfFirstParagraph(int questionNumber) {
        try {
            dialogBuilder.setTitle("Boşluğa uygun gelen kelime hangisidir ?");

            if (questionNumber == 1) {
                final String[] answers = {"Sınavdan sonra", "Kahvaltıdan önce", "Dersten önce", "Öğleden sonra"};
                dialogBuilder.setItems(answers, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String temp = "Semih sabah 6:30’da yataktan kalktı. " + answers[which] + " elini yüzünü yıkadı.";
                        gb.controlAnswerandChangeText(which, 1, a1, FillParagraphGapsExerciseA2.this, temp);
                    }
                });
            } else if (questionNumber == 2) {
                final String[] answers = {"Sınavdan sonra", "Kahvaltıdan önce", "Kahvaltıdan sonra", "Dersten önce"};
                dialogBuilder.setItems(answers, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String temp = "Sonra ailesi ile birlikte kahvaltı etti. " + answers[which] + " dişlerini fırçaladı, giyindi ve evden çıktı.";
                        gb.controlAnswerandChangeText(which, 2, a2, FillParagraphGapsExerciseA2.this, temp);
                    }
                });
            } else if (questionNumber == 3) {
                final String[] answers = {"sınavdan sonra", "dersten önce", "dersten sonra", "bekledikten sonra"};
                dialogBuilder.setItems(answers, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String temp = "Durakta on beş dakika" + answers[which] + " otobüs geldi.";
                        gb.controlAnswerandChangeText(which, 3, a3, FillParagraphGapsExerciseA2.this, temp);
                    }
                });
            } else if (questionNumber == 4) {
                final String[] answers = {"sınavdan sonra", "yedikten sonra", "dersten sonra", "dersten önce"};
                dialogBuilder.setItems(answers, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String temp = "Yol yaklaşık 35 dakika sürdü. Okulun önünde indi " + answers[which] + " arkadaşlarıyla birlikte kantine gitti, sohbet etti.";
                        gb.controlAnswerandChangeText(which, 3, a4, FillParagraphGapsExerciseA2.this, temp);
                    }
                });
            }
            dialogBuilder.show();
        } catch (Exception e) {
            Log.e("SubCore/FillGappsA2", "ShowQuestionOfFirstParagraph Exception", e);
        }
    }

    public void showQuestionOfSecParagraph(int questionNumber) {
        try {
            dialogBuilder.setTitle("Boşluğa uygun gelen kelime hangisidir ?");

            if (questionNumber == 5) {
                final String[] answers = {"öğleden sonra", "öğleden önce", "dersten sonra", "dersten önce"};
                dialogBuilder.setItems(answers, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String temp = "Saat 9:30’da ders başladı.  " + answers[which] + " arkadaşlarıyle biraz oturduktan sonra 3 saat ders işlediler. Sınavı vardı ve bu yüzden biraz heyecalıydı.";
                        gb.controlAnswerandChangeText(which, 3, a5, FillParagraphGapsExerciseA2.this, temp);
                    }
                });
            } else if (questionNumber == 6) {
                final String[] answers = {"sınavdan önce", "yedikten sonra", "sınavdan sonra", "dersten önce"};
                dialogBuilder.setItems(answers, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String temp = "  " + answers[which] + " eve geldi. Biraz dinlendi, ödevlerini yaptı.";
                        gb.controlAnswerandChangeText(which, 2, a6, FillParagraphGapsExerciseA2.this, temp);
                    }
                });
            } else if (questionNumber == 7) {
                final String[] answers = {"gelmeden önce", "yaptıktan önce", "yaptıktan sonra", "gelmeden sonra"};
                dialogBuilder.setItems(answers, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String temp = "Ödevlerini  " + answers[which] + " dışarıya çıktı. Arkadaşlarıyla futbol oynadı.";
                        gb.controlAnswerandChangeText(which, 2, a7, FillParagraphGapsExerciseA2.this, temp);
                    }
                });
            }
            dialogBuilder.show();
        } catch (Exception e) {
            Log.e("SubCore/FillGappsA2", "ShowQuestionOfSecParagraph Exception", e);
        }
    }
}
