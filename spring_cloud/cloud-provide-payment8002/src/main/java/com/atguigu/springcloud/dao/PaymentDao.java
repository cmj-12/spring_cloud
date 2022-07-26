package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author cuiminjie
 * @Date 2022 07 19 21 57
 **/
@Mapper
public interface PaymentDao {
    /**
     * 增加支付
     */
    public int addPayment(Payment payment);

    /**
     * 通过id查询支付
     */
    public Payment getPaymentById(@Param("id") Long id);

}
