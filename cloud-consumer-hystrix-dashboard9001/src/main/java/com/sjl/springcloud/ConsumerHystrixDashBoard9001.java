package com.sjl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author songjilong
 * @date 2020/4/24 23:10
 */
@SpringBootApplication
@EnableHystrixDashboard
public class ConsumerHystrixDashBoard9001 {
    public static void main(String[] args){
        SpringApplication.run(ConsumerHystrixDashBoard9001.class, args);
    }
}
