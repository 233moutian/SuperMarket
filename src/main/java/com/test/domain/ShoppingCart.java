package com.test.domain;

import lombok.Data;

import java.util.Map;

@Data
public class ShoppingCart {
    private Person owen;

    private Map<Product, Integer> products;

}
