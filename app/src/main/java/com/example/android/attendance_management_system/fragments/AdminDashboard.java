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
import com.example.android.attendance_management_system.RemoveFaculty;
import com.example.android.attendance_management_system.RemoveStudent;
import com.example.android.attendance_management_system.register.RegisterFaculty;
import com.example.android.attendance_management_system.register.RegisterStudent;

public class AdminDashboard extends Fragment implements View.OnClickListener {
    private Button mAddFaculty, mRemoveFaculty, mAddStudent, mRemoveStudent;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_admin_dashboard, container, false);
        Button addstudent = (Button) view.findViewById(R.id.astudent);
        Button remstudent = (Button) view.findViewById(R.id.rstudent);
        Button addfaculty = (Button) view.findViewById(R.id.afaculty);
        Button remfaculty = (Button) view.findViewById(R.id.rfaculty);

        addstudent.setOnClickListener(this);
        remstudent.setOnClickListener(this);
        addfaculty.setOnClickListener(this);
        remfaculty.setOnClickListener(this);

       return view;
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.astudent:
                // handle button A click;
                add_student();
                break;
            case R.id.afaculty:
                // handle button A click;
                add_faculty();
                break;
            case R.id.rstudent:
                // handle button A click;
                rem_student();
                break;
            case R.id.rfaculty:
                // handle button A click;
                rem_faculty();
                break;
        }
    }
    public void add_faculty() {
        Intent intent = new Intent(getContext(), RegisterFaculty.class);
        startActivity(intent);
    }

    public void add_student() {
        Intent intent = new Intent(getContext(), RegisterStudent.class);
        startActivity(intent);
    }

    public void rem_faculty() {
        Intent intent = new Intent(getContext(), RemoveFaculty.class);
        startActivity(intent);
    }

    public void rem_student() {
        Intent intent = new Intent(getContext(), RemoveStudent.class);
        startActivity(intent);
    }
}
/*

*/
/*
mAddFaculty = view.findViewById(R.id.afaculty);
        mRemoveFaculty = view.findViewById(R.id.rfaculty);
        mAddStudent = view.findViewById(R.id.astudent);
        mRemoveStudent = view.findViewById(R.id.rstudent);

        mAddFaculty.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
        Intent intent = new Intent(getContext(), RegisterFaculty.class);
        startActivity(intent);
        }
        });
        mRemoveFaculty.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
        Intent intent = new Intent(getContext(), RemoveFaculty.class);
        startActivity(intent);
        }
        });
        mAddStudent.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
        Intent intent = new Intent(getContext(), RegisterStudent.class);
        startActivity(intent);
        }
        });
        mRemoveStudent.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
        Intent intent = new Intent(getContext(), RemoveStudent.class);
        startActivity(intent);
        }
        });*/