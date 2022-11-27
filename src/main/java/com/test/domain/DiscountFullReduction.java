package com.test.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


/*
* 满减活动
* 总额满减
*
* */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiscountFullReduction extends DiscountBase{
    //满足价格
    private BigDecimal fullPrice;
    //减的价格
    private BigDecimal reductionPrice;

    /*
    * 满减结算
    *
    * */
    public BigDecimal arithmetic(BigDecimal originalPrice) {
        if (originalPrice.compareTo(BigDecimal.ZERO) < 0){
            return BigDecimal.ZERO;
        }
        if (originalPrice.compareTo(fullPrice) < 0){
            return originalPrice;
        }
        return originalPrice.subtract(reductionPrice).setScale(2,BigDecimal.ROUND_HALF_UP);
    }


}
