package com.show.model;

import java.io.Serializable;

/**
 * Created by Show on 2018/8/2.
 */
public class StoT implements Serializable{
    private int id;
    private Staff staff;
    private Train train;

    public StoT() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }
}
