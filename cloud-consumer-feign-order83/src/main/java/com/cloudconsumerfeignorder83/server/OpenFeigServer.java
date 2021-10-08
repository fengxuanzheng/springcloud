package com.cloudconsumerfeignorder83.server;

import com.cloudapicommons.frontResultData.CommonResult;
import com.cloudapicommons.pojo.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(value ="CLOUD-PROVIDER-PAYMENT" )
public interface OpenFeigServer {

    @GetMapping("/selectPayment/{id}")
    public CommonResult<Payment> selectPayment(@PathVariable("id") Long id);
}
