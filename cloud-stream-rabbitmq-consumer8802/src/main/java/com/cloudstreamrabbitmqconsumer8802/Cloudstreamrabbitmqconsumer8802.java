package com.cloudstreamrabbitmqconsumer8802;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Cloudstreamrabbitmqconsumer8802 {
    public static void main(String[] args) {
        SpringApplication.run(Cloudstreamrabbitmqconsumer8802.class,args);
    }
}
