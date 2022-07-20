package com.atguigu.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author cuiminjie
 * @Date 2022 07 19 21 52
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment implements Serializable {
    /**
     * id
     */
    private Integer id;
    /**
     * 支付流水号
     */
    private String serial;
}
