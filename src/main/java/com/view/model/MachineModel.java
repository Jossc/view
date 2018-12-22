package com.view.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @ClassName MachineModel
 * @Despacito TODO
 * @Author chenzhuo
 * @Version 1.0
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class MachineModel  extends BaseValue{
    private String tomcatValue;
  /*  private String */
    public MachineModel(){
    }
}
