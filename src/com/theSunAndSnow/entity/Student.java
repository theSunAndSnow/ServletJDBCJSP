package com.theSunAndSnow.entity;

import java.sql.Date;

// 与Study 中 的 student 表映射起来
public class Student {
    private String S_no;
    private String Class_no;
    private String S_name;
    private String Ssex;
    private Date S_birthday;

    @Override
    public String toString() {
        return "Student{" +
                "S_no='" + S_no + '\'' +
                ", Class_no='" + Class_no + '\'' +
                ", S_name='" + S_name + '\'' +
                ", Ssex='" + Ssex + '\'' +
                ", S_birthday=" + S_birthday +
                '}';
    }

    public Student(String s_no, String class_no, String s_name, String ssex, Date s_birthday) {
        S_no = s_no;
        Class_no = class_no;
        S_name = s_name;
        Ssex = ssex;
        S_birthday = s_birthday;
    }

    public void setS_no(String s_no) {
        S_no = s_no;
    }

    public void setClass_no(String class_no) {
        Class_no = class_no;
    }

    public void setS_name(String s_name) {
        S_name = s_name;
    }

    public void setSsex(String ssex) {
        Ssex = ssex;
    }

    public void setS_birthday(Date s_birthday) {
        S_birthday = s_birthday;
    }

    public String getS_no() {
        return S_no;
    }

    public String getClass_no() {
        return Class_no;
    }

    public String getS_name() {
        return S_name;
    }

    public String getSsex() {
        return Ssex;
    }

    public Date getS_birthday() {
        return S_birthday;
    }
}
