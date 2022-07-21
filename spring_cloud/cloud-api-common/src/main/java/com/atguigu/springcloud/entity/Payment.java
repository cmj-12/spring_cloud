package com.atguigu.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author cuiminjie
 * @Date 2022 07 21 22 53
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment implements Serializable {
    /**
     * id
     */
    private Long id;
    /**
     * 支付流水号
     */
    private String serial;
}
