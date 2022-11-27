package com.test.domain;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product extends BaseEntity{

    private BigDecimal price;
    private String code;

    public Product(Integer id, String name, BigDecimal price, String code) {
        super.setId(id);
        super.setName(name);
        this.price = price;
        this.code = code;
    }


}
