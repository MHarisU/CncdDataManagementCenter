package com.cncd.first.Utils;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimePicker {

    Context context;
    TextView view;

    public TimePicker(Context context, TextView view) {
        this.context = context;
        this.view = view;
    }

    public void pickDate(){

        Calendar mcurrentTime = Calendar.getInstance();
        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
        int minute = mcurrentTime.get(Calendar.MINUTE);
        TimePickerDialog mTimePicker;
        mTimePicker = new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(android.widget.TimePicker timePicker, int selectedHour, int selectedMinute) {
                view.setText( selectedHour + ":" + selectedMinute);

            }

        }, hour, minute, false);//Yes 24 hour time
        mTimePicker.setTitle("Select Time");
        mTimePicker.show();
    }
}
