package com.sjl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author songjilong
 * @date 2020/4/28 12:59
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConfigClientMain3377 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientMain3377.class, args);
    }
}
