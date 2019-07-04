package com.example.sb_redis_demo1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.sb_redis_demo1.dao")
public class SbRedisDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbRedisDemoApplication.class, args);
    }

}
