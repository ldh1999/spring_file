package com.ldh.domain;

import java.io.Serializable;

public class Manager implements Serializable {
    private String num;
    private String name;
    private String password;

    public Manager(String num, String name, String password) {
        this.num = num;
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "num='" + num + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
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

    public String getpassword() {
        return password;
    }

    public void setpassword(String password) {
        this.password = password;
    }
}
