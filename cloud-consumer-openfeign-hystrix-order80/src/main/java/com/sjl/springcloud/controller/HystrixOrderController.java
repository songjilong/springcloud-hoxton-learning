package com.sjl.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.sjl.springcloud.feign.HystrixPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author songjilong
 * @date 2020/4/24 14:53
 */
@RestController
@DefaultProperties(defaultFallback = "globalFallbackMethod")
public class HystrixOrderController {

    @Autowired
    private HystrixPaymentService hystrixPaymentService;

    @GetMapping("/consumer/hystrix/payment/ok/{id}")
    public String paymentInfoOk(@PathVariable("id") Long id) {
        return hystrixPaymentService.paymentInfoOk(id);
    }

    @GetMapping("/consumer/hystrix/payment/timeout/{id}")
    /*@HystrixCommand(fallbackMethod = "timeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })*/
    @HystrixCommand
    public String paymentInfoTimeout(@PathVariable("id") Long id) {
        int i = 1/0;
        return hystrixPaymentService.paymentInfoTimeout(id);
    }

    public String timeoutHandler(Long id) {
        return "线程：" + Thread.currentThread().getName() + "；paymentInfoTimeoutHandler，id：" + id + "；服务器繁忙或本机出故障";
    }
    public String globalFallbackMethod() {
        return "全局处理方法：服务器繁忙或本机出故障";
    }
}
