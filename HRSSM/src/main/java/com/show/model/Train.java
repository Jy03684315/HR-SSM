package com.show.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Show on 2018/8/2.
 */
public class Train implements Serializable{
    private int id;
    private String theme;//����
    private String content;//����
    private Date begin;//��ʼʱ��
    private Date end;//����ʱ��
    private int state;//0Ϊδ������1Ϊ�ѷ���
    private Date time;//����ʱ��
    private List<Staff> staff;

    public Train() {
    }

    public Train(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public List<Staff> getStaff() {
        return staff;
    }

    public void setStaff(List<Staff> staff) {
        this.staff = staff;
    }

    @Override
    public String toString() {
        return "Train{" +
                "id=" + id +
                ", theme='" + theme + '\'' +
                ", content='" + content + '\'' +
                ", begin=" + begin +
                ", end=" + end +
                ", state=" + state +
                ", time=" + time +
                ", staff=" + staff +
                '}';
    }
}
