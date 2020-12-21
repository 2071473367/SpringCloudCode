package com.jc.springcloud.dao;

import com.jc.springcloud.entitys.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {
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
