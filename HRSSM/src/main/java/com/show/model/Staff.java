package com.show.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Show on 2018/8/1.
 */
public class Staff implements Serializable{
    private int id;
    private String name;//账号
    private String pass;//密码
    private int state;//状态
    private Date date;//入职日期
    private String sName;//员工姓名
    private String sex;//性别
    private String idCard;//身份证
    private Date birth;//生日
    private String graduation;//毕业院校
    private String education;//学历
    private String certificate;//证书
    private Position position;//职位
    private String explain;//解释
    private List<Train> trains;//培训
    private List<Reward> rewards;//奖惩
    private List<Attendance> attendances;//考勤
    private List<Pay> pays;//薪资

    public Staff() {
    }

    public List<Pay> getPays() {
        return pays;
    }

    public void setPays(List<Pay> pays) {
        this.pays = pays;
    }

    public List<Reward> getRewards() {
        return rewards;
    }

    public void setRewards(List<Reward> rewards) {
        this.rewards = rewards;
    }

    public List<Attendance> getAttendances() {
        return attendances;
    }

    public void setAttendances(List<Attendance> attendances) {
        this.attendances = attendances;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public List<Train> getTrains() {
        return trains;
    }

    public void setTrains(List<Train> trains) {
        this.trains = trains;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getGraduation() {
        return graduation;
    }

    public void setGraduation(String graduation) {
        this.graduation = graduation;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                ", state=" + state +
                ", date=" + date +
                ", sName='" + sName + '\'' +
                ", sex='" + sex + '\'' +
                ", idCard='" + idCard + '\'' +
                ", birth=" + birth +
                ", graduation='" + graduation + '\'' +
                ", education='" + education + '\'' +
                ", certificate='" + certificate + '\'' +
                ", position=" + position +
                ", explain='" + explain + '\'' +
                ", trains=" + trains +
                ", rewards=" + rewards +
                ", attendances=" + attendances +
                ", pays=" + pays +
                '}';
    }
}
