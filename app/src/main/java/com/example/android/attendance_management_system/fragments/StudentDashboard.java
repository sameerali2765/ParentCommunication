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

import com.example.android.attendance_management_system.R;
import com.example.android.attendance_management_system.activities.ViewStudentAttendance;

public class StudentDashboard extends Fragment {

    private Button mviewAttendance;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_student_dashboard, container, false);
        mviewAttendance = view.findViewById(R.id.view_att);

        mviewAttendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ViewStudentAttendance.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
