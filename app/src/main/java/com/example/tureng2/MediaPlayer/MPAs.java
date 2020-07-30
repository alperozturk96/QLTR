package com.example.tureng2.MediaPlayer;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public abstract class MPAs extends AppCompatActivity {

    private static MediaPlayer mediaPlayer = new MediaPlayer();



    public final void mpstart(String mydata) {
        try {
            if (mediaPlayer.isPlaying() == true) {
                mpPauseStop();
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                mediaPlayer = MediaPlayer.create(this, Uri.parse(mydata));
                //mediaPlayer.setDataSource(getApplicationContext(), Uri.parse(mydata));
                //mediaPlayer.setOnPreparedListener(this);
                mediaPlayer.isPlaying();
                //mediaPlayer.prepare();
                mediaPlayer.start();
            } else {
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                mediaPlayer = MediaPlayer.create(this, Uri.parse(mydata));
                //mediaPlayer.setDataSource(getApplicationContext(),mydata);
                //mediaPlayer.setOnPreparedListener(this);
                mediaPlayer.isPlaying();
                //mediaPlayer.prepare();
                mediaPlayer.start();
            }
        }
        catch (Exception e)
        {
            Log.e("MediaPlayer","MediaPlayer Start Exception", e);
        }
    }



    public final void mpPauseStop() {
        try {
            mediaPlayer.pause();
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = new MediaPlayer();
        }
        catch (Exception e)
        {
            Log.e("MediaPlayer","MediaPlayer Stop Exception", e);
        }
    }

    public void refreshOnClick(View view) {
        isConnected();
    }

    public void createListView(int id, String[] addressList, String[] headerList) {
        try {
            final ListView listView = findViewById(id);

            listenActivities(addressList,headerList,listView);
        }
        catch (Exception e)
        {
            Log.e("MediaPlayer","OnCreate Exception", e);
        }
    }

    public boolean isConnected() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isConnected() == true) {
                return true;
            } else {
                Toast.makeText(this, "İnternet bağlatısı bulunamadı.", Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        catch (Exception e)
        {
            Log.e("MediaPlayer","Network Connectivity Exception", e);
            return false;
        }
    }

    public void listenActivities(final String [] addressList, String [] headerList, ListView listView)
    {
        try {
            ArrayAdapter adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, headerList);
            listView.setAdapter(adapter);


            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    mpstart(addressList[position]);

                }
            });
        }
        catch (Exception e)
        {
            Log.e("MediaPlayer","Listen Activities Exception", e);
        }
    }
}