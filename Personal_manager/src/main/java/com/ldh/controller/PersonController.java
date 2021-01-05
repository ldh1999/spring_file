package com.ldh.controller;

import com.ldh.domain.Notice;
import com.ldh.domain.Person;
import com.ldh.domain.Salary;
import com.ldh.server.Enroll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("person")
public class PersonController {
    @Autowired
    private Enroll enroll;

    @RequestMapping("main")
    public String Person_main(String uid, Model model){
        System.out.println("uid="+uid);
        List<Person> list=enroll.Personquery(uid);
        List<Salary> list1=enroll.Salaryquery(uid);
        List<Notice> list2=enroll.Noticequeryall();
        if (!(list1.isEmpty())){
            model.addAttribute("salary",list1.get(0));
        }
        model.addAttribute("person",list.get(0));
        model.addAttribute("list",list2);
        return "person_main";
    }
}
