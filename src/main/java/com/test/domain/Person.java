package com.test.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;

@Data
public class Person extends BaseEntity{
    private BigDecimal money;           // 兜里的钱

    private Map<Product, Integer> products;     // 买到手的商品
    private ShoppingCart shoppingCart;  // 购物车
}
