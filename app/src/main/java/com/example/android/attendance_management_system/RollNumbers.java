package com.example.android.attendance_management_system;

public class RollNumbers {
    private String number;
    private boolean checked = false;

    public RollNumbers(String number, boolean isChecked) {
        this.number = number;
        this.checked = isChecked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getNumber() {
        return number;
    }

    public boolean isChecked() {
        return checked;
    }
}