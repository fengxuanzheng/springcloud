package com.cloudalibabaconsumernacosorder84.service;

import com.cloudapicommons.frontResultData.CommonResult;
import com.cloudapicommons.pojo.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentService
{
    @Override
    public CommonResult<Payment> paymentSQL(Long id)
    {
        return new CommonResult<>(44444,"服务降级返回,使用openFeigein,---PaymentFallbackService",new Payment(id,"errorSerial"));
    }
}
