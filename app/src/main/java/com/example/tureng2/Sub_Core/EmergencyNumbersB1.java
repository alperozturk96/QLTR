package com.example.tureng2.Sub_Core;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.example.tureng2.R;


public class EmergencyNumbersB1 extends Fragment {

    private ConstraintLayout emergency_main,emergency_information;
    private ImageView emergencyImage;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_emergencynumbers_example,container,false);

        try {
            BootstrapButton b1 = view.findViewById(R.id.btn_110);
            BootstrapButton b2 = view.findViewById(R.id.btn_112);
            BootstrapButton b3 = view.findViewById(R.id.btn_155);
            BootstrapButton b4 = view.findViewById(R.id.btn_156);
            BootstrapButton b5 = view.findViewById(R.id.btn_186);
            BootstrapButton b6 = view.findViewById(R.id.btn_187);

            emergency_information = view.findViewById(R.id.section_emergencyInfo);
            emergency_main = view.findViewById(R.id.section_emergencyMain);

            final BootstrapButton emergencyInfo = view.findViewById(R.id.btn_infosentence);
            emergencyImage = view.findViewById(R.id.imageInfo);



            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    prepareLayout(emergencyImage,emergencyInfo,"Alo İtfaiye numarası 110'dur",R.drawable.firedepartman);
                }
            });

            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    prepareLayout(emergencyImage,emergencyInfo,"Ambulans numarası 112'dir.",R.drawable.medic);
                }
            });

            b3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    prepareLayout(emergencyImage,emergencyInfo,"Alo Polis numarası 155'dir.",R.drawable.police);
                }
            });

            b4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    prepareLayout(emergencyImage,emergencyInfo,"Alo Jandarma numarası 156'dır.",R.drawable.soldier);
                }
            });

            b5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    prepareLayout(emergencyImage,emergencyInfo,"Elektrik Arıza numarası 186'dır.",R.drawable.electiricity);
                }
            });

            b6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    prepareLayout(emergencyImage,emergencyInfo,"Gaz kaçağı numarası 187'dir.",R.drawable.gasleak);
                }
            });
        }
        catch (Exception e)
        {
            Log.e("SubCore/EmerNumbers","OnCreate Exception", e);
        }
        return view;
    }

    private void prepareLayout(ImageView emergency, BootstrapButton info, String getInfo, int ImageId)
    {
        try {
            emergency_main.setVisibility(View.GONE);
            emergency_information.setVisibility(View.VISIBLE);

            emergency.setImageResource(ImageId);
            info.setText(getInfo);
        }
        catch (Exception e)
        {
            Log.e("SubCore/EmerNumbers","Prepare Layout Exception", e);
        }
    }
}
