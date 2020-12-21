package com.jc.springcloud.controller;

import com.jc.springcloud.entitys.CommonResult;
import com.jc.springcloud.entitys.Payment;
import com.jc.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

//    @Resource
//    private DiscoveryClient discoveryClient;

    @GetMapping("payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);

        log.info("==================结果：" +serverPort, payment);


        CommonResult commonResult = null;
        if (null != payment) {
            commonResult = new CommonResult(200, "查询成功~~~", serverPort + "," + payment);
        } else {
            commonResult = new CommonResult(444, "没有对应编号的信息~~~");
        }
        return commonResult;
    }

    @PostMapping("payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        Integer result = paymentService.create(payment);

        log.info("/n================结果：" + serverPort, result);
        log.info("/n================参数：" + serverPort, payment);

        CommonResult commonResult = null;

        if (null != result && result > 0) {
            commonResult = new CommonResult(200, "创建成功~~~", serverPort + "," + result);
        } else {
            commonResult = new CommonResult(444, "创建失败~~~");
        }
        return commonResult;
    }

//    @GetMapping("payment/discovery")
//    public Object discovery() {
//        // 获取注册中心中所有入驻的微服务
//        List<String> services = discoveryClient.getServices();
//        for (String str :
//                services) {
//            log.info("=================" + str);
//        }
//
//        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
//        for (ServiceInstance serviceInstance:
//             instances) {
//            log.info(serviceInstance.getServiceId() + "\t" + serviceInstance.getHost() +"\t" + serviceInstance.getPort() + "\t" + serviceInstance.getUri());
//        }
//        return this.discoveryClient;
//    }
}
