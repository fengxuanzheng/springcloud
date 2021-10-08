package com.cloudconsumerorder80.config;

import com.cloudconsumerorder80.pojo.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExConfig {

    @Bean
    public Person person()
    {
        return new Person("欧尼酱",16);
    }
}
