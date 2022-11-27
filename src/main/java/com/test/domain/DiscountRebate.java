package com.test.domain;


import com.test.constants.ProductEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Map;


/*
* 打折活动
* 部分商品限时打折
* */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiscountRebate extends DiscountBase{
    private Map<Product, Float> discountMap;       // 商品-优惠力度

    /*
     * 计算优惠
     * 返回优惠过后的总价
     *
     * */
    public Person discount(Person customer) {
        ShoppingCart shoppingCart = customer.getShoppingCart();
        Map<Product, Integer> products = shoppingCart.getProducts();
        Integer count = products.get(Supermarket.PRODUCT_MAP.get(ProductEnum.STRAWBERRY));  // 删除前先拿到对象值，待会有用
        if (count == null){     // 购物车没这个商品
            return customer;
        }
        products.remove(Supermarket.PRODUCT_MAP.get(ProductEnum.STRAWBERRY));        // 先删除，因为待会要改变这个key对象了
        Product strawberry = new Product(2,"草莓", new BigDecimal(13).multiply(new BigDecimal("0.8")), "P0002");
        products.put(strawberry, count);
        return customer;
    }

}
