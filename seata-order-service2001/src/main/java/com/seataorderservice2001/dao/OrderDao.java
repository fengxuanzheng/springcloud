package com.seataorderservice2001.dao;

import com.seataorderservice2001.pojo.Order;
import org.apache.ibatis.annotations.Param;

public interface OrderDao
{
    //新建订单
    void create(Order order);

    //修改订单状态，从零改为1
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}