package com.seataorderservice2003;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.seataorderservice2003.dao")
public class Seataorderservice2003 {
    public static void main(String[] args) {
        SpringApplication.run(Seataorderservice2003.class,args);
    }
}
