package com.cloudconfigclient3355.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${eureka.instance.instance-id}")
    private Object configInfo;

    @GetMapping("/configInfo")
    public Object getConfigInfo(){
        return configInfo;
    }
}




