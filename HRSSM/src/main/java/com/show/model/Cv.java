package com.show.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Show on 2018/7/25.
 */
public class Cv implements Serializable{
    private int id;
    private String cName;//简历名
    private String uName;//姓名
    private String sex;//性别
    private Date birth;//生日
    private String idCard;//身份证
    private String nation;//民族
    private String ps;//政治面貌
    private String height;//身高
    private String graduation;//毕业院校
    private String company;//公司
    private String certificate;//证书
    private String evaluation;//自我评价
    private String education;//学历
    private User user;

    public Cv() {
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getGraduation() {
        return graduation;
    }

    public void setGraduation(String graduation) {
        this.graduation = graduation;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public String toString() {
        return "Cv{" +
                "id=" + id +
                ", cName='" + cName + '\'' +
                ", uName='" + uName + '\'' +
                ", sex='" + sex + '\'' +
                ", birth=" + birth +
                ", idCard='" + idCard + '\'' +
                ", nation='" + nation + '\'' +
                ", ps='" + ps + '\'' +
                ", height='" + height + '\'' +
                ", graduation='" + graduation + '\'' +
                ", company='" + company + '\'' +
                ", certificate='" + certificate + '\'' +
                ", evaluation='" + evaluation + '\'' +
                ", education='" + education + '\'' +
                ", user=" + user +
                '}';
    }
}
