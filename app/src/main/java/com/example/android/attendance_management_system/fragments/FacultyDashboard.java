package com.example.android.attendance_management_system.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.android.attendance_management_system.activities.GenerateReport;
import com.example.android.attendance_management_system.R;
import com.example.android.attendance_management_system.ViewClass;
import com.example.android.attendance_management_system.activities.ViewStudentAttendance;

public class FacultyDashboard extends Fragment {

    private Button mPostAttention, mViewAttendance, mGenerateReport;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_faculty_dashboard, container, false);
        mPostAttention = view.findViewById(R.id.post_attendance);
        mViewAttendance = view.findViewById(R.id.view_attendance);
        mGenerateReport = view.findViewById(R.id.generate_report);

        mPostAttention.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ViewClass.class);
                startActivity(intent);
            }
        });
        mViewAttendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ViewStudentAttendance.class);
                startActivity(intent);
            }
        });
        mGenerateReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), GenerateReport.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
