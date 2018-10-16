package com.mytest.dubbo.gmall.service.impl;

import java.util.Arrays;
import java.util.List;

import com.mytest.dubbo.gmall.bean.UserAddress;
import com.mytest.dubbo.gmall.service.OrderService;
import com.mytest.dubbo.gmall.service.UserService;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * 1、将服务提供者注册到注册中心（暴露服务）
 * 1）、导入dubbo依赖（2.6.2）\操作zookeeper的客户端(curator)
 * 2）、配置服务提供者
 * <p>
 * 2、让服务消费者去注册中心订阅服务提供者的服务地址
 *
 * @author lfy
 */
@Service
public class OrderServiceImpl implements OrderService {

    //@Autowired
    //@Reference(url = "127.0.0.1:20881")  //绕过注册中心,进行dubbo直连
    //loadbalance--远程调用轮询策略
    @Reference(loadbalance = "random", timeout = 1000)
    UserService userService;

    @HystrixCommand(fallbackMethod = "hello")//整合Hystrix进行服务容错  指定出现错误运行的方法hello
    @Override
    public List<UserAddress> initOrder(String userId) {
        // TODO Auto-generated method stub
        System.out.println("用户id：" + userId);
        //1、查询用户的收货地址
        List<UserAddress> addressList = userService.getUserAddressList(userId);
        return addressList;
    }


    public List<UserAddress> hello(String userId) {
        // TODO Auto-generated method stub
        return Arrays.asList(new UserAddress(10, "测试地址", "1", "测试", "测试", "Y"));
    }


}
