package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.common.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author cuiminjie
 * @Date 2022 07 21 21 56
 **/
@RestController
@RequestMapping("order")
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    private static final String URL = "http://localhost:8001";

    @PostMapping("/addPayment")
    public CommonResult addPayment(@RequestBody Payment payment) {
        return restTemplate.postForObject(URL + "/payment/addPayment", payment, CommonResult.class);
    }

    @GetMapping("/getPaymentById")
    public CommonResult<Payment> getPaymentById(@RequestParam Long id) {
        return restTemplate.getForObject(URL + "/payment/getPaymentById?id="+id, CommonResult.class);
    }
}
