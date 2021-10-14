package com.cloudalibabasentinelservice8401.exceptionHandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cloudapicommons.frontResultData.CommonResult;

public class CustomerBlockHandler {

    public static CommonResult handlerExcepiton01(BlockException exception)
    {
        return new CommonResult(426,"SentinelResource全局自定义处理01:"+exception.getMessage());
    }
    public static CommonResult handlerExcepiton02(BlockException exception)
    {
        return new CommonResult(426,"SentinelResource全局自定义处理02:"+exception.getMessage());
    }
}
