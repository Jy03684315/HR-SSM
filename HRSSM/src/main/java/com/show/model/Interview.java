package com.show.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Show on 2018/7/30.
 */
public class Interview implements Serializable{
    private int id;
    private Date time;
    private int state;//0为未阅，1为已阅，2为待回复，3为待录用，4为已录用，5为拒绝邀请
    private Cv cv;
    private Recruit recruit;

    public Interview() {
    }

    public Interview(int state, Cv cv, Recruit recruit) {
        this.state = state;
        this.cv = cv;
        this.recruit = recruit;
    }

    public Interview(Date time, int state, Cv cv, Recruit recruit) {
        this.time = time;
        this.state = state;
        this.cv = cv;
        this.recruit = recruit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Cv getCv() {
        return cv;
    }

    public void setCv(Cv cv) {
        this.cv = cv;
    }

    public Recruit getRecruit() {
        return recruit;
    }

    public void setRecruit(Recruit recruit) {
        this.recruit = recruit;
    }

    @Override
    public String toString() {
        return "Interview{" +
                "id=" + id +
                ", time=" + time +
                ", state=" + state +
                ", cv=" + cv +
                ", recruit=" + recruit +
                '}';
    }
}
