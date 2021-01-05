package com.ldh.domain;

import java.io.Serializable;

public class Person  implements Serializable {
    private String num;
    private String name;
    private String sex;
    private String age;
    private String futy;
    private String aut;
    private String password;

    public Person(String num, String name, String sex, String age, String futy, String aut, String password) {
        this.num = num;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.futy = futy;
        this.aut = aut;
        this.password = password;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getFuty() {
        return futy;
    }

    public void setFuty(String futy) {
        this.futy = futy;
    }

    public String getAut() {
        return aut;
    }

    public void setAut(String aut) {
        this.aut = aut;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person{" +
                "num='" + num + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                ", futy='" + futy + '\'' +
                ", aut='" + aut + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
    public  boolean isempty(){
        if (this.getPassword().equals("")||this.getNum().equals("")||this.getAge().equals("")||this.getAut().equals("")||this.getFuty().equals("")||this.getName().equals("")||this.getSex().equals("")){
            return true;
        }else
            return false;
    }
}
