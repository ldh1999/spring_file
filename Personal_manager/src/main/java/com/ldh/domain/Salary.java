package com.ldh.domain;
import java.io.Serializable;

public class Salary implements Serializable {
    private String num;
    private Integer base;
    private Integer bonus;
    private Integer penalty;
    private Integer sum;

    public Salary() {

    }

    @Override
    public String toString() {
        return "Salary{" +
                "num='" + num + '\'' +
                ", base=" + base +
                ", bonus=" + bonus +
                ", penalty=" + penalty +
                ", sum=" + sum +
                '}';
    }

    public Salary(String num, Integer base, Integer bonus, Integer penalty) {
        this.num = num;
        this.base = base;
        this.bonus = bonus;
        this.penalty = penalty;
    }



    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public Integer getBase() {
        return base;
    }

    public void setBase(Integer base) {
        this.base = base;
    }

    public Integer getBonus() {
        return bonus;
    }

    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }

    public Integer getPenalty() {
        return penalty;
    }

    public void setPenalty(Integer penalty) {
        this.penalty = penalty;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public boolean isempty(){
        if(this.num.equals("")||this.base==null||this.bonus==null||this.penalty==null){
            return true;
        }
        else
            return false;
    }
}
