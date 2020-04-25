package com.sjl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author songjilong
 * @date 2020/4/25 13:01
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudGateway9527 {
    public static void main(String[] args){
        SpringApplication.run(CloudGateway9527.class, args);
    }
}
