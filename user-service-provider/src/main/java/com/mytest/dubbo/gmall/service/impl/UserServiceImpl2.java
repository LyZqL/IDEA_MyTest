package com.mytest.dubbo.gmall.service.impl;

import java.util.Arrays;
import java.util.List;

import com.mytest.dubbo.gmall.bean.UserAddress;
import com.mytest.dubbo.gmall.service.UserService;

public class UserServiceImpl2 implements UserService {

    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        System.out.println("UserServiceImpl.....new...");
        // TODO Auto-generated method stub
        UserAddress address1 = new UserAddress(1, "北京市昌平区华龙苑中里22号楼3单元", "1", "我不知道", "17610110000", "Y");
        UserAddress address2 = new UserAddress(2, "安徽省阜阳市颍州区天瑞名城A区", "1", "你猜我叫啥", "13991820000", "N");

        return Arrays.asList(address1, address2);
    }

}
