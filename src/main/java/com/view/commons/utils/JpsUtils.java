package com.view.commons.utils;

import com.view.model.JpsModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName JpsUtils
 * @Despacito TODO
 * @Author chenzhuo
 * @Version 1.0
 * jps命令的工具
 * jps
 *   -q：只输出进程 ID
 *  -m：输出传入 main 方法的参数
 *  -l：输出完全的包名，应用主类名，jar的完全路径名
 *  -v：输出jvm参数
 *  -V：输出通过flag文件传递到JVM中的参数

 *  jps -m -l
 *  jsp -m -v
 *
 **/
public class JpsUtils {
    private static final Logger logger = LoggerFactory.getLogger(JpsUtils.class);
    public static JpsModel getJpsModel(String m ,String l){
        logger.info("jsp{} m{} l{}",m,l);
        String command = "jps " + m + " "+ l;
        String result = SSHUtils.execCommand(SSHUtils.getSession(),command);
        System.out.println(result);
        return new JpsModel();
    }

    public static void main(String[] args) {
        JpsModel jpsModel = getJpsModel("-l", "-m");

    }
}
