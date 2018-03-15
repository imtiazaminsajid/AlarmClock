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
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TimePicker timePicker;
    TextView updateMessage;
    Button alarmOn, alarmOff;
    AlarmManager alarmManager;
    Context context;
    Calendar calendar;


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        this.context = this;

        timePicker = findViewById(R.id.alarm_timePicker);
        updateMessage = findViewById(R.id.update_message);
        alarmOn = findViewById(R.id.alarm_on);
        alarmOff = findViewById(R.id.alarm_off);
        calendar = Calendar.getInstance();

        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);


        alarmOn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {

                calendar.get(Calendar.HOUR_OF_DAY);
                calendar.get(Calendar.MINUTE);


                int hourInt = timePicker.getCurrentHour();
                int minuteInt = timePicker.getCurrentMinute();

                String format;
                if (hourInt == 0) {
                    hourInt += 12;
                    format = "AM";
                } else if (hourInt == 12) {
                    format = "PM";
                } else if (hourInt > 12) {
                    hourInt -= 12;
                    format = "PM";
                } else {
                    format = "AM";
                }

                String hour = String.valueOf(hourInt);
                String minute = String.valueOf(minuteInt);

//
//
////                if (hour>12){
////                    hour_string = String.valueOf(hour - 12);
////                }
////                if (minute<10){
////                    minute_string = "0"+String.valueOf(minute);
////                }

                set_alarm_text("Alarm set to: "+hour+" : "+minute+" : "+format);

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
