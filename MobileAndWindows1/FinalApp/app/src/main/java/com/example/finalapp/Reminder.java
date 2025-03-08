package com.example.finalapp;

public class Reminder {
    private String title, desc, date, time;

    //set values
    public Reminder(String title, String desc, String date, String time)
    {
        this.title = title;
        this.desc = desc;
        this.date = date;
        this.time = time;
    }
    //need empty constructor
    public Reminder()
    {

    }

    //getters and setters for class
    public String getDate() {
        return date;
    }

    public String getDesc() {
        return desc;
    }

    public String getTime() {
        return time;
    }

    public String getTitle() {
        return title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
