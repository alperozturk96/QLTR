package com.example.tureng2.Sub_Core;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.example.tureng2.Core.GlobalAlertDialog;
import com.example.tureng2.Database_Operations.DbOperations;
import com.example.tureng2.R;

import java.util.Objects;

public class AdverbExerciseB1 extends Fragment {

    private BootstrapButton s1, s2, s3, s4, s5;

    private androidx.appcompat.app.AlertDialog.Builder dialogBuilder;
    private GlobalAlertDialog gad;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            new DbOperations(Objects.requireNonNull(getActivity()));
            gad = new GlobalAlertDialog(getActivity());
            dialogBuilder = new AlertDialog.Builder(getActivity());
            dialogBuilder.create();
        } catch (Exception e) {
            Log.e("SubCore/AdverbB1", "OnCreate Exception", e);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_adverb_exercise_b1, container, false);

        s1 = view.findViewById(R.id.sentence1);
        s2 = view.findViewById(R.id.sentence2);
        s3 = view.findViewById(R.id.sentence3);
        s4 = view.findViewById(R.id.sentence4);
        s5 = view.findViewById(R.id.sentence5);

        s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswers(1);
            }
        });
        s2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswers(2);
            }
        });
        s3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswers(3);
            }
        });
        s4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswers(4);
            }
        });
        s5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswers(5);
            }
        });

        return view;
    }


    private void checkAnswers(int questionNumber) {
        dialogBuilder.setTitle("Boşluklara uygun gelen fiileri seçin.");


        if (questionNumber == 1) {
            final String[] answers = {"etmeden", "dinlemeden", "vermeden", "görmeden", "almadan"};
            dialogBuilder.setItems(answers, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String temp = "1.Öğretmen eski konuyu tekrar " + answers[which] + " derse başladı.";
                    gad.controlAnswerandChangeText(which, 0, s1, getActivity(), temp);
                }
            });
        } else if (questionNumber == 2) {
            final String[] answers = {"izlemeden", "bakmadan", "duymadan", "bakarak", "görerek"};
            dialogBuilder.setItems(answers, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String temp = "2.Yemek kitabına " + answers[which] + " lezzetli yemekler yapıyorum.";
                    gad.controlAnswerandChangeText(which, 1, s2, getActivity(), temp);
                }
            });
        } else if (questionNumber == 3) {
            final String[] answers = {"dinlemeden", "görerek", "alarak", "dinleyerek", "yaparak"};
            dialogBuilder.setItems(answers, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String temp = "3.Müzik " + answers[which] + " spor yaptı.";
                    gad.controlAnswerandChangeText(which, 3, s3, getActivity(), temp);
                }
            });
        } else if (questionNumber == 4) {
            final String[] answers = {"etmeden", "bakarak", "yürümeden", "susmadan", "konuşmadan"};
            dialogBuilder.setItems(answers, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String temp = "4. Adam bir hata yaptı ve " + answers[which] + " oradan ayrıldı.";
                    gad.controlAnswerandChangeText(which, 4, s4, getActivity(), temp);
                }
            });
        } else if (questionNumber == 5) {
            final String[] answers = {"ederek", "görerek", "yaparak", "görmeden", "almadan"};
            dialogBuilder.setItems(answers, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String temp = "5. Güzel günleri hayal " + answers[which] + " uyudu.";
                    gad.controlAnswerandChangeText(which, 0, s5, getActivity(), temp);
                }
            });
        }

        dialogBuilder.show();
    }
}
