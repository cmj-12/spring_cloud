package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entity.Payment;

/**
 * @Author cuiminjie
 * @Date 2022 07 19 22 09
 **/
public interface PaymentService {
    /**
     * 增加支付
     */
    public int addPayment(Payment payment);

    /**
     * 通过id查询支付
     */
    public Payment getPaymentById(Long id);
}
