package com.sjl.springcloud.controller;

import com.sjl.springcloud.entities.CommonResult;
import com.sjl.springcloud.entities.Payment;
import com.sjl.springcloud.feign.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author songjilong
 * @date 2020/4/23 10:58
 */
@RestController
public class OrderFeignController {
    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getById(@PathVariable("id") Long id){
        return paymentFeignService.getById(id);
    }

    @GetMapping("/consumer/payment/timeout")
    public String timeout(){
        // Feign默认等待1秒钟
        return paymentFeignService.timeout();
    }
}
