package com.example.tureng2.Sub_Core;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
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

public class TrueFalseExercise_B1 extends Fragment {

    private BootstrapButton a1, a2, a3, a4, a5;
    private androidx.appcompat.app.AlertDialog.Builder dialogBuilder;
    private GlobalAlertDialog gad;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        new DbOperations(Objects.requireNonNull(getActivity()));
        gad = new GlobalAlertDialog(getActivity());
        dialogBuilder = new AlertDialog.Builder(getActivity());
        dialogBuilder.create();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_truefalse_exercise_b1, container, false);

        a1 = view.findViewById(R.id.answer1);
        a2 = view.findViewById(R.id.answer2);
        a3 = view.findViewById(R.id.answer3);
        a4 = view.findViewById(R.id.answer4);
        a5 = view.findViewById(R.id.answer5);


        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswers(1);
            }
        });

        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswers(2);
            }
        });
        a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswers(3);
            }
        });
        a4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswers(4);
            }
        });
        a5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswers(5);
            }
        });

        return view;
    }


    private void checkAnswers(int questionNumber) {
        dialogBuilder.setTitle("Yazılan ifade doğru mu yanlış mı ?");
        String[] answers = {"Doğru", "Yanlış"};

        if (questionNumber == 1) {
            dialogBuilder.setItems(answers, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    gad.controlAnswer(which, 0, a1, getActivity());
                }
            });
        } else if (questionNumber == 2) {
            dialogBuilder.setItems(answers, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    gad.controlAnswer(which, 0, a2, getActivity());
                }
            });
        } else if (questionNumber == 3) {
            dialogBuilder.setItems(answers, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    gad.controlAnswer(which, 0, a3, getActivity());
                }
            });
        } else if (questionNumber == 4) {
            dialogBuilder.setItems(answers, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    gad.controlAnswer(which, 1, a4, getActivity());
                }
            });
        } else if (questionNumber == 5) {
            dialogBuilder.setItems(answers, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    gad.controlAnswer(which, 1, a5, getActivity());
                }
            });
        }
        dialogBuilder.show();
    }
}
