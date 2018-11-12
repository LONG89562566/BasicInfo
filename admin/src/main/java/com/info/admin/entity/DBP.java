package com.info.admin.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 数据源信息
 * @author ljuenan
 */
public class DBP implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2869034349247740496L;

	/**
	 * 源码
	 */
	private String code;

	/**
	 * 源地址
	 */
	private String url;

    /**
     * 源
     */
    private String ip;

    /**
     * 源端口
     */
    private String port;

    /**
     * 源名称
     */
    private String name;

    /**
     * 源用户名
     */
    private String user;

    /**
     * 源密码
     */
    private String password;

    private boolean isUse;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 无需注入url，只需获取
     * @return
     */
    public String getUrl() {
        StringBuffer sb = new StringBuffer();
        sb.append("jdbc:mysql://")
                .append(ip)
                .append(":")
                .append(port)
                .append("/")
                .append(name)
                .append("?autoReconnect=true&failOverReadOnly=false&useUnicode=true&characterEncoding=utf8&allowMultiQueries=true");
        return sb.toString();
    }


    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isUse() {
        return isUse;
    }

    public void setUse(boolean use) {
        isUse = use;
    }
}
