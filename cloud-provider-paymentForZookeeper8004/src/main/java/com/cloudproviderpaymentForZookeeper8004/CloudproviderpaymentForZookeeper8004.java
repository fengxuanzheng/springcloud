package com.cloudproviderpaymentForZookeeper8004;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan("com.cloudproviderpaymentForZookeeper8004.dao")
@EnableDiscoveryClient
public class CloudproviderpaymentForZookeeper8004 {
    public static void main(String[] args) {
        SpringApplication.run(CloudproviderpaymentForZookeeper8004.class,args);
    }

}
