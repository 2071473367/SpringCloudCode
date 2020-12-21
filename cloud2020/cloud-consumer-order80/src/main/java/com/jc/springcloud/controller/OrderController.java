package com.jc.springcloud.controller;

import com.jc.springcloud.entitys.CommonResult;
import com.jc.springcloud.entitys.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {

//    private final static String PAYMENT_URL = "http://localhost:8001";
    private final static String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;


    @GetMapping("consumer/payment/create")
    public CommonResult create(Payment  payment) {
        System.out.println(payment);
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create", payment, CommonResult.class);
    }

    @GetMapping("consumer/payment/discoveryclient")
    public Object discovery() {
        return  restTemplate.getForObject(PAYMENT_URL + "/payment/discovery", null);
    }


    @GetMapping("consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }
}
