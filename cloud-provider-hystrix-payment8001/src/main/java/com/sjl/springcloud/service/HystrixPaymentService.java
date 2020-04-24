package com.sjl.springcloud.service;

/**
 * @author songjilong
 * @date 2020/4/24 10:57
 */
public interface HystrixPaymentService {
    String paymentInfoOk(Long id);
    String paymentInfoTimeout(Long id);
}
