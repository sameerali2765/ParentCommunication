package com.example.android.attendance_management_system;

public class Users {
    private String faculty_id,
            faculty_email,
            faculty_pass,
            faculty_num;



    public Users(){

    }

    public Users(String faculty_id, String faculty_email, String faculty_pass, String faculty_num) {
        this.faculty_id = faculty_id;
        this.faculty_email = faculty_email;
        this.faculty_pass = faculty_pass;
        this.faculty_num = faculty_num;
    }

    public String getFaculty_id() {
        return faculty_id;
    }

    public void setFaculty_id(String faculty_id) {
        this.faculty_id = faculty_id;
    }

    public String getFaculty_email() {
        return faculty_email;
    }

    public void setFaculty_email(String faculty_email) {
        this.faculty_email = faculty_email;
    }

    public String getFaculty_pass() {
        return faculty_pass;
    }

    public void setFaculty_pass(String faculty_pass) {
        this.faculty_pass = faculty_pass;
    }

    public String getFaculty_num() {
        return faculty_num;
    }

    public void setFaculty_num(String faculty_num) {
        this.faculty_num = faculty_num;
    }
}

