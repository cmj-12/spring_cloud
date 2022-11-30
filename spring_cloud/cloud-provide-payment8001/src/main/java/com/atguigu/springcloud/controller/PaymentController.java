package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.common.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @Author cuiminjie
 * @Date 2022 07 19 22 12
 **/
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/addPayment")
    public CommonResult<Integer> addPayment(@RequestBody Payment payment) {
        int i = paymentService.addPayment(payment);
        if (i > 0) {
            return new CommonResult<>(200, "新增成功,服务端口是" + serverPort, i);
        } else {
            return new CommonResult<>(444, "新增失败");
        }
    }

    @GetMapping("/getPaymentById")
    public CommonResult<Payment> getPaymentById(@RequestParam Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("哈哈h1" + payment);
        if (Objects.nonNull(payment)) {
            return new CommonResult<>(200, "查询成功,服务端口是" + serverPort, payment);
        } else {
            return new CommonResult<>(444, "查询失败");
        }
    }

    @GetMapping("/getDiscoveryClient")
    public DiscoveryClient getDiscoveryClient() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info(service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }

        return this.discoveryClient;
    }
}
