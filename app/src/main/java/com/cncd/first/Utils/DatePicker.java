package com.cncd.first.Utils;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DatePicker {

    Context context;
    TextView view;

    public DatePicker(Context context, TextView view) {
        this.context = context;
        this.view = view;
    }

    public String pickDate(){

        final String[] selected_date = {""};

        //lab_appointment_date_time = findViewById(R.id.date_time);

        final Calendar calendar = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(android.widget.DatePicker datePicker, int year, int month, int day) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, day);

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd/MM/yyyy");

                // selected_date_of_birht = simpleDateFormat.format(calendar.getTime());

                view.setText("" + simpleDateFormat.format(calendar.getTime()));
                selected_date[0] = "" + simpleDateFormat2.format(calendar.getTime());
                //view.setText(""+selected_date);


            }
        };



        DatePickerDialog datePickerDialog =new DatePickerDialog(context, AlertDialog.THEME_HOLO_LIGHT, dateSetListener, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));

        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePickerDialog.show();

        return selected_date[0];
    }
}
