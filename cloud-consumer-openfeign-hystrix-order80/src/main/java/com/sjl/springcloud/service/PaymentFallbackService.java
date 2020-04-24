package com.sjl.springcloud.service;

import com.sjl.springcloud.feign.HystrixPaymentService;
import org.springframework.stereotype.Component;

/**
 * @author songjilong
 * @date 2020/4/24 17:37
 */
@Component
public class PaymentFallbackService implements HystrixPaymentService {
    @Override
    public String paymentInfoOk(Long id) {
        return "PaymentFallbackService...paymentInfoOk..." + id;
    }

    @Override
    public String paymentInfoTimeout(Long id) {
        return "PaymentFallbackService...paymentInfoTimeout..." + id;
    }
}
