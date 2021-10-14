package com.seataorderservice2001;

import com.seataorderservice2001.uitll.SnowFlakeAuto;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

import javax.sql.DataSource;
import java.util.Arrays;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.seataorderservice2001.dao")
public class Seataorderservice2001 {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Seataorderservice2001.class, args);
        DataSource bean = run.getBean(DataSource.class);
        String[] beanNamesForType = run.getBeanNamesForType(DataSource.class);
        System.out.println("**********************************************************************************************************************************");
        System.out.println(bean.getClass());
        System.out.println("**********************************************************************************************************************************");
        Arrays.stream(beanNamesForType).forEach(System.out::println);
        System.out.println("**********************************************************************************************************************************");
        SnowFlakeAuto bean1 = run.getBean(SnowFlakeAuto.class);
        System.out.println(bean1.getSnowFlake());
        System.out.println("**********************************************************************************************************************************");
    }
}
