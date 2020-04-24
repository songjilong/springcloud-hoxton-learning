package com.sjl.springcloud.feign;

import com.sjl.springcloud.service.PaymentFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author songjilong
 * @date 2020/4/24 14:50
 */
@FeignClient(value = "CLOUD-PAYMENT-HYSTRIX-SERVICE", fallback = PaymentFallbackService.class)
public interface HystrixPaymentService {
    @GetMapping("/hystrix/payment/ok/{id}")
    String paymentInfoOk(@PathVariable("id") Long id);

    @GetMapping("/hystrix/payment/timeout/{id}")
    String paymentInfoTimeout(@PathVariable("id") Long id);
}
