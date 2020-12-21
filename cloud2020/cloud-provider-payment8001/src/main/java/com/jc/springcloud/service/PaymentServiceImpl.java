package com.jc.springcloud.service;

import com.jc.springcloud.dao.PaymentDao;
import com.jc.springcloud.entitys.Payment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }

    @Override
    public Integer create(Payment payment) {
        return paymentDao.create(payment);
    }
}
