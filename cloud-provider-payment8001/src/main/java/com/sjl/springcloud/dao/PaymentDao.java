package com.sjl.springcloud.dao;

import com.sjl.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author songjilong
 * @date 2020/4/18 21:15
 */
@Mapper
public interface PaymentDao {

    /**
     * 插入订单数据
     *
     * @param payment
     * @return
     */
    int create(Payment payment);

    /**
     * 根据 id 查询订单数据
     *
     * @param id
     * @return
     */
    Payment getPaymentById(@Param("id") Long id);
}
