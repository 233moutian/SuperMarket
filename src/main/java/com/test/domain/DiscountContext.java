package com.test.domain;

import com.test.constants.DiscountEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.EnumMap;
import java.util.Map;


/*
 * 打折选择
 * 策略模式
 *
 * */
@Data
@AllArgsConstructor
public class DiscountContext {
    public static Map<DiscountEnum, DiscountBase> psMap = new EnumMap<>(DiscountEnum.class);

    /*
     * 初始化优惠
     *
    static {
        Map<Product, Float> discountMap = new HashMap<>();
        discountMap.put(Supermarket.PRODUCT_MAP.get(ProductEnum.MANGO), 0.8F);
        psMap.put(DiscountEnum.EIGHTFOLD, new DiscountRebate(discountMap));
        psMap.put(DiscountEnum.SPECIAL_TEN, new DiscountFullReduction(new BigDecimal(100), new BigDecimal(10)));
    }*/

    public static DiscountBase getDiscount(DiscountEnum discountType) {
        DiscountBase discount;
        switch (discountType) {
            case SPECIAL_TEN:
                return psMap.get(DiscountEnum.SPECIAL_TEN);
            case EIGHTFOLD:
                return psMap.get(DiscountEnum.EIGHTFOLD);
            default:
                discount = new DiscountNormal();
                return discount;
        }
    }
}
