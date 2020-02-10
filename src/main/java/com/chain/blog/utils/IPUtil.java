package com.chain.blog.utils;

import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import eu.bitwalker.useragentutils.Version;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: chain
 * @create: 2020/02/08
 **/
public class IPUtil {

    /**
     * @param request 请求
     * @return IP Address
     */
    public static String getIpAddrByRequest(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }


    /**
     * 返回浏览器版本信息
     *
     * @param request
     * @return
     */
    public static String getBrowserName(HttpServletRequest request) {
        String header = request.getHeader("User-Agent");
        UserAgent userAgent = UserAgent.parseUserAgentString(header);
        Browser browser = userAgent.getBrowser();
        return browser.getName();
    }



    /**
     * 获取发起请求的浏览器版本号
     */
    public static String getBrowserVersion(HttpServletRequest request) {
        String header = request.getHeader("User-Agent");
        UserAgent userAgent = UserAgent.parseUserAgentString(header);
        //获取浏览器信息
        Browser browser = userAgent.getBrowser();
        //获取浏览器版本号
        Version version = browser.getVersion(header);
        return version.getVersion();
    }

    /**
     * 获取发起请求的操作系统名称
     */
    public static String getOsName(HttpServletRequest request) {
        String header = request.getHeader("User-Agent");
        UserAgent userAgent = UserAgent.parseUserAgentString(header);
        OperatingSystem operatingSystem = userAgent.getOperatingSystem();
        return operatingSystem.getName();
    }


    public static String  getManu(HttpServletRequest request){
        String agentStr = request.getHeader("user-agent");
        UserAgent agent = UserAgent.parseUserAgentString(agentStr);
        OperatingSystem os = agent.getOperatingSystem();
        String  manu="名:"+os.getName();
        String  manuKind= "类型:"+ os.getDeviceType();
        String  manuSer= "设备系列:" +os.getGroup();
        String manufacturer= "生产厂商:"+os.getManufacturer();
        return  manu+" "+ manuKind+" "+manuSer+" "+manufacturer;
    }
    public static  String getDeviceName(HttpServletRequest request){
        String agentStr = request.getHeader("user-agent");
        UserAgent agent = UserAgent.parseUserAgentString(agentStr);
        OperatingSystem os = agent.getOperatingSystem();
        String  manu=""+os.getName();
        String  manuKind= ""+ os.getDeviceType();
        return  manu+" "+ manuKind;
    }

}
