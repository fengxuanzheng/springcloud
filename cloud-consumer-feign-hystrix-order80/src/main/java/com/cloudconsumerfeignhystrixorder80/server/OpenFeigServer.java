package com.cloudconsumerfeignhystrixorder80.server;

import com.cloudapicommons.frontResultData.CommonResult;
import com.cloudapicommons.pojo.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(value ="CLOUD-PROVIDER-PAYMENT",fallback = OpenFeigServerImpl.class)
public interface OpenFeigServer {

    @GetMapping("/selectPayment/{id}")
    public CommonResult<Payment> selectPayment(@PathVariable("id") Long id);
     @GetMapping(value = "/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id")Integer id);
    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id);
}
