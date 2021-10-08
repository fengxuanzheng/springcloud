package com.cloudconsumerfeignhystrixorder80.server;

import com.cloudapicommons.frontResultData.CommonResult;
import com.cloudapicommons.pojo.Payment;
import org.springframework.stereotype.Component;

@Component
public class OpenFeigServerImpl implements  OpenFeigServer{
    @Override
    public CommonResult<Payment> selectPayment(Long id) {
        return null;
    }

    @Override
    public String paymentInfo_OK(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_OK , (┬＿┬)";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_TimeOut , (┬＿┬)";
    }
}
