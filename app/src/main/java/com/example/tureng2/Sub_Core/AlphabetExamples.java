package com.example.tureng2.Sub_Core;


import android.os.Bundle;
import android.view.View;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.TypefaceProvider;
import com.example.tureng2.MediaPlayer.MPAs;
import com.example.tureng2.R;

public class AlphabetExamples extends MPAs {

    private BootstrapButton refresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabet_example);

        TypefaceProvider.registerDefaultIconSets();

        refresh = findViewById(R.id.refresh);

        if (isConnected()) {
            refresh.setVisibility(View.INVISIBLE);
            listSampleWords();
        }
    }

    public void listSampleWords() {
        final String[] addressList = {"https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Sample_words%2Faraba.wav?alt=media&token=d4a6f47d-0fd2-40d5-9df6-0b764f431f71",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Sample_words%2Fbalik.wav?alt=media&token=6186f4a5-f2ef-4555-84d9-a6009fbbe74e",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Sample_words%2Fcam.wav?alt=media&token=73b0f845-f363-4bf8-b651-3f0eb6896201",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Sample_words%2F%C3%A7anta.wav?alt=media&token=ab565c5f-9ce8-440c-9101-208e39fe4d55",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Sample_words%2Fdede.wav?alt=media&token=4d5e3031-9184-4894-9692-af4682d96bc4",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Sample_words%2Fekmek.wav?alt=media&token=79b227c3-d65e-450d-84d1-1e93364e36de",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Sample_words%2Ffil.wav?alt=media&token=6f5b74f8-f984-4515-a0bd-c474c3039fc8",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Sample_words%2Fg%C3%B6z.wav?alt=media&token=077db6e9-9f6a-4c33-aebc-81da723d8e89",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Sample_words%2Fa%C4%9Fa%C3%A7.wav?alt=media&token=673b20ec-cfcb-4605-8ebc-e284054f0526",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Sample_words%2Fhoroz.wav?alt=media&token=5dabc691-782a-4331-84a1-3f28fa269c2d",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Sample_words%2F%C4%B1%C5%9F%C4%B1k.wav?alt=media&token=bdc852f0-5bae-443f-9a6f-d86b2456a72e",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Sample_words%2Finek.wav?alt=media&token=6bed9f51-034d-4153-aeae-8f05fb784e52",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Sample_words%2Fjeton.wav?alt=media&token=33c61f16-4358-4143-945e-1c42ecd03802",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Sample_words%2Fkalem.wav?alt=media&token=b0282410-3855-4a28-8f9f-c7b700ab7eb3",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Sample_words%2Flimon.wav?alt=media&token=4a9c5c2d-477c-4ab3-b265-0e3c2b1aafa3",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Sample_words%2Fmasa.wav?alt=media&token=19330101-8bfd-44d8-8628-8014ff9669f9",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Sample_words%2Fnokta.wav?alt=media&token=b78135a8-c61b-485e-84af-819422bbb0a3",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Sample_words%2Fokul.wav?alt=media&token=a10f1300-55ae-483a-88f8-3a5995cb9baf",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Sample_words%2F%C3%B6rdek.wav?alt=media&token=29f0fad2-cf05-44ba-a629-41575993958d",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Sample_words%2Fpara.wav?alt=media&token=9012a506-0c6a-4e17-91be-a0423118304d",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Sample_words%2Fradyo.wav?alt=media&token=7a9d2c6a-d9b7-4569-9449-96666796ad69",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Sample_words%2Fs%C3%BCt.wav?alt=media&token=407e22dc-5dce-43a1-9a32-3f48b573b533",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Sample_words%2F%C5%9Fi%C5%9Fe.wav?alt=media&token=7efa0810-977b-45ff-a3c2-5b6ea9cc5e60",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Sample_words%2Ftelefon.wav?alt=media&token=65bf0688-67de-4a8a-a5b7-3174f1dd5081",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Sample_words%2Fu%C3%A7ak.wav?alt=media&token=0259648b-df5d-4064-bad0-b7d212e30afe",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Sample_words%2F%C3%BCz%C3%BCm.wav?alt=media&token=6ea1d331-f999-4495-b3c5-5752a8faf0b2",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Sample_words%2Fvazo.wav?alt=media&token=a0bdcbed-149a-4f87-8a4f-a980d9dcc4e5",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Sample_words%2Fy%C4%B1lan.wav?alt=media&token=9908c493-b2a4-43a3-8245-4e5f155cc772",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/Sample_words%2Fzil.wav?alt=media&token=e61cea43-fbbb-44de-8cea-6d3e421316f3"};

        String[] headerList = {"Araba", "Balık", "Cam", "Çanta", "Dede", "Ekmek", "Fil", "Göz", "Ağaç", "Horoz", "Işık", "İnek", "Jeton", "Kalem", "Limon", "Masa", "Nokta", "Okul", "Ördek",
                "Para", "Radyo", "Süt", "Şişe", "Telefon", "Uçak", "Üzüm", "Vazo", "Yılan", "Zil"};

        createListView(R.id.samplewordslist, addressList, headerList);
    }
}
