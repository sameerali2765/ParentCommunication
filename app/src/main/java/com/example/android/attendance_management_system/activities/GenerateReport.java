package com.example.android.attendance_management_system.activities;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import com.example.android.attendance_management_system.R;
import com.example.android.attendance_management_system.SelectDate;

import java.text.DateFormat;
import java.util.Calendar;

public class GenerateReport extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private DatePicker datePicker1;
    private int year;
    private int month;
    private int dayOfMonth;

    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_report);
        Button start = findViewById(R.id.start_date);
        Button end = findViewById(R.id.end_date);
        Button button = findViewById(R.id.report);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment datepicker = new SelectDate();
                datepicker.show(getSupportFragmentManager(), "date picker");
                i = 0;
            }
        });
        end.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                DialogFragment datePicker1 = new SelectDate();
                datePicker1.show(getSupportFragmentManager(), "date picker");
                i = 1;
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               //  enter "report" button activity here
            }
        });
    }

    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
        Calendar c;
        c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());
        TextView start_field = findViewById(R.id.start_date_field);
        TextView end_field = findViewById(R.id.end_date_field);

        if (i == 0) {
            start_field.setText(currentDateString);
        } else {
            end_field.setText(currentDateString);

        }

    }
}
