package com.example.android.attendance_management_system.activities;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.android.attendance_management_system.R;
import com.example.android.attendance_management_system.fragments.StudentDashboard;
import com.example.android.attendance_management_system.fragments.StudentProfile;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class StudentPage extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView mBottomNav;

    StudentDashboard mStudentDashboard;
    StudentProfile mStudentProfile;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_homepage);

        mStudentDashboard = new StudentDashboard();
        mStudentProfile = new StudentProfile();

        mBottomNav = findViewById(R.id.student_bottom_nav);
        mBottomNav.setOnNavigationItemSelectedListener(this);

        if (savedInstanceState == null) {
            loadFragment(mStudentDashboard);
            mBottomNav.setSelectedItemId(R.id.nav_dashboard);
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_dashboard:
                loadFragment(mStudentDashboard);
                return true;
            case R.id.nav_profile:
                loadFragment(mStudentProfile);
                return true;
        }
        return false;
    }

    private void loadFragment(Fragment fragment) {

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container_student, fragment)
                .commit();

    }
}
