package com.test.constants;

public enum ProductEnum {

    APPLE("apple"),STRAWBERRY("strawberry"),MANGO("mango");
    private String name;
    ProductEnum(String names) {
        name = names;
    }

    public String getName() {
        return name;
    }

    public void setName(String names) {
        name = names;
    }
}
