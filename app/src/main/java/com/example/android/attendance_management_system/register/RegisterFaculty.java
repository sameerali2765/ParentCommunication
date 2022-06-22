package com.example.android.attendance_management_system.register;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.android.attendance_management_system.R;
import com.example.android.attendance_management_system.Users;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.auth.User;

import java.util.regex.Pattern;

public class RegisterFaculty extends AppCompatActivity implements View.OnClickListener {
private Button faculty_reg_button;
private EditText reg_faculty_id,reg_faculty_email,reg_faculty_pass,faculty_mob;
private FirebaseAuth mAuth;
private ProgressBar loading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_faculty);

        mAuth = FirebaseAuth.getInstance();

        faculty_reg_button =(Button) findViewById(R.id.faculty_reg_button);
        faculty_reg_button.setOnClickListener(this);

        reg_faculty_id = (EditText) findViewById(R.id.reg_faculty_id);
        reg_faculty_email = (EditText) findViewById(R.id.reg_faculty_email);
        reg_faculty_pass = (EditText) findViewById(R.id.reg_faculty_pass);
        faculty_mob = (EditText) findViewById(R.id.faculty_mob);

            loading = (ProgressBar) findViewById(R.id.loading);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.faculty_reg_button:
                registerfaculty();
                break;
        }

    }
    private void registerfaculty(){
        final String faculty_id = reg_faculty_id.getText().toString().trim();
        final String faculty_email = reg_faculty_email.getText().toString().trim();
        final String faculty_pass = reg_faculty_pass.getText().toString().trim();
        final String  faculty_num = faculty_mob.getText().toString().trim();

        if(faculty_id.isEmpty()){
            reg_faculty_id.setError("Id is required");
            reg_faculty_id.requestFocus();
            return;
        }

        if(faculty_email.isEmpty()){
            reg_faculty_email.setError("Email is required");
            reg_faculty_email.requestFocus();
            return;
        }

        if(faculty_pass.isEmpty()){
            reg_faculty_pass.setError("Password is required");
            reg_faculty_pass.requestFocus();
            return;
        }

        if(faculty_num.isEmpty()){
            faculty_mob.setError("Phone number is required");
            faculty_mob.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(faculty_email).matches()){
            reg_faculty_email.setError("Please provide valid email");
            reg_faculty_email.requestFocus();
            return;
        }
        if(faculty_pass.length() < 6){
            reg_faculty_pass.setError("Min password lenght should be 6 characters!");
            reg_faculty_pass.requestFocus();
            return;
        }

        loading.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(faculty_email,faculty_pass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Users users = new Users(faculty_id,faculty_email,faculty_pass,faculty_num);
                            FirebaseDatabase.getInstance().getReference("Users").
                                    child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(users).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if(task.isSuccessful()){
                                                Toast.makeText(RegisterFaculty.this, "User has been successfilly", Toast.LENGTH_SHORT).show();
                                            loading.setVisibility(View.VISIBLE);
                                            }else {
                                                Toast.makeText(RegisterFaculty.this, "Failed Register Try again", Toast.LENGTH_SHORT).show();
                                            loading.setVisibility(View.GONE);

                                            }
                                        }
                                    });
                        }else {
                            Toast.makeText(RegisterFaculty.this, "Failed To Register ", Toast.LENGTH_SHORT).show();
                        }

                    }
                });



    }
}
