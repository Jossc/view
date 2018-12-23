package com.view.commons.utils;

/**
 * @ClassName TopUtils
 * @Despacito TODO
 * @Author chenzhuo
 * @Version 1.0
 **/
public class TopUtils {

    public static String getTop(){
      return  SSHUtils.execCommand(SSHUtils.getSession(),"");
    }

    public static void main(String[] args) {
       System.out.println(getTop());
    }
}
