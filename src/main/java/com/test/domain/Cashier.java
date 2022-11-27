package com.test.domain;


import com.test.exception.BusinessException;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Map;


/*
 * 收银台
 * 给客户结算；扣除库存
 * */
@Data
@NoArgsConstructor
public class Cashier extends BaseEntity {

    public BigDecimal settle(Person customer) throws BusinessException {
        BigDecimal result = new BigDecimal(0);
        // Variable used in lambda expression should be final or effectively final
        Map<Product, Integer> shoppingCartProducts = customer.getShoppingCart().getProducts();
        for (Map.Entry<Product, Integer> entry : shoppingCartProducts.entrySet()) {
            Product key = entry.getKey();
            Integer value = entry.getValue();
            if (value <= 0){    // 可以写得更加详细
                throw new BusinessException("异常的购物数量");
            }

            BigDecimal multiply = key.getPrice().multiply(new BigDecimal(value));
            System.out.print("商品" + key.getName() + "的单价为：" + key.getPrice() + ", 总价为" + multiply.toString() + "元。");
            result = result.add(multiply);
        }
        return result;
    }


    public Cashier(Integer id, String name) {
        super.id = id;
        super.name = name;
    }


}
