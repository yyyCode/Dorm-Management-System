package com.dorm.management;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.dorm.management.mapper")
public class DormManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(DormManagementApplication.class, args);
    }

}
