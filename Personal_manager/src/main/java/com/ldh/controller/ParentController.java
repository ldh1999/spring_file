package com.ldh.controller;

import com.ldh.domain.Manager;
import com.ldh.domain.Person;
import com.ldh.domain.State;
import com.ldh.server.Enroll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path = "enroll")
public class ParentController{

    @Autowired
    private Enroll enroll;
    @RequestMapping(path = "first")
    public @ResponseBody
    State enroll(String username, String password, String aut) {
        //System.out.println(username + password + aut);

        if (aut.equals("manager")) {
            List<Manager> manager = enroll.Mangerquery(username);
            if (manager.isEmpty()) {
                //"查无此人"
                return new State("100");
            }
            if (manager.get(0).getpassword().equals(password)) {
                // "ok"
                State state = new State("400", username);
                state.setDecision("manager");
                return state;
            } else {
                // "密码错误"
                return new State("150");
            }
        } else if (aut.equals("person")) {
            List<Person> person=enroll.Personquery(username);
            if (person.isEmpty()) {
                //"查无此人"
                return new State("100");
            }
            if (person.get(0).getPassword().equals(password)) {
                // "ok"
                State state = new State("400", username);
                state.setDecision("person");
                return state;
            } else {
                // "密码错误"
                return new State("150");
            }
        }
        return null;
    }


}


