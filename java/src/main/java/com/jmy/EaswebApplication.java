package com.jmy;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement //开启springboot事务支持
@SpringBootApplication
public class EaswebApplication {


    public static void main(String[] args) {
        SpringApplication.run(EaswebApplication.class, args);
    }

}
