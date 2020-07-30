package com.example.tureng2.Sub_Core;


import android.os.Bundle;
import android.view.View;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.TypefaceProvider;
import com.example.tureng2.MediaPlayer.MPAs;
import com.example.tureng2.R;


public class DailyTalks extends MPAs {

    private BootstrapButton refresh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dailytalks);

        TypefaceProvider.registerDefaultIconSets();

        refresh = findViewById(R.id.refresh);

        if (isConnected()) {
            refresh.setVisibility(View.INVISIBLE);
            listDailyTalks();
        }
    }

    public void listDailyTalks() {
        String[] addressList = {"https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/DailyTalks%2Fwhatsnew.wav?alt=media&token=3715cd64-0ba4-445c-aa9c-924739905bd5",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/DailyTalks%2FKacTl.wav?alt=media&token=bf8e870e-9e4c-4fee-b8f3-7fcee0844478",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/DailyTalks%2FMerhaba.wav?alt=media&token=7a20fb89-b26e-4466-9a3e-fb0489e48328",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/DailyTalks%2FTanistigima.wav?alt=media&token=9111ea6f-9ae8-4f94-8119-a01fc9c8ff50",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/DailyTalks%2Fkadikoy.wav?alt=media&token=65be5452-01c6-4b71-be0c-20432177f8b3",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/DailyTalks%2FFine%2Chau.wav?alt=media&token=63f5ba4b-e221-4b10-a8dc-50673bf7af63",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/DailyTalks%2Fcanipaywithcard.wav?alt=media&token=2c30b7e9-314b-4bc0-a56d-826459d9e939",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/DailyTalks%2Fwhereisbank.wav?alt=media&token=d9cc6175-ebb1-461e-a4d9-fb2993066ef7",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/DailyTalks%2Fwhereisbusstop.wav?alt=media&token=d884bb3b-a843-4eec-a673-364a09048373",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/DailyTalks%2Fwherecanifinftaxi.wav?alt=media&token=def7425c-554e-4b67-8652-303de414c8cd",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/DailyTalks%2Fwhereisrestaurant.wav?alt=media&token=d81be5e6-af79-4f86-8d4e-e2286315fd13",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/DailyTalks%2Fhowdoaccessnet.wav?alt=media&token=a75adc59-68be-4159-aaa1-b75bcfae2818",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/DailyTalks%2Fwhereishotel.wav?alt=media&token=18b4b187-26ca-43dd-ae2e-0cfde99a42cb",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/DailyTalks%2Fwhatairlaineiiamfly.wav?alt=media&token=0004c50f-64b5-44e2-8f78-fe606037f7cf",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/DailyTalks%2Fiamstarving.wav?alt=media&token=85f06a38-54ec-4be9-b660-e21fc2fc570d",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/DailyTalks%2Fmayihavesomethingtoeat.wav?alt=media&token=9ce6ba99-7d2b-41cb-b290-7759e8ca3a7e",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/DailyTalks%2Fwhereisrestroom.wav?alt=media&token=0e71e68d-a8a3-4132-bbcb-e11bf8b18cee",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/DailyTalks%2Fionlyspeakebglish.wav?alt=media&token=501ba89d-d3b7-462f-9435-71b2ec9c4436",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/DailyTalks%2Fmayiseemenu.wav?alt=media&token=b16be659-72b4-4f84-80f6-259b1495ee9a",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/DailyTalks%2Fareufreedaturday.wav?alt=media&token=78a0e3ad-5611-4c7f-a1d8-547aef7b4b61",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/DailyTalks%2Fthatsbitpricey.wav?alt=media&token=7295338d-90ad-46c2-9f70-c9963390a436",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/DailyTalks%2Fitwasrealbargain.wav?alt=media&token=784418fe-3370-4862-b72f-c7d69860bff1",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/DailyTalks%2Ffreebreakfast.wav?alt=media&token=16c54a6f-e33e-47a2-bae7-206b2ac813a5",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/DailyTalks%2Fnic%20chatting%20u.wav?alt=media&token=a9e2d907-5816-4239-bc32-6cfa8809bcdf",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/DailyTalks%2Fdousell.wav?alt=media&token=1733132a-025e-4ebe-947b-e3cd63560f6b",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/DailyTalks%2Fdouwanttomovie.wav?alt=media&token=e45a9c85-7d02-4ea1-b006-e1d4136b36d2",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/DailyTalks%2Fiamnotsureaboutthat.wav?alt=media&token=f3d5bc7f-b896-4a51-9678-8389498da4b6",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/DailyTalks%2Fdou%20have%20idea.wav?alt=media&token=d0625749-60dd-49f5-aecb-555296e753c3",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/DailyTalks%2Fabsouluteley.wav?alt=media&token=38b550bb-0018-478b-be45-15331721d39e",
                "https://firebasestorage.googleapis.com/v0/b/capstone-project-76825.appspot.com/o/DailyTalks%2Fnoproblem.wav?alt=media&token=899a4a2c-99bc-4d78-9ee0-acec99617b90"};


        String[] headerList = {"What’s new ?", "How much is this ?", "Hello, my name is Alper.", "Nice to meet you.", "How can i go to Kadikoy ?", "I’m fine, thanks. How about you?", "Can i pay with card ?"
                , "Where is bank ?", "Where is the bus stop?", "Where can I find a taxi?", "Where can I find a restaurant?", "How do I access the Internet?", "Do you know where this hotel is ?",
                "What airline am I flying ?", "I’m starving !", "May I have something to eat ?", "Where is the restroom ?", "I only speak English.", "May I see a menu ?", "Are you free Saturday night ?",
                "That’s a bit pricey.", "It was a real bargain.", "Is breakfast free ?", "It was nice chatting with you.", "Do you sell..... ?", "Do you want to see a movie ?", "I’m not so sure about that.",
                "Do you have any idea ?", "Absolutely.", "No problem."};

        createListView(R.id.urls, addressList, headerList);
    }
}
