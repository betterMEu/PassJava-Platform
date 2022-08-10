package com.example.passjavaquestion;

import com.better.passjavaquestion.PassjavaQuestionApplication;
import com.better.passjavaquestion.entity.TypeEntity;
import com.better.passjavaquestion.service.TypeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest(classes = PassjavaQuestionApplication.class)
class PassjavaQuestionApplicationTests {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Test
    public void TestStringRedisTemplate() {
        ValueOperations<String,String> ops = stringRedisTemplate.opsForValue();
        ops.set("桑榆","年22");
        String str = ops.get("桑榆");
        System.out.println(str);
    }

}
