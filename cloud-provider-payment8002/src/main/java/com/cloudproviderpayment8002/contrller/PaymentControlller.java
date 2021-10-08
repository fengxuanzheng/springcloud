package com.cloudproviderpayment8002.contrller;

import com.alibaba.fastjson.JSON;
import com.cloudapicommons.frontResultData.CommonResult;
import com.cloudapicommons.pojo.Payment;
import com.cloudproviderpayment8002.server.PaymentServer;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
public class PaymentControlller {

    @Autowired
    private PaymentServer paymentServer;
    @Value("${server.port}")
    private String port;


    @PostMapping("/createPayment")
    public CommonResult<Integer> craetePayment(@RequestBody Payment payment)
    {
      log.info(payment.toString());
        int i = paymentServer.create(payment);
        if (i!=0)
        {
            return new CommonResult<>(200,"数据库插入成功端口号:"+port,i);
        }
        else
        {
            return new CommonResult<>(444,"数据库插入失败端口号:"+port,null);
        }
    }

    @GetMapping("/selectPayment/{id}")
    public CommonResult<Payment> selectPayment(@PathVariable("id") Long id, HttpServletRequest httpServletRequest) {
        String red = httpServletRequest.getParameter("red");
        log.info(red);
        Payment payment = paymentServer.selectPaymentById(id);
        if (payment!=null)
        {
            return new CommonResult<>(200,"查询成功,端口号:8002",payment);
        }
        else
        {
            return new CommonResult<>(444,"查询失败,查询ID:"+id,null);
        }
    }
    @GetMapping("/jsonSend")
    public CommonResult<Integer> craetePaymentforJson(String payment) throws JsonProcessingException {
        log.info(payment);
        Payment payment1 = JSON.parseObject(payment, Payment.class);
        int i = paymentServer.create(payment1);
        if (i!=0)
        {
            return new CommonResult<>(200,"数据库插入成功端口号:"+port,i);
        }
        else
        {
            return new CommonResult<>(444,"数据库插入失败端口号:"+port,null);
        }
    }
}
