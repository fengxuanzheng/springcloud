package com.seataorderservice2001.pojo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Data
@Component
@Slf4j
public class Person {

    private String name;
    @Autowired
    public void init()
    {
        log.info("测试自动注入初始化******************************************************************88");
        log.info("自动初始化结束");
    }
}
