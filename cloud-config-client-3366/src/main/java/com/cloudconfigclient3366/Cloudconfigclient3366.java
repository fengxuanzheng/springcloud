package com.cloudconfigclient3366;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Cloudconfigclient3366 {
    public static void main(String[] args) {
        SpringApplication.run(Cloudconfigclient3366.class,args);
    }
}
