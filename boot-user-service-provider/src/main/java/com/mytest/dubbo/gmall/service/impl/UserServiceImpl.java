package com.mytest.dubbo.gmall.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.mytest.dubbo.gmall.bean.UserAddress;
import com.mytest.dubbo.gmall.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@Service//暴露服务 这个是dubbo的注解
@Component
public class UserServiceImpl implements UserService {

    @HystrixCommand//服务容错
    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        // TODO Auto-generated method stub
        System.out.println("UserServiceImpl..3.....");
        UserAddress address1 = new UserAddress(1, "北京市昌平区华龙苑中里22号楼3单元", "1", "我不知道", "17610110000", "Y");
        UserAddress address2 = new UserAddress(2, "安徽省阜阳市颍州区天瑞名城A区", "1", "你猜我叫啥", "13991820000", "N");
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
        if (Math.random() > 0.5) {
            throw new RuntimeException();
        }
        return Arrays.asList(address1, address2);
    }

}
