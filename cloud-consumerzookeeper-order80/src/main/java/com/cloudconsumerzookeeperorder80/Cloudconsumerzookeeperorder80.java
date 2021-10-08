package com.cloudconsumerzookeeperorder80;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Cloudconsumerzookeeperorder80 {
    public static void main(String[] args) {
        SpringApplication.run(Cloudconsumerzookeeperorder80.class,args);
    }
}
