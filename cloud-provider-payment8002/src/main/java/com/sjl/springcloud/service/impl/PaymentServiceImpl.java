package com.sjl.springcloud.service.impl;

import com.sjl.springcloud.dao.PaymentDao;
import com.sjl.springcloud.entities.Payment;
import com.sjl.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author songjilong
 * @date 2020/4/18 21:19
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
