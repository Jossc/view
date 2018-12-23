package com.view.commons.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * @ClassName JpsUtils
 * @Despacito TODO
 * @Author chenzhuo
 * @Version 1.0
 * jps命令的工具
 * jps
 * -q：只输出进程 ID
 * -m：输出传入 main 方法的参数
 * -l：输出完全的包名，应用主类名，jar的完全路径名
 * -v：输出jvm参数
 * -V：输出通过flag文件传递到JVM中的参数
 * <p>
 * jps -m -l
 * jsp -m -v
 **/
public class JpsUtils {
    private static final Logger logger = LoggerFactory.getLogger(JpsUtils.class);
    /**
     * jps
     *
     * @param m 命令1
     * @param l 命令2
     * @return
     */
    public static String getJpsMole(String m, String l) {
        logger.info("jsp {} m {} l {}", m, l);
        String command = "jps " + m + " " + l;
        return SSHUtils.execCommand(SSHUtils.getSession(), command);
    }

    public static String getJpsMole(String m) {
        logger.info("jsp {} m {}", m);
        return getJpsMole(m, "");
    }

    public static String getJpsMole() {
        return getJpsMole("");
    }
    public static String getJspMole(){
        return getJpsMole("-q");
    }

    public static void main(String[] args) {
        System.out.println(getJpsMole(""));

    }
}
