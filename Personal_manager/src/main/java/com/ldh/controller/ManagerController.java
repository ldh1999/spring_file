package com.ldh.controller;

import com.ldh.domain.*;
import com.ldh.server.Enroll;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("manager_")
public class ManagerController {

    @Autowired
    private Enroll enroll;

    @RequestMapping("main")
    public String Manager_main(String uid,Model model){
        System.out.println("uid="+uid);
        Manager manager=enroll.Mangerquery(uid).get(0);
        model.addAttribute("manager",manager);
        return "manager_main";
    }
    /*
        奖金 页面跳转
    */
    @RequestMapping("salary")
    public String Salary(){
        return "salary";
    }
    /*
        人员管理页面跳转
     */
    @RequestMapping("personal_manager")
    public String  person_insert(){
        return "personal_manager";
    }
    /*
        添加人员信息Login
     */
    @RequestMapping("person_manager_login")
    public @ResponseBody
    State person_manager_login(Person person){
        State state=new State();
        System.out.println(person.toString());
        if (person.isempty()){
            state.setState("250");
        }else {
           String str= enroll.Personinsert(person);
           state.setState(str);
          //  System.out.println(enroll.Personquery(person.toString()).get(0));
        }
        return state;
    }
    /*
        发放工资
     */
    @RequestMapping("person_salary_login")
    public @ResponseBody State person_salary(Salary salary){
        State state=new State();
        System.out.println(salary);

        if (salary.isempty()){
            state.setState("250");
            return state;
        }else {
            salary.setSum(salary.getBase()+salary.getBonus()-salary.getPenalty());
            System.out.println("||||||||||||"+salary);
            String str=enroll.Salaryinsert(salary);
            state.setState(str);
            System.out.println(state.getState());
            return state;
        }
    }
    /*
        跳转人员查找
     */
    @RequestMapping("find_all")
    public String person_find(Model model){
        List<Person> list =enroll.Personqueryall();
        model.addAttribute("list",list);
        return "personal_find";
    }
    /*
        跳转notice
     */
    @RequestMapping("notice")
    public String notice(Model model){
        model.addAttribute("list",enroll.Noticequeryall());
        return "notice_manager";
    }
    /*
        提交添加notice
     */
    @RequestMapping("notice_login")
    public @ResponseBody State notice_login(Notice notice){
        State state=new State();
        List<Notice> list =enroll.Noticequery(notice.getNum());
        if (notice.isempty()){
            state.setState("250");
            return state;
        }
        if(list.isEmpty()){
            String str=enroll.Noticeinsert(notice);
            state.setState(str);
            return state;
        }else {
            state.setState("200");
            return state;
        }
    }
    /*
        删除notice
     */
    @RequestMapping("notice_delete_login")
    public @ResponseBody State notice_delete(String num_delete){
        State state=new State();
        if (num_delete.equals("")){
            state.setState("250");
            return state;
        }else {
            state.setState(enroll.Noticedelete(num_delete));
            return state;
        }
    }
    /*
        删除person
     */
    @RequestMapping("person_delete_login")
    public @ResponseBody State person_delete(String num_delete){
        State state=new State();
        if (num_delete.equals("")){
            state.setState("250");
            return state;
        }else {
            state.setState(enroll.Persondelete(num_delete));
            return state;
        }
    }
}
