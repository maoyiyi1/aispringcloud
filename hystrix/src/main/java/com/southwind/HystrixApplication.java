package com.southwind;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker  //声明启用数据监控
@EnableHystrixDashboard //声明启用可视化的数据监控
public class HystrixApplication {
    //启动成功之后，访问http://localhost:8060/hystrix/ 可以看到可视化的监控界面
    //输入要监控的节点：http://localhost:8060/actuator/hystrix.stream
    public static void main(String[] args) {
        SpringApplication.run(HystrixApplication.class,args);
    }
}
