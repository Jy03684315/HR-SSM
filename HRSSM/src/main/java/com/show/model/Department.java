package com.show.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Show on 2018/7/26.
 */
public class Department implements Serializable{
    private int id;
    private String name;
    private Date date;
    private List<Position> positions;

    public Department() {
    }

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", positions=" + positions +
                '}';
    }
}
