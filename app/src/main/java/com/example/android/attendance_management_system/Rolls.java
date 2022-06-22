package com.example.android.attendance_management_system;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.LinkedList;
import java.util.List;

public class Rolls extends AppCompatActivity {
    List<RollNumbers> numbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rolls_main);

        numbers = new LinkedList<>();

        for (int i = 1; i <= 60; i++) {
            String num = "317126510";
            num = num + String.format("%03d", i);
            numbers.add(new RollNumbers(num, false));
        }

        setupRecyclerView();
    }

    private void setupRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new RollsAdapter(numbers));
    }

    public void selectNumbers(View view) {
        String[] str = new String[60];
        final StringBuilder sb = new StringBuilder("");
        int k = 0;
        for (int i = 0; i < numbers.size(); i++) {
            RollNumbers obj = numbers.get(i);
            if (obj.isChecked()) {
                str[k++] = obj.getNumber();
                sb.append(obj.getNumber())
                        .append("\n");
            }
        }
        AlertDialog absentees = new AlertDialog.Builder(Rolls.this)
                .setTitle("Absentee's")
                .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(Rolls.this, "Saved", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .create();

        if (sb.toString().equals("")) {
            absentees.setMessage("None");
        } else {
            absentees.setMessage(sb.toString());
        }
        absentees.show();
    }
}
