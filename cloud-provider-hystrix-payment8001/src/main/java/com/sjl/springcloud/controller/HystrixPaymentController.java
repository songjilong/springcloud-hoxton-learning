package com.sjl.springcloud.controller;

import com.sjl.springcloud.service.impl.HystrixPaymentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author songjilong
 * @date 2020/4/24 11:01
 */
@RestController
@Slf4j
public class HystrixPaymentController {

    @Autowired
    private HystrixPaymentServiceImpl hystrixPaymentService;


    @GetMapping("/hystrix/payment/ok/{id}")
    public String paymentInfoOk(@PathVariable("id") Long id){
//        int i = 1 / 0;
        String result = hystrixPaymentService.paymentInfoOk(id);
        log.info(result);
        return result;
    }

    @GetMapping("/hystrix/payment/timeout/{id}")
    public String paymentInfoTimeout(@PathVariable("id") Long id){
        String result = hystrixPaymentService.paymentInfoTimeout(id);
        log.info(result);
        return result;
    }

    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuit(@PathVariable("id") Long id){
        return hystrixPaymentService.paymentCircuitBreaker(id);
    }
}
