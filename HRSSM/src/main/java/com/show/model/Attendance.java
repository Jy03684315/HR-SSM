package com.show.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Show on 2018/8/4.
 */
public class Attendance implements Serializable{
    private int id;
    private Date onTime;
    private Date offTime;
    private int month;
    private int day;
    private int year;
    private Staff staff;

    public Attendance() {
    }

    public Attendance(Date onTime, int month, int day, int year, Staff staff) {
        this.onTime = onTime;
        this.month = month;
        this.day = day;
        this.year = year;
        this.staff = staff;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Date getOnTime() {
        return onTime;
    }

    public void setOnTime(Date onTime) {
        this.onTime = onTime;
    }

    public Date getOffTime() {
        return offTime;
    }

    public void setOffTime(Date offTime) {
        this.offTime = offTime;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "id=" + id +
                ", onTime=" + onTime +
                ", offTime=" + offTime +
                ", month=" + month +
                ", day=" + day +
                ", year=" + year +
                ", staff=" + staff +
                '}';
    }
}
