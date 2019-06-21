package com.clive.springbootdemo5.controller;

import com.clive.springbootdemo5.mapper.EmpMapper;
import com.clive.springbootdemo5.pojo.Dep;
import com.clive.springbootdemo5.pojo.Emp;
import com.clive.springbootdemo5.service.EmpService;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private EmpService empService;
    @RequestMapping("/list")
    public String empList(Model model){
        List<Emp> empList = empService.findAllEmp();
        model.addAttribute("empList",empList);
        return "empList";
    }
    @GetMapping("/addEmp")
    public String showAddEmp(Model model){
        List<Dep> depAll = empMapper.findDepAll();
        model.addAttribute("depAll",depAll);
        return "addEmp";
    }
    @PostMapping("/saveEmp")
    public String addEmp(Emp emp, Integer depId){
        System.out.println(emp);

        return null;
    }
}
