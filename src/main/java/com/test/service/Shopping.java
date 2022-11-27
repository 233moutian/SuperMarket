package com.test.service;

import com.test.constants.DiscountEnum;
import com.test.constants.ProductEnum;
import com.test.domain.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Shopping {



    public static void main(String[] args) {

        /*
        * 1、有一家超市，出售苹果和草莓。其中苹果 8 元/斤，草莓 13 元/斤。
            现在顾客 A 在超市购买了若干斤苹果和草莓，需要计算一共多少钱？
            请编写函数，对于 A 购买的水果斤数 (水果斤数为大于等于 0 的整数)，计算并返回所购买商品的总价。
        *
        * */
        DiscountBase discount = DiscountContext.getDiscount(DiscountEnum.NO_DISCOUNT);
        int appleCountA = new Random().nextInt(10);         // 题目没写要多少斤，先随机一下. 忽视库存问题
        int strawberryCountA = new Random().nextInt(10);
        Person customerA = new Person();                        // 定义客户
        ShoppingCart shoppingCartA = new ShoppingCart();        // 定义客户的购物车
        Map<Product, Integer> shoppingCartProductsA = new HashMap<>();
        shoppingCartA.setProducts(shoppingCartProductsA);
        shoppingCartProductsA.put(Supermarket.PRODUCT_MAP.get(ProductEnum.APPLE), appleCountA);
        shoppingCartProductsA.put(Supermarket.PRODUCT_MAP.get(ProductEnum.STRAWBERRY), strawberryCountA);
        customerA.setShoppingCart(shoppingCartA);

        BigDecimal resultA = new Cashier().settle(customerA);// 结算，需要收银台
        customerA.setProducts(shoppingCartProductsA);        // 结账后需要把货物给客户
        customerA.setShoppingCart(null);                // 清空购物车
        System.out.println("客户A所购买的商品:" +ProductEnum.APPLE.getName() + "重量：" + appleCountA + "斤;"
                +ProductEnum.STRAWBERRY.getName() + "重量：" + strawberryCountA + "斤。总价： " + resultA.toString());


        /*
        * 2、超市增加了一种水果芒果，其定价为 20 元/斤。
            现在顾客 B 在超市购买了若干斤苹果、 草莓和芒果，需计算一共需要多少钱？
            请编写函数，对于 B 购买的水果斤数 (水果斤数为大于等于 0 的整数)，计算并返回所购买商品的总价。
        *
        * */
        Product mango = new Product(3,"芒果", new BigDecimal(20), "P0003");
        Supermarket.PRODUCT_MAP.put(ProductEnum.MANGO, mango);
        int appleCountB = new Random().nextInt(10);         // 题目没写要多少斤，先随机一下. 忽视库存问题
        int strawberryCountB = new Random().nextInt(10);
        int mongoCountB = new Random().nextInt(10);

        Person customerB = new Person();
        ShoppingCart shoppingCartB = new ShoppingCart();
        Map<Product, Integer> shoppingCartProductsB = new HashMap<>();
        shoppingCartProductsB.put(Supermarket.PRODUCT_MAP.get(ProductEnum.APPLE), appleCountB);
        shoppingCartProductsB.put(Supermarket.PRODUCT_MAP.get(ProductEnum.STRAWBERRY), strawberryCountB);
        shoppingCartProductsB.put(Supermarket.PRODUCT_MAP.get(ProductEnum.MANGO), mongoCountB);
        shoppingCartB.setProducts(shoppingCartProductsB);
        customerB.setShoppingCart(shoppingCartB);

        BigDecimal resultB = new Cashier().settle(customerB);// 结算，需要收银台
        customerA.setProducts(shoppingCartProductsB);        // 结账后需要把货物给客户
        customerA.setShoppingCart(null);                // 清空购物车
        System.out.println("客户B所购买的商品:" +ProductEnum.APPLE.getName() + "重量：" + appleCountB + "斤;"
                +ProductEnum.STRAWBERRY.getName() + "重量：" + strawberryCountB + "斤"
                +ProductEnum.MANGO.getName() + "重量：" + mongoCountB + "斤。总价： " + resultB.toString());


        /*
        * 3、超市做促销活动，草莓限时打 8 折。
            现在顾客 C 在超市购买了若干斤苹果、 草莓和芒果，需计算一共需要多少钱？
            请编写函数，对于 C 购买的水果斤数 (水果斤数为大于等于 0 的整数)，计算并返回所购买商品的总价。
        *
        * */
        int appleCountC = new Random().nextInt(10);         // 题目没写要多少斤，先随机一下. 忽视库存问题
        int strawberryCountC = new Random().nextInt(10);
        int mongoCountC = new Random().nextInt(10);
        Person customerC = new Person();
        ShoppingCart shoppingCartC = new ShoppingCart();
        Map<Product, Integer> shoppingCartProductsC = new HashMap<>();
        shoppingCartProductsC.put(Supermarket.PRODUCT_MAP.get(ProductEnum.APPLE), appleCountC);
        shoppingCartProductsC.put(Supermarket.PRODUCT_MAP.get(ProductEnum.STRAWBERRY), strawberryCountC);
        shoppingCartProductsC.put(Supermarket.PRODUCT_MAP.get(ProductEnum.MANGO), mongoCountC);
        shoppingCartC.setProducts(shoppingCartProductsC);
        customerC.setShoppingCart(shoppingCartC);

        Map<Product, Float> discountMap = new HashMap<>();
        discountMap.put(Supermarket.PRODUCT_MAP.get(ProductEnum.MANGO), 0.8F);
        DiscountContext.psMap.put(DiscountEnum.EIGHTFOLD, new DiscountRebate(discountMap));     // 先实例化优惠对象

        DiscountBase discountC = DiscountContext.getDiscount(DiscountEnum.EIGHTFOLD);
        BigDecimal resultC = new Cashier().settle(((DiscountRebate) discountC).discount(customerC));

        System.out.println("客户C所购买的商品:" +ProductEnum.APPLE.getName() + "重量：" + appleCountC + "斤;"
                +ProductEnum.STRAWBERRY.getName() + "重量：" + strawberryCountC + "斤"
                +ProductEnum.MANGO.getName() + "重量：" + mongoCountC + "斤。总价：" + resultC.toString());


        /*
        * 4、促销活动效果明显，超市继续加大促销力度，购物满 100 减 10 块。
            现在顾客 D 在超市购买了若干斤苹果、 草莓和芒果，需计算一共需要多少钱？
            请编写函数，对于 C 购买的水果斤数 (水果斤数为大于等于 0 的整数)，计算并返回所购买商品的总价。
        * */
        int appleCountD = new Random().nextInt(10);         // 题目没写要多少斤，先随机一下. 忽视库存问题
        int strawberryCountD = new Random().nextInt(10);
        int mongoCountD = new Random().nextInt(10);
        Person customerD = new Person();
        ShoppingCart shoppingCartD = new ShoppingCart();
        Map<Product, Integer> shoppingCartProductsD = new HashMap<>();
        shoppingCartProductsD.put(Supermarket.PRODUCT_MAP.get(ProductEnum.APPLE), appleCountD);
        shoppingCartProductsD.put(Supermarket.PRODUCT_MAP.get(ProductEnum.STRAWBERRY), strawberryCountD);
        shoppingCartProductsD.put(Supermarket.PRODUCT_MAP.get(ProductEnum.MANGO), mongoCountD);
        shoppingCartD.setProducts(shoppingCartProductsD);
        customerD.setShoppingCart(shoppingCartD);

        DiscountContext.psMap.put(DiscountEnum.SPECIAL_TEN, new DiscountFullReduction(new BigDecimal(100), new BigDecimal(10)));     // 先实例化优惠对象

        DiscountBase discountD = DiscountContext.getDiscount(DiscountEnum.SPECIAL_TEN);
        BigDecimal resultD = ((DiscountFullReduction) discountD).arithmetic(new Cashier().settle(customerD));

        System.out.println("客户D所购买的商品:" +ProductEnum.APPLE.getName() + "重量：" + appleCountD + "斤;"
                +ProductEnum.STRAWBERRY.getName() + "重量：" + strawberryCountD + "斤"
                +ProductEnum.MANGO.getName() + "重量：" + mongoCountD + "斤。总价：" + resultD.toString());

    }


}
