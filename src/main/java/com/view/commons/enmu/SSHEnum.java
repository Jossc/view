package com.view.commons.enmu;

public enum SSHEnum {

    encode("utf-8"),
    timeout(60 * 30 * 1000),
    defaultport(22),
    username("root"),
    password("A02041108a"),
    address("121.42.242.139");



    String value;
    int timeOut;
    long defaultPort;
    String userName;
    String passWord;
    String Address;

    SSHEnum(String vlaue) {
        this.value = vlaue;
    }

    SSHEnum(int timeOut) {
        this.timeOut = timeOut;
    }

    SSHEnum(long defaultPort) {
        this.defaultPort = defaultPort;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(int timeOut) {
        this.timeOut = timeOut;
    }

    public long getDefaultPort() {
        return defaultPort;
    }

    public void setDefaultPort(long defaultPort) {
        this.defaultPort = defaultPort;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
