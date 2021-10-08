package com.cloudconsumerhystrixdashboard9001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class Cloudconsumerhystrixdashboard9001 {
    public static void main(String[] args) {
        SpringApplication.run(Cloudconsumerhystrixdashboard9001.class,args);
    }
}
