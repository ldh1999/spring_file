package com.ldh.server.impl;
import com.ldh.dao.ManagerDao;
import com.ldh.dao.NoticeDao;
import com.ldh.dao.PersonDao;
import com.ldh.dao.SalaryDao;
import com.ldh.domain.Manager;
import com.ldh.domain.Notice;
import com.ldh.domain.Person;
import com.ldh.domain.Salary;
import com.ldh.server.Enroll;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollImpl implements Enroll {
    @Autowired
    private ManagerDao managerDao;
    @Autowired
    private PersonDao personDao;
    @Autowired
    private SalaryDao salaryDao;
    @Autowired
    private NoticeDao noticeDao;

    @Override
    public List<Manager> Mangerquery(String username) {
        List<Manager> list =managerDao.query(username);
        return list;

    }
    @Override
    public List<Person> Personquery(String username) {
        List<Person> list=personDao.query(username);
        return  list;
    }

    @Override
    public List<Salary> Salaryquery(String num) {
        List<Salary> list= salaryDao.query(num);
        return list;
    }

    @Override
    public List<Notice> Noticequery(String num) {
        List<Notice> list=noticeDao.query(num);
        return list;
    }

    @Override
    public void  Mangerinsert(Manager manager) {
        List<Manager> list=managerDao.query(manager.getNum());
        if(list.isEmpty()){
            managerDao.insert(manager);
        }else {
            System.out.println("num重复");
        }
    }

    @Override
    public String  Personinsert(Person person) {
        List<Person> list= personDao.query(person.getNum());
        if(list.isEmpty()){
            personDao.insert(person);
            return "400";
        }else {
            System.out.println("num重复");
            return "200";
        }

    }

    @Override
    public String  Salaryinsert(Salary salary) {
        List<Salary> list= salaryDao.query(salary.getNum());
        List<Person> list1=personDao.query(salary.getNum());
        if (list1.isEmpty()){
            return "100";
        }
        else if(list.isEmpty()){
            System.out.println(list1.get(0).toString());
            salaryDao.insert(salary);
            return "400";
        }
        else {
            System.out.println("DEL11111ETE");
            salaryDao.delete(salary.getNum());
            System.out.println("DELETE");
            salaryDao.insert(salary);
            return "400";
        }
        /*else{
            System.out.println("DEL11111ETE");
            salaryDao.delete(salary.getNum());
            System.out.println("DELETE");
            salaryDao.insert(salary);

            return "400";
        }*/

    }

    @Override
    public String Noticeinsert(Notice notice) {
        List<Notice> list= noticeDao.query(notice.getNum());
        if(list.isEmpty()){
            noticeDao.insert(notice);
            return "400";
        }else {
            System.out.println("num重复");
            return "200";
        }
    }

    @Override
    public List<Person> Personqueryall() {
        List<Person> list=personDao.queryAll();
        return list;
    }

    @Override
    public List<Notice> Noticequeryall() {
        List<Notice> list= noticeDao.queryall();
        return list;
    }

    @Override
    public String Noticedelete(String num) {
        List<Notice> list= noticeDao.query(num);
        if(list.isEmpty()){
            return "100";
        }else {
            noticeDao.delete(num);
            return "400";
        }
    }

    @Override
    public String Persondelete(String num) {
        List<Person> list= personDao.query(num);
        if(list.isEmpty()){
            return "100";
        }else {
            personDao.delete(num);
            return "400";
        }
    }
}
