package com.example.tureng2.Sub_Core;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.example.tureng2.Core.HomeScreen;
import com.example.tureng2.R;

public class AdverbVerbB1 extends Fragment {

    private String[] infoTip = {"Annesinin yanına koşarak gitti.","Türkçeyi, Türk dizilerini seyrederek öğrendim.",
            "Müzik dinleyerek ders çalışıyorum. \n\n Türkçeyi, Türk dizilerini seyrederek öğrendim. \n\n Ekmek yemeyerek kilo verdim.",
    "Bilgisayarın karşısında çalışa çalışa gözlerim ağrıdı.",
    "Piknikte güle oynaya eğlendik."};

    private BootstrapButton btInfo,btNext,btHeadInfo;
    private int btnChoose = 0;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //setInfoTextView(infoTip[0],17,24,btInfo);



    }

    private void setInfoTextView(String getInfo, int start, int end, BootstrapButton bt)
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

        }
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_adverbverb_b1,container,false);


        try {
            btHeadInfo = view.findViewById(R.id.btn_AdverbTip);
            btInfo = view.findViewById(R.id.btn_AdverbTip2);
            btNext =  view.findViewById(R.id.btn_nextInfos);

            //btInfo.setText(sp);

            setInfoTextView(infoTip[0],17,24,btInfo);




            btNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(btnChoose == 0)
                    {
                        setInfoTextView(infoTip[1],29,40,btInfo);
                        btnChoose++;
                    }
                    else if(btnChoose == 1)
                    {
                        btInfo.setText(infoTip[2]);
                        btnChoose++;
                    }
                    else if(btnChoose == 2)
                    {
                        btHeadInfo.setText("fiil + ya        fiil + ya");
                        setInfoTextView(infoTip[3],24,39,btInfo);
                        btnChoose++;
                    }
                    else if(btnChoose == 3)
                    {
                        setInfoTextView(infoTip[4],9,21,btInfo);
                        btNext.setText("Ana Menü");
                        btnChoose++;
                    }
                    else if(btnChoose == 4)
                    {
                        Intent intent = new Intent(view.getContext(), HomeScreen.class);
                        startActivity(intent);
                    }
                }
            });
        }
        catch (Exception e)
        {
            Log.e("SubCore/AdverbB1","OnCreate Exception", e);
        }
        //return super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }
}
