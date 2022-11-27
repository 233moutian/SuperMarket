package com.test.domain;

import lombok.Data;

import java.math.BigDecimal;

/*
* 无活动，返回正常价
* */
@Data
public class DiscountNormal extends DiscountBase{

    /*
    * 返回优惠过后的总价
    *
    * */
    public BigDecimal arithmetic(BigDecimal money) {
        return money;
    }
}
