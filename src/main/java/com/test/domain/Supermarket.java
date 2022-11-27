package com.test.domain;


import com.test.constants.ProductEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;


@Data
public class Supermarket extends BaseEntity{

//    public static Map<Product, Float> STOCK;  // 库存  商品-多少斤
    public static Map<ProductEnum, Product> PRODUCT_MAP = new EnumMap<>(ProductEnum.class);  // 商品列表
    public static List<Cashier> CASHIER_LIST = new ArrayList<>();  // 收银台

    // 初始化 商品列表，货架
    static {
        Product apple = new Product(1,"苹果", new BigDecimal(8), "P0001");
        Product strawberry = new Product(2,"草莓", new BigDecimal(13), "P0002");

//        STOCK.put(apple, 100F);
//        STOCK.put(mango, 100F);
//        STOCK.put(strawberry, 100F);
        PRODUCT_MAP.put(ProductEnum.APPLE, apple);
        PRODUCT_MAP.put(ProductEnum.STRAWBERRY, strawberry);
        Cashier cashier1 = new Cashier(1, "收银台1");
        Cashier cashier2 = new Cashier(2, "收银台2");
        Cashier cashier3 = new Cashier(3, "收银台3");
        CASHIER_LIST.add(cashier1);
        CASHIER_LIST.add(cashier2);
        CASHIER_LIST.add(cashier3);
    }



}
