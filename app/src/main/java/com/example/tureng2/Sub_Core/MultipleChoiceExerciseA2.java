package com.example.tureng2.Sub_Core;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapWell;
import com.beardedhen.androidbootstrap.TypefaceProvider;
import com.example.tureng2.Core.HomeScreen;
import com.example.tureng2.Database_Operations.DbOperations;
import com.example.tureng2.R;

public class MultipleChoiceExerciseA2 extends AppCompatActivity {

    private BootstrapButton answer1, answer2, answer3, answer4, nextPages, goBackHome;
    private TextView questionText;
    private DbOperations db = new DbOperations(MultipleChoiceExerciseA2.this);
    private BootstrapWell temp_question_text;

    private int question_counter = 0;
    private String[] questions = {
            "Cümleyi uygun seçenek ile tamamlayınız. Ali, eve gel............ markete uğradı.",
            "Cümleyi uygun seçenek ile tamamlayınız. Kapıyı kapat............ içeriden kilitledi.",
            "Paragraftaki boşkukları uygun ifadelerle doldurunuz. Kerim, okuldan çıktı, otobüs durağına yürüdü. Otobüse bin.... ...... büfeden otobüs bileti aldı. Durakta 240 numaralı otobüsü beklemeye başladı. On dakika sonra otobüs geldi ve Kerim otobüse bindi. Boş bir koltuğa oturdu. Yaşlı bir adam ayaktaydı. Kerim, yaşlı adama seslendi ve yerini ona verdi. Yaşlı adam Kerim'in yerine otur..... ........ Kerim'e teşekkür etti. Kerim, iki durak sonra otobüsten indi. Tabii, in..... ........ uyarı düğmesine bastı.",
            "Hangi cümlenin anlamı bozuktur ?",
            "Cümleyi uygun ekle tamamlayınız. İki yıl Ankara'da oku....."
    };
    private String[][] choices = {
            {"A) -dikten sonra", "B)-madan önce", "C) -meden önce", "D) -dikten sonra"},
            {"A) -dıktan sonra", "B) -dikten sonra", "C) -tikten sonra", "D) -tıktan sonra"},
            {"A) -madan önce/ -dıktan sonra/ -meden önce", "B) -meden önce/ -duktan sonra/ -meden önce", "C) -meden önce/ -tuktan sonra/ -meden önce ", "D) -meden önce/ -duktan sonra/ -dikten sonra"},
            {"A) Okula gitmeden önce kırtasiyeye uğradı ve kalem aldı.", "B) Biraz televizyon izledikten sonra yattı.", "C) Eve gelmeden önce komşusuna uğradı.", "D) Eve girdikten sonra komşusuna uğradı."},
            {"A) -mış", "B) -muş", "C) -miş", "D) -müş"}
    };

    private String[] correctAnswers = {"C) -meden önce", "D) -tıktan sonra", "B) -meden önce/ -duktan sonra/ -meden önce", "D) Eve girdikten sonra komşusuna uğradı.", "B) -muş"};
    private String trueAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplechoice_exercise_a2);

        TypefaceProvider.registerDefaultIconSets();

        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);
        answer4 = findViewById(R.id.answer4);
        nextPages = findViewById(R.id.nextPage);
        goBackHome = findViewById(R.id.backHome);
        temp_question_text = findViewById(R.id.question);
        questionText = findViewById(R.id.question11);

        temp_question_text.setVisibility(View.INVISIBLE);
        questionText.setVisibility(View.INVISIBLE);
        goBackHome.setVisibility(View.INVISIBLE);

        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answer1.getText() == trueAnswer) {
                    db.increaseScore(5);
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
                    db.increaseScore(5);
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
                    db.increaseScore(5);
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
                    db.increaseScore(5);
                    setNextQuestionInfos(view);
                } else {
                    db.wrongAnswer();
                    setNextQuestionInfos(view);
                }
            }
        });
    }

    public String getQuestion(int a) {
        return questions[a];
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
        if (question_counter == 5) {
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
        if (question_counter == 5) {
            Toast.makeText(this, "Bitirdiniz tebrikler.", Toast.LENGTH_SHORT).show();
            goBackHome.setText("ANA MENÜ");
            goBackHome.setVisibility(View.VISIBLE);
            answer1.setVisibility(View.INVISIBLE);
            answer2.setVisibility(View.INVISIBLE);
            answer3.setVisibility(View.INVISIBLE);
            answer4.setVisibility(View.INVISIBLE);
            temp_question_text.setVisibility(View.INVISIBLE);
            questionText.setVisibility(View.INVISIBLE);
        } else {
            nextPages.setText("");
            questionText.setVisibility(View.VISIBLE);
            temp_question_text.setVisibility(View.VISIBLE);

            questionText.setText(getQuestion(question_counter));
            answer1.setText(getChoice1(question_counter));
            answer2.setText(getChoice2(question_counter));
            answer3.setText(getChoice3(question_counter));
            answer4.setText(getChoice4(question_counter));

            trueAnswer = getCorrectAnswer(question_counter);
            question_counter++;
        }

    }
}
