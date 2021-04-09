package com.rookiefly.open.toplist.crawler;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@MapperScan("com.rookiefly.open.toplist.crawler.repository")
public class ToplistCrawlerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ToplistCrawlerApplication.class, args);
    }

}
