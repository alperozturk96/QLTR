package com.example.tureng2.Sub_Core;

import android.content.Context;
import android.content.Intent;
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
import com.beardedhen.androidbootstrap.BootstrapLabel;
import com.example.tureng2.Core.HomeScreen;
import com.example.tureng2.MediaPlayer.MPAfragment;
import com.example.tureng2.R;

import static android.view.View.GONE;

public class TimeCasesListeningA2 extends Fragment {

    private BootstrapLabel header;
    private MPAfragment mp;
    private TextView infolistening_timecases;
    private BootstrapButton btnNext,btnListen;

    private boolean firstListening = false;
    private int sentenceNumber = 0;

    private String[] sentences = {"Şimdiki Zaman (-yor): \n\n gel-(i)-yor-um \n\n gel-(i)-yor-sun \n\n gel-(i)-yor \n\n gel-(i)-yor-uz \n\n gel-(i)-yor-sunuz \n\n gel-(i)-yor-lar",
            "Gelecek Zaman (-ecek, -acak): \n\n gel-eceğ-im \n\n gel-ecek-sin \n\n gel-ecek \n\n gel-eceğ-iz \n\n gel-ecek-siniz \n\n gel-ecek-ler",
            "Di’li Geçmiş Zaman (Görülen / Bilinen Geçmiş Zaman) (-di, -dı, -du, -dü, -ti, -tı, -tu, -tü) : \n\n gel-di-m \n\n gel-di-n \n\n gel-di \n\n gel-di-k \n\n gel-di-niz \n\n gel-di-ler",
            "Miş’li Geçmiş Zaman (Öğrenilen / Duyulan Geçmiş Zaman) (-miş, -mış, -muş, -müş) : \n\n gel-miş-im \n\n gel-miş-sin \n\n gel-miş \n\n gel-miş-iz \n\n gel-miş-siniz \n\n gel-miş-ler"};

    private String[] listeningAdressList = {"https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/TimeCases%2Fgeniszaman.wav?alt=media&token=bc2af31a-c2e2-44ea-9733-21bf334faca6",
    "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/TimeCases%2Fsimdikizaman.wav?alt=media&token=e033c7d0-e93f-4927-a544-41c594ceb18d",
    "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/TimeCases%2Fgelecekzaman.wav?alt=media&token=fee6a9fd-63af-4190-af13-4d4a40f0d0a6",
    "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/TimeCases%2Fdi-ligecmiszaman.wav?alt=media&token=1077ea2d-25df-4337-84a3-055f12453dee",
    "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/TimeCases%2Fmis-ligecmiszaman.wav?alt=media&token=ab1a12b9-b6d3-4959-a8e3-6d368be46536"};


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            mp = new MPAfragment(context);
        }
        catch (Exception e)
        {
            Log.e("SubCore/TimeCasesA2","OnAttach Exception", e);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_timecases_listening_a2,container,false);

        try {
            header = view.findViewById(R.id.header_timecases);
            infolistening_timecases = view.findViewById(R.id.info_listening_timecases);
            btnNext = view.findViewById(R.id.btnNext_timecases);
            btnListen = view.findViewById(R.id.btnListen_timecases);

            btnNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(sentenceNumber == -1)
                    {
                        setNextInfo(infolistening_timecases,sentences[0]);
                    }
                    else if(sentenceNumber == 0)
                    {
                        setNextInfo(infolistening_timecases,sentences[1]);
                    }
                    else if(sentenceNumber == 1)
                    {
                        setNextInfo(infolistening_timecases,sentences[2]);
                    }
                    else if(sentenceNumber == 2)
                    {
                        setNextInfo(infolistening_timecases,sentences[3]);
                    }
                    else if(sentenceNumber == 3)
                    {
                        btnNext.setText("Ana Menü");
                        btnListen.setVisibility(GONE);
                        infolistening_timecases.setVisibility(GONE);
                        header.setVisibility(GONE);
                        sentenceNumber++;
                    }
                    else if(sentenceNumber == 4)
                    {
                        Intent intent = new Intent(view.getContext(), HomeScreen.class);
                        startActivity(intent);
                    }

                }
            });


            btnListen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(!firstListening)
                    {
                        mp.mpStartWithContext(listeningAdressList[0], getActivity());
                        firstListening = true;
                    }
                    else if(sentenceNumber == 0)
                    {
                        mp.mpStartWithContext(listeningAdressList[1], getActivity());
                    }
                    else if(sentenceNumber == 1)
                    {
                        mp.mpStartWithContext(listeningAdressList[2], getActivity());
                    }
                    else if(sentenceNumber == 2)
                    {
                        mp.mpStartWithContext(listeningAdressList[3], getActivity());
                    }
                    else if(sentenceNumber == 3)
                    {
                        mp.mpStartWithContext(listeningAdressList[4], getActivity());
                    }
                }
            });
        }
        catch (Exception e)
        {
            Log.e("SubCore/TimeCasesA2","OnCreate Exception", e);
        }
        return view;
    }

    private void setNextInfo(TextView tv,String nextInfo)
    {
        try {
            tv.setText(nextInfo);
            sentenceNumber++;
        }
        catch (Exception e)
        {
            Log.e("SubCore/TimeCasesA2","SetNextInfo Exception", e);
        }
    }
}
