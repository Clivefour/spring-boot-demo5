package com.clive.springbootdemo5.mapper;

import com.clive.springbootdemo5.pojo.Dep;
import com.clive.springbootdemo5.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmpMapper {
    //在这里定义 找不到的字段怎么绑定数据 数据库中的字段分开绑定到这里
    @Results({@Result(column = "depId", property = "dep.id", id = true),
            @Result(column = "depName", property = "dep.name")})
    @Select("SELECT e.id,e.`name`,e.salary,e.time,d.id depId,d.`name` depName FROM emp e LEFT JOIN dep d ON e.depId = d.id ")
    List<Emp> findEmpAll();
    @Select("SELECT * FROM dep")
    List<Dep> findDepAll();

}
