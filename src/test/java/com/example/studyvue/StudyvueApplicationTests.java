package com.example.studyvue;

import com.alibaba.fastjson.JSON;
import com.example.studyvue.vo.Message;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class StudyvueApplicationTests {

/*
    @Autowired
    private RedisUtils redisUtils;
*/

    @Autowired
    RedisTemplate redisTemplate;


    @Test
    void contextLoads() {
        Message message=new Message();
        message.setInformation("test");
        message.setStatusCode("111");
        message.setShowOrNot("1");
        String testSt="testSt";

        System.out.println(JSON.toJSONString(message));
        redisTemplate.opsForValue().set("test",message);

    }

}
