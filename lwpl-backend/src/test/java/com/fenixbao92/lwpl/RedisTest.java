package com.fenixbao92.lwpl;

import com.fenixbao92.lwpl.config.redis.RedisTool;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Resource
    RedisTool redisTool;
    @Test
    public void test1() {
        redisTool.setex("sss",88,"ddd");
    }

    @Test
    public void test2() {
        redisTool.setex("sss",88,"ddd");
        System.out.println(redisTool.get("1"));
    }
}