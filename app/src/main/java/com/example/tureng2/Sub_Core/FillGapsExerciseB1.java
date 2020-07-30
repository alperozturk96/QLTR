package com.example.tureng2.Sub_Core;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.TypefaceProvider;
import com.example.tureng2.R;

public class FillGapsExerciseB1 extends Fragment {

    private EditText a1, a2, a3, a4;
    private BootstrapButton results;
    private ConstraintLayout sectionFillGaps;
    private TextView allAnswer;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fillgaps_exercise_b1, container, false);

        TypefaceProvider.registerDefaultIconSets();

        allAnswer = view.findViewById(R.id.allAnswersResult);

        a1 = view.findViewById(R.id.answer1);
        a2 = view.findViewById(R.id.answer2);
        a3 = view.findViewById(R.id.answer3);
        a4 = view.findViewById(R.id.answer4);

        results = view.findViewById(R.id.show_results);

        sectionFillGaps = view.findViewById(R.id.mainSectionCS);


        results.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sectionFillGaps.setVisibility(View.GONE);

                String getALL = "1) Korkuyordum. Çünkü " + a1.getText().toString() + "\n" + "2) Mutluydum. Çünkü " + a2.getText().toString() + "\n" +
                        "3) Endişeliydim. Çünkü " + a3.getText().toString() + "\n" + "4) Sinirliydim. Çünkü  " + a4.getText().toString();

                allAnswer.setText(getALL);

                allAnswer.setVisibility(View.VISIBLE);
            }
        });

        return view;
    }
}
