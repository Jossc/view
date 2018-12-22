package com.view.commons.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.view.commons.constant.UserAndPassWord;
import com.view.commons.enmu.SSHEnum;
import org.apache.catalina.User;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName SSHUtils
 * @Despacito 远程连接工具类
 * @Author chenzhuo
 * @Version 1.0
 **/
public class SSHUtils {
    private static final Logger logger = LoggerFactory.getLogger(SSHUtils.class);

    /**
     * 获取session连接
     *
     * @param ip       ip
     * @param port     端口
     * @param userName 用户名称
     * @param pwd      密码
     * @param timeout  超时
     * @return
     */
    public  static Session getSession(String ip, int port, String userName, String pwd, int timeout) {
        JSch jSch = new JSch();
        try {
            Session session = jSch.getSession(userName, ip, port);
            session.setPassword(pwd);
            //第一次访问的时候不用输入yes
            session.setConfig("StrictHostKeyChecking", "no");
            session.setTimeout(SSHEnum.timeout.getTimeOut());
            session.connect();
            return session;
        } catch (JSchException e) {
            logger.error("session getSession exception ", e);
        }
        return null;
    }
    public  static Session getSession(){
       return getSession(UserAndPassWord.ip, UserAndPassWord.port,UserAndPassWord.userName,
               UserAndPassWord.pwd,UserAndPassWord.timeOut);
    }

    /**
     * type类型：
     * session
     * shell
     * exce 等
     *
     * @param session        session
     * @param command
     * @param resultEncoding
     * @return
     */
    public static String execCommand(Session session, String command, String resultEncoding) {
        try {
            ChannelExec channelExec = (ChannelExec) session.openChannel("exec");
            InputStream inputStream = channelExec.getInputStream();
            channelExec.setCommand(command);
            channelExec.setErrStream(System.err);
            channelExec.connect();
            String result = IOUtils.toString(inputStream, resultEncoding);
            channelExec.disconnect();
            return result;
        } catch (Exception e) {
            logger.error("execCommand exception ", e);
        }finally {
            if(session!=null){
                session.disconnect();
            }
        }
        return null;
    }

    public static String execCommand(Session session, String command) {
        return execCommand(session, command, SSHEnum.encode.getValue());
    }

    private static String execCommand(String ip, int port, String user, String pwd,
                                      int timeout, String command, String resultEncoding) {
        Session session = getSession(ip, port, user, pwd, timeout);
        String result = execCommand(session, command, resultEncoding);
        if (session != null) {
            session.disconnect();
        }
        return result;
    }

    public static String execCommand(String ip, String user, String pwd, String command) {
        return execCommand(ip, 22, user, pwd,
                SSHEnum.timeout.getTimeOut(), command, SSHEnum.encode.getValue());
    }

    /**
     * top 命令有问题
     * vmstat 直接使用没问题
     *
     * @param args
     */
    public static void main(String[] args) {
    }
}
