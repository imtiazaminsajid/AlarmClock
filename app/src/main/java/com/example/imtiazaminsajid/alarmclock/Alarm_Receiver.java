package com.example.imtiazaminsajid.alarmclock;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Imtiaz Amin Sajid on 3/15/2018.
 */

public class Alarm_Receiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("We are in receiver", "Yeah");

        String get_my_string = intent.getExtras().getString("extra");

        Log.e("What is the key?", get_my_string);

        Intent service_intent = new Intent(context,RingtonePlayingService.class);

        service_intent.putExtra("extra", get_my_string);

        context.startService(service_intent);
    }
}
