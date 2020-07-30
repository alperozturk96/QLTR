package com.example.tureng2.Core;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tureng2.Database_Operations.DbOperations;


@SuppressLint("Registered")
public class GlobalAlertDialog extends AppCompatActivity {

    private androidx.appcompat.app.AlertDialog.Builder dialogBuilder;
    private androidx.appcompat.app.AlertDialog alertDialog;
    private Context mContext;
    private DbOperations db;

    public GlobalAlertDialog(Context context)
    {
        this.mContext = context;
    }

    public void controlAnswerandChangeText(int choose, int trueAnswer, TextView temp, Context context, String answer)
    {
        try {
            db = new DbOperations(context);

            if(choose == trueAnswer)
            {
                db.increaseScore(3);
                temp.setText(answer);
            }
            else
            {
                db.wrongAnswer();
                temp.setText(answer);
                temp.setTextSize(16);
                temp.setTextColor(Color.rgb(180,0,0));
            }
        }
        catch (Exception e)
        {
            Log.e("Core/GAD","GAD Exception", e);
        }
    }


    public void controlAnswer(int choose, int trueAnswer,TextView temp,Context context)
    {
        try {
            db = new DbOperations(context);

            if(choose == trueAnswer)
            {
                db.increaseScore(3);
                setCorrectTextView(temp);
            }
            else
            {
                db.wrongAnswer();
                setWrongTextView(temp);
            }
        }
        catch (Exception e)
        {
            Log.e("Core/GAD","GAD Exception", e);
        }
    }

    public void showInfo(View view,String temp,String tempTitle,Context context)
    {
        try {
            dialogBuilder = new androidx.appcompat.app.AlertDialog.Builder(context);
            dialogBuilder.setTitle(tempTitle)
                    .setMessage(temp)
                    .setCancelable(false)
                    .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
            alertDialog = dialogBuilder.create();
            alertDialog.show();
        }
        catch (Exception e)
        {
            Log.e("Core/GAD","GAD Exception", e);
        }
    }

    public void setWrongTextView(TextView temp)
    {
        try {
            temp.setText("❌");
            temp.setTextColor(Color.rgb(180,0,0));
            temp.setTextSize(18);
        }
        catch (Exception e)
        {
            Log.e("Core/GAD","GAD Exception", e);
        }
    }

    public void setCorrectTextView(TextView temp)
    {
        try {
            temp.setText("✓");
            temp.setTextColor(Color.rgb(0,180,0));
            temp.setTextSize(18);
        }
        catch (Exception e)
        {
            Log.e("Core/GAD","GAD Exception", e);
        }
    }
}
