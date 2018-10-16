package com.mytest.dubbo.gmall.service;


import com.mytest.dubbo.gmall.bean.UserAddress;

import java.util.List;

//本地存根,用于在远程调用前进行参数检测等
public class UserServiceStub implements UserService{

    private final UserService userService;

    /**
     * 需要使用有参构造器
     * 传入的是远程UserService的代理对象
     * @param userService
     */
    public UserServiceStub(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<UserAddress> getUserAddressList(String userId) {

        if (null != userId && userId != ""){
         return userService.getUserAddressList(userId);
        }
        return null;
    }
}
