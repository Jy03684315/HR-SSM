package com.show.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Show on 2018/8/3.
 */
public class Reward implements Serializable{
    private int id;
    private Date date;
    private int money;
    private String explain;
    private Staff staff;

    public Reward() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    @Override
    public String toString() {
        return "Reward{" +
                "id=" + id +
                ", date=" + date +
                ", money=" + money +
                ", explain='" + explain + '\'' +
                ", staff=" + staff +
                '}';
    }
}
