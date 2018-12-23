package com.view.commons.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName VmstatUtils
 * @Despacito TODO
 * @Author chenzhuo
 * @Version 1.0
 **/
public class VmstatUtils {
    private static final Logger logger = LoggerFactory.getLogger(VmstatUtils.class);

    public static String execVmstat(String value,String vlaue2){
        String command = "vmstat" +" " + value+" " + vlaue2;
        return SSHUtils.execCommand(SSHUtils.getSession(),command);
    }
    public static String execVmstat(String  vlaue){
        return execVmstat(vlaue,"");
    }
    public static String execVmstat(){
        return execVmstat("","");
    }

    public static void main(String[] args) {
        System.out.println(execVmstat("2","5"));
    }
}
