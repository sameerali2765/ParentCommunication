package com.example.android.attendance_management_system.activities;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.android.attendance_management_system.R;
import com.example.android.attendance_management_system.fragments.FacultyDashboard;
import com.example.android.attendance_management_system.fragments.FacultyProfile;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FacultyPage extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {


    BottomNavigationView mBottomNav;

    FacultyDashboard mFacultyDashboard;
    FacultyProfile mFacultyProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_homepage);

        mFacultyDashboard = new FacultyDashboard();
        mFacultyProfile = new FacultyProfile();

        mBottomNav = findViewById(R.id.faculty_bottom_nav);
        mBottomNav.setOnNavigationItemSelectedListener(this);

        if(savedInstanceState == null){
            loadFragment(mFacultyDashboard);
            mBottomNav.setSelectedItemId(R.id.nav_dashboard);
        }


    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_dashboard:
                loadFragment(mFacultyDashboard);
                return true;
            case R.id.nav_profile:
                loadFragment(mFacultyProfile);
                return true;
        }
        return false;
    }


    private void loadFragment(Fragment fragment) {

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();

    }

}
