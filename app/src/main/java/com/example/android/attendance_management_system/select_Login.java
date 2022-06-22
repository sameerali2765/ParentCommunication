package com.example.android.attendance_management_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android.attendance_management_system.logins.LoginAdmin;
import com.example.android.attendance_management_system.logins.LoginFaculty;
import com.example.android.attendance_management_system.logins.LoginStudent;

public class select_Login extends AppCompatActivity implements View.OnClickListener {
    public Button admin, faculty, student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select__login);

        admin = findViewById(R.id.adminavatar);
        faculty = findViewById(R.id.teacheravatar);
        student = findViewById(R.id.studentavatar);

        admin.setOnClickListener(this);
        faculty.setOnClickListener(this);
        student.setOnClickListener(this);
    }
            @Override
            public void onClick (View v){
                switch (v.getId()) {
                    case R.id.studentavatar:
                        // handle button A click;
                        studentlogin();
                        break;
                    case R.id.teacheravatar:
                        // handle button B click;
                        facultylogin();
                        break;
                    case R.id.adminavatar:
                        adminlogin();
                        break;

                }
            }
    public void studentlogin(){
        Intent intent=new Intent(this, LoginStudent.class);
        startActivity(intent);
    }
    public void facultylogin(){
        Intent intent=new Intent(this, LoginFaculty.class);
        startActivity(intent);
    }
    public void adminlogin(){
        Intent intent=new Intent(this, LoginAdmin.class);
        startActivity(intent);
    }
}
