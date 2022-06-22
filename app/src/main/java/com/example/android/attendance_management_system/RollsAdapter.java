package com.example.android.attendance_management_system;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RollsAdapter extends RecyclerView.Adapter<RollsAdapter.RollsViewHolder> {

    List<RollNumbers> numbers;

    public RollsAdapter(List<RollNumbers> numbers) {
        this.numbers = numbers;
    }

    @NonNull
    @Override
    public RollsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, parent, false);
        return new RollsViewHolder(view, numbers);
    }

    @Override
    public void onBindViewHolder(@NonNull RollsViewHolder holder, int position) {
        RollNumbers number = numbers.get(position);
        holder.checkBox.setText(number.getNumber());
        holder.checkBox.setChecked(number.isChecked());
    }

    @Override
    public int getItemCount() {
        return numbers.size();
    }

    public static class RollsViewHolder extends RecyclerView.ViewHolder {
        CheckBox checkBox;

        public RollsViewHolder(@NonNull View itemView, final List<RollNumbers> numbers) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.check_box);

            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    numbers.get(getAdapterPosition()).setChecked(isChecked);
                }
            });
        }
    }
}
