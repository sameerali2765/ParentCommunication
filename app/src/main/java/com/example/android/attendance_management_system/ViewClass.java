package com.example.android.attendance_management_system;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import java.text.DateFormat;
import java.util.Calendar;

public class ViewClass extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_class);
        Button button =(Button) findViewById(R.id.select_date);
        Button submit = (Button) findViewById(R.id.btnSubmit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ViewClass.this, Rolls.class);
                startActivity(i);
            }
        });
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                DialogFragment datePicker = new SelectDate();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });
    }
    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
        Calendar c;
        c = Calendar.getInstance();
        c.set(Calendar.YEAR, year );
        c.set(Calendar.MONTH, month );
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth );
        String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(currentDateString);
    }
}
