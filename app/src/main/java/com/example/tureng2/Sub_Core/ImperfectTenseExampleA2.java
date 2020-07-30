package com.example.tureng2.Sub_Core;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.example.tureng2.Core.HomeScreen;
import com.example.tureng2.Core.LayoutManager;
import com.example.tureng2.R;


public class ImperfectTenseExampleA2 extends Fragment {

    private BootstrapButton btn_nextInfos,btn_sampleSentence;
    private TextView a1;
    private ImageView a2;
    private String[] sampleSentence = {"Eskiden bayramlarda aile ziyaretlerine gidiyorduk. Şimdi tatile gidiyoruz.",
    "Onunla aynı şirkette çalışmıyor muydun ?","Önüne bak! Az kalsın düşüyordun."};
    private LayoutManager lm;
    private int btnChoose = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_imperfect_tense,container,false);

        try {
            lm = new LayoutManager(getContext());

            btn_nextInfos = view.findViewById(R.id.btn_showInfos);
            btn_sampleSentence = view.findViewById(R.id.btn_sampleSentence);

            a1 = view.findViewById(R.id.infoHead);
            a2 = view.findViewById(R.id.imperfect_image_info);



            btn_nextInfos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(btnChoose == 0)
                    {
                        lm.setInfoTextView(sampleSentence[0],39,49,btn_sampleSentence);
                        a1.setVisibility(View.GONE);
                        a2.setVisibility(View.GONE);
                        btnChoose++;
                    }
                    else if(btnChoose == 1)
                    {
                        lm.setInfoTextView(sampleSentence[1],21,41,btn_sampleSentence);
                        btnChoose++;
                    }
                    else if(btnChoose == 2)
                    {
                        lm.setInfoTextView(sampleSentence[2],22,35,btn_sampleSentence);
                        btn_nextInfos.setText("Ana Menü");
                        btnChoose++;
                    }
                    else if(btnChoose == 3)
                    {
                        Intent intent = new Intent(view.getContext(), HomeScreen.class);
                        startActivity(intent);
                    }
                }
            });
        }
        catch (Exception e)
        {
            Log.e("SubCore/ImperfectA2","OnCreate Exception", e);
        }
        return view;
    }
}
