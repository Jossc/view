package com.view.commons.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName JstackUtils
 * @Despacito TODO
 * @Author chenzhuo
 * @Version 1.0
 * jstack
 *  -F  当’jstack [-l] pid’没有相应的时候强制打印栈信息,如果直接jstack无响应时，用于强制jstack，一般情况不需要使用
 *  -l	long listings，会打印出额外的锁信息，在发生死锁时可以用jstack -l pid来观察锁持有情况（可能会差很多倍，比如普通的jstack可能几毫秒和一次GC没区别，
 *      加了-l 就是近一秒的时间），-l 建议不要用。一般情况不需要使用
 *  -m	mixed mode，不仅会输出Java堆栈信息，还会输出C/C++堆栈信息（比如Native方法）
 **/
public class JstackUtils {
    public static final Logger logger = LoggerFactory.getLogger(JstackUtils.class);

    public static String exceJstack(String pid,String value1,String value2){
        String command = "jstack " + value1 + " " + value2 +" " + pid;
        return SSHUtils.execCommand(SSHUtils.getSession(),command);
    }
    public static String exceJstack(String pid){
        String command = "jstack " + pid ;
        return SSHUtils.execCommand(SSHUtils.getSession(),command);
    }
    public static void main(String[] args) {
       List<String> valueList = Arrays.asList(JpsUtils.getJpsMole("-m","-v").split("\n"));
       System.out.println(valueList.get(0));
    /*   exceJstack("-l","","");*/
    /*   System.out.println(exceJstack("2270"));*/
       /* System.out.println(exceJstack("32422"));*/
    }
}
