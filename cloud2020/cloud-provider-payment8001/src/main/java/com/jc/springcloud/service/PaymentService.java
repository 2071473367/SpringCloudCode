package com.jc.springcloud.service;

import com.jc.springcloud.entitys.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    /**
     * 根据id获取信息
     * @param id
     * @return
     */
    Payment getPaymentById(@Param("id") Long id);

    /**
     * 创建
     * @param payment
     * @return
     */
    Integer create(Payment payment);
}
