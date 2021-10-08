package com.cloudconfigcenter3344;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer
public class Cloudconfigcenter3344 {
    public static void main(String[] args) {
        SpringApplication.run(Cloudconfigcenter3344.class,args);
    }
}
