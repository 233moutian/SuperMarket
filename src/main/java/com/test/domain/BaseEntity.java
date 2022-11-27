package com.test.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    protected Integer id;
    protected String name;

}
