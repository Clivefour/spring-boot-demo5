package com.clive.springbootdemo5;

import com.clive.springbootdemo5.commono.JsonUtils;
import com.clive.springbootdemo5.mapper.EmpMapper;
import com.clive.springbootdemo5.pojo.Dep;
import com.clive.springbootdemo5.pojo.Emp;
import org.apache.activemq.broker.region.Queue;
import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemo5ApplicationTests {
    @Autowired
    DataSource dataSource;
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    private EmpMapper empMapper;
    //专门用于操作字符串的,
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    //专门操作对象的，他会吧对象的序列化值存入到redis中，取出来的时候 直接是对象 ，存也是直接存对象
    @Autowired
    private RedisTemplate redisTemplate;
    //spring boot帮我们封装的用于操作 发送消息的工具类
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;


    @Test
    public void contextLoads() throws SQLException {
        //HikariDataSource spring boot内置的数据源（一般情况下我们不会用它来操作）
        System.out.println(dataSource);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }

    @Test
    public void demo1() {
        List<Dep> depAll = empMapper.findDepAll();
        for (Dep dep : depAll) {
            System.out.println(dep);
        }
    }

    @Test
    public void demo2() {
        /**
         * String list hash Set zSet
         */
        stringRedisTemplate.opsForValue().set("key1", "测试使用");
        //stringRedisTemplate.opsForHash().put("key2","user","zhangsan");
        String key1 = stringRedisTemplate.opsForValue().get("key1");
        System.out.println(key1);
    }

    @Test
    public void demo3() {
        Boolean empAll = redisTemplate.delete("empAll");
        System.out.println(empAll);
    }

    @Test
    public void demo4() {
        Emp emp = new Emp();
        redisTemplate.opsForValue().set("emp", emp);
        Emp emp1 = (Emp) redisTemplate.opsForValue().get("emp");
        System.out.println(emp1);
    }

    @Test
    public void sendQueue() {
        /**
         * 这里有两种写法
         * 1.直接new对象的形式来做
         * 2.编写配置类的形式来做
         *      直接用new对象的形式来做的
         */
        ActiveMQQueue queue = new ActiveMQQueue("ptp");
        //就使用jmsMessagingTemplate来发送消息
        jmsMessagingTemplate.convertAndSend(queue, "test point to point");
    }


    @Test
    @JmsListener(destination = "ptp")
    public void receiveQueue(String message) {

        System.out.println("接受到的值为 " + message);

    }




}
