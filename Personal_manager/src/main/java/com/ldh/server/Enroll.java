package com.ldh.server;

import com.ldh.domain.Manager;
import com.ldh.domain.Notice;
import com.ldh.domain.Person;
import com.ldh.domain.Salary;

import java.util.List;

public interface Enroll {

    //单查询
    public List<Manager> Mangerquery(String username);
    public List<Person> Personquery(String username);
    public List<Salary> Salaryquery(String num);
    public List<Notice> Noticequery(String num);

    //添加
    public void Mangerinsert(Manager manager);
    public String Personinsert(Person person);
    public String Salaryinsert(Salary salary);
    public String Noticeinsert(Notice notice);

    //查全部
    public List<Person> Personqueryall();
    public List<Notice> Noticequeryall();

    //删除
    public String Noticedelete(String num);
    public String Persondelete(String num);
}
