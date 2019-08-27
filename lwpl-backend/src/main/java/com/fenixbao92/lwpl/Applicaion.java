package com.fenixbao92.lwpl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.fenixbao92.lwpl")
@EnableCaching
public class Applicaion {

    public static void main(String[] args){
        SpringApplication.run(Applicaion.class, args);
        System.out.println("启动成功");
    }

}
