package com.example.imtiazaminsajid.alarmclock;

import android.app.AlarmManager;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TimePicker timePicker;
    TextView updateMessage;
    Button alarmOn, alarmOff;
    AlarmManager alarmManager;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        this.context = this;

        timePicker = findViewById(R.id.timePicker);
        updateMessage = findViewById(R.id.update_message);
        alarmOn = findViewById(R.id.alarm_on);
        alarmOff = findViewById(R.id.alarm_off);

        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        final Calendar calendar = Calendar.getInstance();

        alarmOn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {



                calendar.set(Calendar.HOUR_OF_DAY, timePicker.getHour());
                calendar.set(Calendar.MINUTE, timePicker.getMinute());

                String hour = String.valueOf(timePicker.getHour());
                String minute = String.valueOf(timePicker.getMinute());
//
//
////                if (hour>12){
////                    hour_string = String.valueOf(hour - 12);
////                }
////                if (minute<10){
////                    minute_string = "0"+String.valueOf(minute);
////                }

                set_alarm_text("Alarm set to: "+hour+" : "+minute);

            }
        });

        alarmOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                set_alarm_text("Alarm Off");
            }
        });





    }

    private void set_alarm_text(String output) {
        updateMessage.setText(output);
    }
}
