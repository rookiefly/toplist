package com.rookiefly.open.toplist.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.rookiefly.open.toplist.web.repository")
public class ToplistWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ToplistWebApplication.class, args);
    }

}
