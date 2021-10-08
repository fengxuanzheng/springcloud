package com.cloudconsumerorder80.controller;


import com.cloudapicommons.frontResultData.CommonResult;
import com.cloudapicommons.pojo.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@RestController
@Slf4j
public class OrderContrller {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/sendCreate")
    public CommonResult<Payment> craete(Payment payment)
    {
      log.info(payment.toString());
        return restTemplate.postForObject("http://CLOUD-PROVIDER-PAYMENT/createPayment",payment, CommonResult.class);
    }
    @GetMapping("/selectSendPayment/{id}")
    public CommonResult<Payment> selectSendPayment(@PathVariable("id") Long id)
    {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-PAYMENT");
        instances.forEach(item->{
            URI uri = item.getUri();
            log.info("服务端的"+uri.toString());
        });
        return restTemplate.getForObject("http://CLOUD-PROVIDER-PAYMENT/selectPayment/"+id,CommonResult.class);

    }

    @GetMapping("/selectEntriyPayment/{id}")
    public ResponseEntity<CommonResult> selectEntriyPayment(@PathVariable Long id)
    {
        ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity("http://CLOUD-PROVIDER-PAYMENT/selectPayment/" + id, CommonResult.class);
        log.info(forEntity.toString());
        HttpHeaders headers = forEntity.getHeaders();
        log.info(headers.toString());
        return forEntity;
    }


}
