package com.seataorderservice2001.server;


import com.seataorderservice2001.pojo.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "seata-storage-service")
public interface StorageService{
    @GetMapping(value = "/storage/decrease")
    CommonResult decrease(@RequestParam("productId")Long productId,  @RequestParam("count")Integer count);
}