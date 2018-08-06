package com.show.model;

import java.io.Serializable;

/**
 * Created by Show on 2018/8/7.
 */
public class Pay implements Serializable{
    private int id;
    private int year;
    private int month;
    private int base;//基本工资
    private int bonus;//绩效奖金
    private int ov;//加班费
    private int rew;//奖惩
    private int ss;//社保
    private int state;
    private String intro;
    private Staff staff;

    public Pay() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getOv() {
        return ov;
    }

    public void setOv(int ov) {
        this.ov = ov;
    }

    public int getRew() {
        return rew;
    }

    public void setRew(int rew) {
        this.rew = rew;
    }

    public int getSs() {
        return ss;
    }

    public void setSs(int ss) {
        this.ss = ss;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    @Override
    public String toString() {
        return "Pay{" +
                "id=" + id +
                ", year=" + year +
                ", month=" + month +
                ", base=" + base +
                ", bonus=" + bonus +
                ", ov=" + ov +
                ", rew=" + rew +
                ", ss=" + ss +
                ", state=" + state +
                ", intro='" + intro + '\'' +
                ", staff=" + staff +
                '}';
    }
}
