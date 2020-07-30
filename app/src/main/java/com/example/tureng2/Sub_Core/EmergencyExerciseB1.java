package com.example.tureng2.Sub_Core;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.example.tureng2.Core.GlobalAlertDialog;
import com.example.tureng2.Database_Operations.DbOperations;
import com.example.tureng2.R;

public class EmergencyExerciseB1 extends Fragment  {

    private GlobalAlertDialog gb;
    private DbOperations db;
    private BootstrapButton correctA32,correctA5,correctA9,correctA18,correctA22,correctA26;


    @Override
    public void onAttach(@NonNull Activity activity) {
        super.onAttach(activity);
        try {
            gb = new GlobalAlertDialog(activity);
            db = new DbOperations(activity);
        }
        catch (Exception e)
        {
            Log.e("SubCore/EmerNumbers","OnAttach Exception", e);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_emergency_exercise_b1,container,false);


        try {
            correctA5 = view.findViewById(R.id.answer12);
            correctA9 = view.findViewById(R.id.answer18);
            correctA18 = view.findViewById(R.id.answer23);
            correctA22 = view.findViewById(R.id.answer32);
            correctA26 = view.findViewById(R.id.answer36);
            correctA32 = view.findViewById(R.id.answer46);


            correctA5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkAnswers(correctA5);
                }
            });
            correctA9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkAnswers(correctA9);
                }
            });
            correctA18.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkAnswers(correctA18);
                }
            });
            correctA22.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkAnswers(correctA22);
                }
            });
            correctA26.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkAnswers(correctA26);
                }
            });
            correctA32.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkAnswers(correctA32);
                }
            });
        }
        catch (Exception e)
        {
            Log.e("SubCore/EmerNumbers","OnCreate Exception", e);
        }
        return view;
    }

    private void checkAnswers(TextView temp)
    {
        db.increaseScore(10);
        gb.setCorrectTextView(temp);
    }

}
