package com.view.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * @ClassName JpsModel
 * @Despacito TODO
 * @Author chenzhuo
 * @Version 1.0
 *      父类的
 *     private int pid;
 *     private String order;
 *     private String orderValue;
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class JpsModel extends BaseValue {
    public String jvmParameter;
    public String value;
    public JpsModel(){
        super();
    }
}
