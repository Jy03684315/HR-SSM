package com.show.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Show on 2018/7/25.
 */
public class Recruit implements Serializable{
    private int id;
    private int number;
    private int salary;
    private Date date;
    private String description;
    private int state;//0为未发布，1为已发布
    private Position position;

    public Recruit() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Recruit{" +
                "id=" + id +
                ", number=" + number +
                ", salary=" + salary +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", state=" + state +
                '}';
    }
}
