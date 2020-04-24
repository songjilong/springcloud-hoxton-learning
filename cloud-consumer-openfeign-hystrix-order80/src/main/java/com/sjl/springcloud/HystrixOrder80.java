package com.sjl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author songjilong
 * @date 2020/4/24 14:49
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class HystrixOrder80 {
    public static void main(String[] args){
        SpringApplication.run(HystrixOrder80.class, args);
    }
}
