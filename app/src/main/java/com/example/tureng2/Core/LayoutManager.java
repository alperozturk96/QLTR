package com.example.tureng2.Core;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.beardedhen.androidbootstrap.BootstrapButton;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

@SuppressLint("Registered")
public class LayoutManager extends AppCompatActivity {

    private Context context;

    public LayoutManager(@NonNull Context context)
    {
        this.context = context;
    }

    public void setInfoTextView(String getInfo, int start, int end, BootstrapButton bt)
    {
        try {
            SpannableString sp = new SpannableString(getInfo);

            //ForegroundColorSpan fcsBlue = new ForegroundColorSpan(Color.BLUE);
            ForegroundColorSpan fcsRed = new ForegroundColorSpan(Color.BLACK);
            //ForegroundColorSpan fcsWhite = new ForegroundColorSpan(Color.WHITE);

            //BackgroundColorSpan bcsWhite = new BackgroundColorSpan(Color.RED);

            StyleSpan boldSpan = new StyleSpan(Typeface.BOLD);
            RelativeSizeSpan largeSizeText = new RelativeSizeSpan(1.3f);


            sp.setSpan(fcsRed,start,end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            // sp.setSpan(bcsWhite,17,24,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            sp.setSpan(boldSpan,start,end,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            sp.setSpan(largeSizeText,start,end,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

            bt.setText(sp);
        }
        catch (Exception e)
        {
            Log.e("Core/LayoutManager","Set Info TextView Exception", e);
        }
    }

    public void hideOrShowLayout(int id, boolean choose)
    {
        try {
            ConstraintLayout temp = ((Activity)context).findViewById(id);

            if(!choose)
            {
                temp.setVisibility(GONE);
            }
            else
            {
                temp.setVisibility(VISIBLE);
            }
        }
        catch (Exception e)
        {
            Log.e("Core/LayoutManager","HideOrShowLayout Exception", e);
        }
    }
}
