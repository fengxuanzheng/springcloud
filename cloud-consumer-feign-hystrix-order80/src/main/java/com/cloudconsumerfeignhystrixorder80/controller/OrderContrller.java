package com.cloudconsumerfeignhystrixorder80.controller;


import com.cloudapicommons.frontResultData.CommonResult;
import com.cloudapicommons.pojo.Payment;
import com.cloudconsumerfeignhystrixorder80.server.OpenFeigServer;
import com.cloudconsumerfeignhystrixorder80.server.PaymentServer;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderContrller {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private OpenFeigServer openFeigServer;
    @Autowired
    private PaymentServer paymentServer;

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
    @GetMapping("/selectSendPaymentUseFeign/{id}")
    public CommonResult<Payment> selectSendPaymentUseOpenFeig(@PathVariable("id") Long id)
    {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-PAYMENT");
        instances.forEach(item->{
            URI uri = item.getUri();
            log.info("服务端的"+uri.toString());
        });
        return openFeigServer.selectPayment(id);

    }

    //***************************************熔断器*****************************************


    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        String result =openFeigServer.paymentInfo_OK(id);
        log.info("*******result:"+result);
        return result;
    }
    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        String result = paymentServer.paymentInfo_TimeOut(id);
        log.info("*******result:"+result);
        return result;
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "8000")  //3秒钟以内就是正常的业务逻辑,fallbackMethod,如果不标注fallbackMethod则默认使用全局fallback方法,如果Feign接口的@FeignClient设置了fallback那最终以他为准
    })
    public String paymentInfo_TimeOut_hystrix(@PathVariable("id") Integer id){
        String result =openFeigServer.paymentInfo_TimeOut(id);
        return result;
    }

    //兜底方法
    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id){
        return "我是消费者80，对付支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己,(┬＿┬)"+"ID:"+id;
    }
    //下面是全局fallback方法
    public String payment_Global_FallbackMethod(){
        return "Global异常处理信息，请稍后再试,(┬＿┬)";
    }
}
