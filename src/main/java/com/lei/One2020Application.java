package com.lei;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lei.mapper")
public class One2020Application {

    public static void main(String[] args) {
        SpringApplication.run(One2020Application.class, args);
    }

}
