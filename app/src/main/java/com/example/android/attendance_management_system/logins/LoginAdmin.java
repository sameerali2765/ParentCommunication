package com.example.android.attendance_management_system.logins;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android.attendance_management_system.R;
import com.example.android.attendance_management_system.activities.AdminPage;
import com.google.firebase.auth.FirebaseAuth;


public class LoginAdmin extends AppCompatActivity {
  Button loginbtn_admin;
  EditText admin_email;
    EditText admin_password;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__admin);

        loginbtn_admin=findViewById(R.id.loginbutton_admin);
        loginbtn_admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), AdminPage.class);
                startActivity(intent);
            }
        });

    }
}
