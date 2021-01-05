package com.ldh.domain;

import java.io.Serializable;

public class Notice implements Serializable {
    private String num;
    private String subject;
    private String word;

    public Notice(String num, String subject, String word) {
        this.num = num;
        this.subject = subject;
        this.word = word;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "num='" + num + '\'' +
                ", subject='" + subject + '\'' +
                ", word='" + word + '\'' +
                '}';
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public  boolean isempty(){
        if (this.num.equals("")||this.subject.equals("")||this.word.equals(""))
            return true;
        else
            return false;
    }
}
