package com.clive.springbootdemo5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    //1.限制我们的请求方式为post请求
    @PostMapping("/userLogin")
    public String userLogin(String username, String password, Model model, HttpSession session){

        if(password.equals("123456")){
            session.setAttribute("user",username);
            return "main";
        }else{
            model.addAttribute("msg","账号密码有误");
            //1.新问题 springboot下 怎么跳转呢？
            return "forward:/login";
        }
    }
}
