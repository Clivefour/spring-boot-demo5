package com.clive.springbootdemo5.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    //根据用户输入的地址来访问页面
    @RequestMapping("/{page}")
    public String showIndex(@PathVariable String page){
        return page;
    }
    //默认访问主页
    @RequestMapping("/")
    public String showMain(){
        return "main";
    }
}
