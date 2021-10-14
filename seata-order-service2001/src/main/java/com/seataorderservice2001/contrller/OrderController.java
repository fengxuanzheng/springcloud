package com.seataorderservice2001.contrller;

import com.seataorderservice2001.pojo.CommonResult;
import com.seataorderservice2001.pojo.Order;
import com.seataorderservice2001.server.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController{
    @Resource
    private OrderService orderService;


    @GetMapping("/order/create")
    public CommonResult create(Order order)
    {
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }
}

