package com.example.android.attendance_management_system.logins;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android.attendance_management_system.R;
import com.example.android.attendance_management_system.activities.StudentPage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginStudent extends AppCompatActivity {
    private Button button;
    private Button btn_guest;
    EditText regno, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__student);
        regno = (EditText) findViewById(R.id.registration_no);
        password = (EditText) findViewById(R.id.password);
        button = findViewById(R.id.button1);
        btn_guest = findViewById(R.id.guest);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String validregno = "[0-9]{0,12}";
                String reg_no = regno.getText().toString();
                Matcher matcher = Pattern.compile(validregno).matcher(reg_no);
                if (reg_no.isEmpty()){
                    Toast.makeText(getApplicationContext(),"field can't be empty", Toast.LENGTH_LONG).show();
                }
                 else {
                    Toast.makeText(getApplicationContext(), "Enter valid Reg.No", Toast.LENGTH_LONG).show();
                }
                password.setError("Enter Password");
            }

        });
        btn_guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginStudent.this, StudentPage.class);
                startActivity(i);
            }
        });

    }
}


