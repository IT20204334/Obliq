package com.example.obliq;


import androidx.annotation.NonNull;

public class Ntice {

    private String Name;
    private String ID;
    private String Subject;
    private String Date;
    private String Notice;


    public Ntice() {
    }

    public Ntice(String name,String subject,String date,String notice){
        Name = name;
        Subject = subject;
        Date = date;
        Notice = notice;
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String id) { ID = id; }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public String  getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getNotice() {
        return Notice;
    }

    public void setNotice(String notice) {
        Notice = notice;
    }


}
