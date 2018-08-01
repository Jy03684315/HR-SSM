package com.show.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Show on 2018/7/25.
 */
public class User implements Serializable{
    private int id;
    private String name;
    private String pass;
    private List<Cv> cvs=new ArrayList<Cv>();

    public User() {
    }

    public List<Cv> getCvs() {
        return cvs;
    }

    public void setCvs(List<Cv> cvs) {
        this.cvs = cvs;
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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
