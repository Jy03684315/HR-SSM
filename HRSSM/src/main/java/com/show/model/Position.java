package com.show.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Show on 2018/7/25.
 */
public class Position implements Serializable{
    private int id;
    private String name;
    private int salary;
    private Department department;
    private List<Recruit> recruit;

    public Position() {
    }

    public Position(int id) {
        this.id = id;
    }

    public List<Recruit> getRecruit() {
        return recruit;
    }

    public void setRecruit(List<Recruit> recruit) {
        this.recruit = recruit;
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", department=" + department +
                ", recruit=" + recruit +
                '}';
    }
}
