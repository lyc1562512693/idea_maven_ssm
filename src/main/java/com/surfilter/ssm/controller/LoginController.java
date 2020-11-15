package com.surfilter.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @RequestMapping(value = "/login.action", method = RequestMethod.GET )
    public String login(HttpServletRequest res){
        String username = res.getParameter("username");
        String password = res.getParameter("password");
        System.out.println("username:" + username + "password:" + password);
        if("tom".equals(username) && "123456".equals(password)){
            System.out.println("登录成功！");
        }else{
            System.out.println("登录失败！");
        }
        return "index";
    }
}
