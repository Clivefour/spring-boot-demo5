package com.clive.springbootdemo5.service.impl;

import com.clive.springbootdemo5.mapper.EmpMapper;
import com.clive.springbootdemo5.pojo.Emp;
import com.clive.springbootdemo5.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public List<Emp> findAllEmp() {
        //先从缓存中获取数据
        try {
            List<Emp> emps = (List<Emp>) redisTemplate.opsForValue().get("empAll");
            if (emps != null&&emps.size()>0) {
                System.out.println("从缓冲中获取数据"+emps);
                return emps;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Emp> empAll = empMapper.findEmpAll();
        System.out.println("从数据库中获取数据");
        redisTemplate.opsForValue().set("empAll", empAll);
        return empAll;
    }
}
