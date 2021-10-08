package com.cloudconsumerzookeeperorder80.controller;


import com.cloudapicommons.frontResultData.CommonResult;
import com.cloudapicommons.pojo.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderContrller {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/sendCreate")
    public CommonResult<Payment> craete(Payment payment)
    {
      log.info(payment.toString());
        return restTemplate.postForObject("http://CLOUD-PROVIDER-PAYMENT/createPayment",payment, CommonResult.class);
    }
    @GetMapping("/selectSendPayment/{id}")
    public CommonResult<Payment> selectSendPayment(@PathVariable("id") Long id)
    {

        return restTemplate.getForObject("http://CLOUD-PROVIDER-PAYMENT/selectPayment/"+id,CommonResult.class);

    }
    @GetMapping("/sendzkMsg")
    public Object sendzkMsg()
    {
        return restTemplate.getForObject("http://cloud-provider-payment/getClientMessage",Object.class);
    }
}
