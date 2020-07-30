package com.example.tureng2.MediaPlayer;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MPAfragment extends AppCompatActivity {

    private MediaPlayer mediaPlayer = new MediaPlayer();

    private Context context;

    public MPAfragment(@NonNull Context context)
    {
        this.context = context;
    }

    public final void mpStartWithContext(String data, Context context)
    {
        try {
            if (mediaPlayer.isPlaying() == true) {
                mpPauseStop();
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                mediaPlayer = MediaPlayer.create(context, Uri.parse(data));
                mediaPlayer.isPlaying();
                mediaPlayer.start();
            } else {
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                mediaPlayer = MediaPlayer.create(context, Uri.parse(data));
                mediaPlayer.isPlaying();
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
}
