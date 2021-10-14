package com.cloudalibabaconsumernacosorder84;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class Cloudalibabaconsumernacosorder84 {
    public static void main(String[] args) {
        SpringApplication.run(Cloudalibabaconsumernacosorder84.class,args);
    }
}
