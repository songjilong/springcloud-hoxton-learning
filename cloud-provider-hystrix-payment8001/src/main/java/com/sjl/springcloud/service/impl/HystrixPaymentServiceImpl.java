package com.sjl.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.sjl.springcloud.service.HystrixPaymentService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author songjilong
 * @date 2020/4/24 10:58
 */
@Service
public class HystrixPaymentServiceImpl implements HystrixPaymentService {
    @Override
    public String paymentInfoOk(Long id) {
        return "线程：" + Thread.currentThread().getName() + "；paymentInfoOk，id：" + id;
    }

    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    @Override
    public String paymentInfoTimeout(Long id) {
        int time = 3000;
        try {
            TimeUnit.MILLISECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //int i = 10 / 0;
        return "线程：" + Thread.currentThread().getName() + "；paymentInfoTimeout，id：" + id + "；耗时（秒）：" + time;
    }

    public String paymentInfoTimeoutHandler(Long id) {
        return "线程：" + Thread.currentThread().getName() + "；paymentInfoTimeoutHandler，id：" + id + "；服务器繁忙";
    }

    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60") //失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(Long id) {
        if (id < 0) {
            throw new RuntimeException("id 不能为负数");
        }
        return Thread.currentThread().getName() + "\t" + "调用成功，流水号：" + IdUtil.simpleUUID();
    }

    public String paymentCircuitBreakerFallback(Long id) {
        return "id 不能为负数，你的id = " + id;
    }
}
