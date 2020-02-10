package com.chain.blog.dao;

import com.chain.blog.aspect.ActIPAspect;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;

@Mapper
public interface VisitorDao {
//    private String ip;
//    private String brower;
//    private Date visitTime;
//    private String location;
//    private Object[] args;
//    private  String deviceInfo;//设备
//    private String deviceName;

    /**
     * 首页记载访客
     * @param ip
     * @param brower
     * @param visirTime
     * @param location
     * @param deviceInfo
     * @param deviceName
     */
    void insertVisitorIndex(String ip, String brower, Date visitTime, String location, String deviceInfo, String deviceName);

    /**
     * 插入something操作信息
     * @param args
     * @param ip
     * @param brower
     * @param visitTime
     * @param location
     * @param deviceInfo
     * @param deviceName
     */
    void insertVisitorSomething(String args,String ip, String brower, Date visitTime, String location, String deviceInfo, String deviceName);

    /**
     * 插入评论信息
     * @param args
     * @param ip
     * @param brower
     * @param visitTime
     * @param location
     * @param deviceInfo
     * @param deviceName
     */
    void insertVisitorComment(String args,String ip, String brower, Date visitTime, String location, String deviceInfo, String deviceName);

}
