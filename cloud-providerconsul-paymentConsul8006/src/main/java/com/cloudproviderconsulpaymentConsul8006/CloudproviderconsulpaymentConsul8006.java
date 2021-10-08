package com.cloudproviderconsulpaymentConsul8006;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan("com.cloudproviderconsulpaymentConsul8006.dao")
@EnableDiscoveryClient
public class CloudproviderconsulpaymentConsul8006 {
    public static void main(String[] args) {
        SpringApplication.run(CloudproviderconsulpaymentConsul8006.class,args);
    }
}
