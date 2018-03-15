package com.example.imtiazaminsajid.alarmclock;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Imtiaz Amin Sajid on 3/15/2018.
 */

public class RingtonePlayingService extends Service {
    MediaPlayer mediaPlayer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent, int flag, int startId){

        Log.e("Local Service", "Receive"+startId+": "+intent);

        mediaPlayer = MediaPlayer.create(this, R.raw.alarm);
        mediaPlayer.start();

        return START_NOT_STICKY;
    }

    public void onDestroy(){
        Toast.makeText(this, "On Distroy Called", Toast.LENGTH_SHORT).show();
    }
}
