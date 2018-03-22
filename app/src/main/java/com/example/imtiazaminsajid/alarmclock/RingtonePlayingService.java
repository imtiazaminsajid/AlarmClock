package com.example.imtiazaminsajid.alarmclock;

import android.annotation.SuppressLint;
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
    int startId;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @SuppressLint("LongLogTag")
    public int onStartCommand(Intent intent, int flag, int startId){

        Log.i("Local Service", "Receive"+startId+": "+intent);

        String state = intent.getExtras().getString("extra");

        Log.e("Ringtone state:Extra is ", state);
        assert state != null;
        switch (state) {
            case "alarm on":
                startId = 1;
                break;
            case "alarm off":
                startId = 0;
                break;
            default:
                startId = 0;
                break;
        }

        mediaPlayer = MediaPlayer.create(this, R.raw.alarm);
        mediaPlayer.start();

        return START_NOT_STICKY;
    }

    public void onDestroy(){
        Toast.makeText(this, "On Distroy Called", Toast.LENGTH_SHORT).show();
    }
}
