package com.example.android.attendance_management_system.logins;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android.attendance_management_system.R;
import com.example.android.attendance_management_system.activities.FacultyPage;


public class LoginFaculty extends AppCompatActivity {
     Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__faculty);

        button = findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FacultyPage.class);
                startActivity(intent);

            }
        });


    }

}
