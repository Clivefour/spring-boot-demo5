package com.clive.springbootdemo5.controller;

import com.clive.springbootdemo5.pojo.Dep;
import com.clive.springbootdemo5.pojo.Emp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/emp")
public class EmpController {
    @RequestMapping("/list")
    public String empList(Model model){
        List<Emp> empList = new ArrayList<Emp>();
        //这里是第一个员工
        Date tiem = new Date();
        Emp emp1 = new Emp();
        emp1.setId(1);
        emp1.setName("张三");
        emp1.setSalary(44.44);
        emp1.setTime(tiem);
        //这里是第二个员工
        Emp emp2 = new Emp();
        emp2.setId(2);
        emp2.setName("李四");
        emp2.setSalary(55.55);
        emp2.setTime(tiem);

        //这里是第一个部门
        Dep dep1 = new Dep();
        dep1.setId(1);
        dep1.setName("销售部");
        //部门关联员工
        dep1.setEmps(empList);
        //员工关联部门
        emp1.setDep(dep1);
        //员工关联部门
        emp2.setDep(dep1);

        //添加员工信息到list集合中
        empList.add(emp1);
        empList.add(emp2);
        model.addAttribute("empList",empList);

        return "empList";
    }
}
