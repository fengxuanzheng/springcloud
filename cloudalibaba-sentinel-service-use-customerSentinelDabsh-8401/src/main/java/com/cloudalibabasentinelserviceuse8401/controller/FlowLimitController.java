package com.cloudalibabasentinelserviceuse8401.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@Slf4j
public class FlowLimitController
{
    @GetMapping("/testA")
    public String testA() throws InterruptedException {
        //Thread.sleep(500);
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("/testA").forward(httpServletRequest,httpServletResponse);
        log.info("调用B");
        log.info("开始转发");
        return "------testB";
    }
    @GetMapping("/testC")
    public String testC(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws ServletException, IOException, InterruptedException {
        log.info("调用C");
        Thread.sleep(800);
        return "------testC";
    }
    @GetMapping("/testD")
    public String testD(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("/testA").forward(httpServletRequest,httpServletResponse);
        log.info("调用D");
        int i=10/0;
        return "------testD";
    }
    @GetMapping("/testHotKey")
    @SentinelResource(value ="/testHotKey",blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false)String p1,@RequestParam(value = "p2",required = false) String p2)
    {
        int i=10/0;
        return "返回的热点测试,参数:"+p1+"___"+p2;
    }

    public String deal_testHotKey(String p1, String p2, BlockException blockException)
    {
        return "熔断兜底方法";
    }

}