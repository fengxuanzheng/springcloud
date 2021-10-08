package com.cloudconsumerorder80;

import com.cloudconsumerorder80.pojo.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
//@RibbonClient(value = "CLOUDPROVIDERPAYMENT",configuration = LoadBalancerConfig.class)
public class CloudConsumerOrder80 {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(CloudConsumerOrder80.class, args);
        Person bean = run.getBean(Person.class);
        System.out.println(bean);

    }
}
