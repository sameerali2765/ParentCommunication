package com.example.android.attendance_management_system.activities;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.android.attendance_management_system.R;
import com.example.android.attendance_management_system.fragments.AdminDashboard;
import com.example.android.attendance_management_system.fragments.AdminProfile;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AdminPage extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView mBottomNav;

    AdminDashboard mAdminDashboard;
    AdminProfile mAdminProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_homepage);

        mAdminDashboard = new AdminDashboard();
        mAdminProfile = new AdminProfile();

        mBottomNav = findViewById(R.id.admin_bottom_nav);
        mBottomNav.setOnNavigationItemSelectedListener(this);

        if (savedInstanceState == null) {
            loadFragment(mAdminDashboard);
            mBottomNav.setSelectedItemId(R.id.nav_dashboard);
        }


    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_dashboard:
                loadFragment(mAdminDashboard);
                return true;
            case R.id.nav_profile:
                loadFragment(mAdminProfile);
                return true;
        }
        return false;
    }

    private void loadFragment(Fragment fragment) {

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container_admin, fragment)
                .commit();
    }
}
