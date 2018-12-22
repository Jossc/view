package com.view.model;

import lombok.Data;

/**
 * @ClassName BaseValue
 * @Despacito TODO
 * @Author chenzhuo
 * @Version 1.0
 **/
@Data
class BaseValue {
    private int pid;
    public String objectName;
    private String order;
    private String orderValue;
    BaseValue(){

    }
}
