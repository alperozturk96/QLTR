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

public class NumberMatcingExerciseA1 extends Fragment {

    private BootstrapButton number1, number2, number3, number4, number5, number6, number7, number8, number9;
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
        View view = inflater.inflate(R.layout.fragment_numbersmatching_exercise_a1, container, false);

        number1 = view.findViewById(R.id.btn_1);
        number2 = view.findViewById(R.id.btn_2);
        number3 = view.findViewById(R.id.btn_3);
        number4 = view.findViewById(R.id.btn_4);
        number5 = view.findViewById(R.id.btn_5);
        number6 = view.findViewById(R.id.btn_6);
        number7 = view.findViewById(R.id.btn_7);
        number8 = view.findViewById(R.id.btn_8);
        number9 = view.findViewById(R.id.btn_9);

        number1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswers(1);
            }
        });
        number2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswers(2);
            }
        });
        number3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswers(3);
            }
        });
        number4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswers(4);
            }
        });
        number5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswers(5);
            }
        });
        number6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswers(6);
            }
        });
        number7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswers(7);
            }
        });
        number8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswers(8);
            }
        });
        number9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswers(9);
            }
        });

        return view;
    }

    private void checkAnswers(int questionNumber) {
        dialogBuilder.setTitle("Aşağıdakilerden hangisi doğru yazımıdır ?");
        if (questionNumber == 1) {
            String[] answers = {"İki", "Dört", "Bir", "Üç"};
            dialogBuilder.setItems(answers, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    gad.controlAnswer(which, 2, number1, getActivity());
                }
            });
        } else if (questionNumber == 2) {
            String[] answers = {"Altı", "Dört", "İki", "Üç"};
            dialogBuilder.setItems(answers, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    gad.controlAnswer(which, 2, number2, getActivity());
                }
            });
        } else if (questionNumber == 3) {
            String[] answers = {"Beş", "Dört", "Sekiz", "Üç"};
            dialogBuilder.setItems(answers, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    gad.controlAnswer(which, 3, number3, getActivity());
                }
            });
        } else if (questionNumber == 4) {
            String[] answers = {"Beş", "Dört", "Sekiz", "Üç"};
            dialogBuilder.setItems(answers, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    gad.controlAnswer(which, 1, number4, getActivity());
                }
            });
        } else if (questionNumber == 5) {
            String[] answers = {"Beş", "Altı", "Sekiz", "Yedi"};
            dialogBuilder.setItems(answers, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    gad.controlAnswer(which, 0, number5, getActivity());
                }
            });
        } else if (questionNumber == 6) {
            String[] answers = {"Dokuz", "Altı", "Sekiz", "Yedi"};
            dialogBuilder.setItems(answers, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    gad.controlAnswer(which, 1, number6, getActivity());
                }
            });
        } else if (questionNumber == 7) {
            String[] answers = {"Üç", "Altı", "On", "Yedi"};
            dialogBuilder.setItems(answers, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    gad.controlAnswer(which, 3, number7, getActivity());
                }
            });
        } else if (questionNumber == 8) {
            String[] answers = {"Sekiz", "Altı", "On", "Yedi"};
            dialogBuilder.setItems(answers, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    gad.controlAnswer(which, 0, number8, getActivity());
                }
            });
        } else if (questionNumber == 9) {
            String[] answers = {"Onbir", "Bir", "Dokuz", "Yedi"};
            dialogBuilder.setItems(answers, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    gad.controlAnswer(which, 2, number9, getActivity());
                }
            });
        }
        dialogBuilder.show();
    }
}
