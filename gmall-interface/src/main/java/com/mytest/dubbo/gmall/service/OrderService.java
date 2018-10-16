package com.mytest.dubbo.gmall.service;

import java.util.List;

import com.mytest.dubbo.gmall.bean.UserAddress;

public interface OrderService {

    /**
     * 初始化订单
     */
    public List<UserAddress> initOrder(String userId);

}
