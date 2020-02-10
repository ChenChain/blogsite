package com.chain.blog.aspect;

import com.chain.blog.dao.VisitorDao;
import com.chain.blog.entity.Comment;
import com.chain.blog.entity.Something;
import com.chain.blog.utils.AddressUtil;
import com.chain.blog.utils.IPUtil;
import com.chain.blog.utils.NickNameUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * @author: chain
 * @create: 2020/02/08
 **/
@Component
@Aspect
public class ActIPAspect {
    private  final Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private VisitorDao visitorDao;

    @Pointcut("execution(* com.chain.blog.web.blog.SomethingController.*saveSomething(..))")
    public void something(){}

    @Pointcut("execution( * com.chain.blog.web.blog.CommentController.post(..))")
    public void comment(){}

    @Pointcut("execution( * com.chain.blog.web.blog.IndexController.index(..))")
    public void index(){}

    /**
     * 针对 首页浏览 进行日志记录
     * @param joinPoint
     */
    @Before("index()")
    public void indexBefore(JoinPoint joinPoint){
        ServletRequestAttributes servletRequestAttributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (servletRequestAttributes.getRequest()==null) return;
        HttpServletRequest httpServletRequest=servletRequestAttributes.getRequest();
        String url=httpServletRequest.getRequestURL().toString();
        String ip = IPUtil.getIpAddrByRequest(httpServletRequest);
        String method=joinPoint.getSignature().getDeclaringTypeName() +"."+ joinPoint.getSignature().getName();
        Object[] args=joinPoint.getArgs();
        Date date=new Date();
        String location="";
        String deviceInfo=IPUtil.getManu(httpServletRequest);
        String deviceName=IPUtil.getDeviceName(httpServletRequest);
//        try {
//             location= AddressUtil.getAddresses(ip,"");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
        String brower=IPUtil.getOsName(httpServletRequest)+" - " +IPUtil.getBrowserName(httpServletRequest) ;
        ActIPAspect.IPInfo ipInfo=new ActIPAspect.IPInfo(ip,brower,date,location,args,deviceInfo,deviceName);
        //插入首页访客表
        visitorDao.insertVisitorIndex(ip,brower,date,location,deviceInfo,deviceName);
        logger.info("IndexRequest: {}",ipInfo);
    }


    @Before("something()")
    public void somethingBefore(JoinPoint joinPoint){
        ServletRequestAttributes servletRequestAttributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (servletRequestAttributes.getRequest()==null) return;
        HttpServletRequest httpServletRequest=servletRequestAttributes.getRequest();
        String url=httpServletRequest.getRequestURL().toString();
        String ip = IPUtil.getIpAddrByRequest(httpServletRequest);
        String method=joinPoint.getSignature().getDeclaringTypeName() +"."+ joinPoint.getSignature().getName();
        Object[] args=joinPoint.getArgs();
        Date date=new Date();
        String location="";
        String deviceInfo=IPUtil.getManu(httpServletRequest);
        String deviceName=IPUtil.getDeviceName(httpServletRequest);
//        try {
//            location= AddressUtil.getAddresses(ip,"");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
        String brower=IPUtil.getOsName(httpServletRequest)+" - " +IPUtil.getBrowserName(httpServletRequest) ;
        Something something=new Something();
        for (Object obj:args){
            if (obj instanceof Something){
                ((Something) obj).setIp(ip);
                ((Something) obj).setCreateTime(new Date());
                something=(Something)obj;
            }
        }

        ActIPAspect.IPInfo ipInfo=new ActIPAspect.IPInfo(ip,brower,date,location,args,deviceInfo,deviceName);
        //插入something留言表
        visitorDao.insertVisitorSomething(something.toString(),ip,brower,date,location,deviceInfo,deviceName);
        logger.info("SomethingRequest: {}",ipInfo);
    }

    @Before("comment()")
    public void commentBefore(JoinPoint joinPoint){
        ServletRequestAttributes servletRequestAttributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (servletRequestAttributes.getRequest()==null) return;
        HttpServletRequest httpServletRequest=servletRequestAttributes.getRequest();
        String url=httpServletRequest.getRequestURL().toString();
        String ip = IPUtil.getIpAddrByRequest(httpServletRequest);
        String method=joinPoint.getSignature().getDeclaringTypeName() +"."+ joinPoint.getSignature().getName();
        Object[] args=joinPoint.getArgs();
        Date date=new Date();
        String location="";
        String deviceInfo=IPUtil.getManu(httpServletRequest);
        String deviceName=IPUtil.getDeviceName(httpServletRequest);
//        try {
//            location= AddressUtil.getAddresses(ip,"");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
        String brower=IPUtil.getOsName(httpServletRequest)+" - " +IPUtil.getBrowserName(httpServletRequest) ;
        Comment comment=new Comment();
        String nickname=" ";
        for (Object obj:args){
            if (obj instanceof Comment){
                ((Comment) obj).setIp(ip);
//                nickname=ip.substring(5);
                nickname+=deviceName;
                nickname+="用户";
                ((Comment) obj).setNickname(nickname);
                comment=(Comment) obj;
            }
        }

        ActIPAspect.IPInfo ipInfo=new ActIPAspect.IPInfo(ip,brower,date,location,args,deviceInfo,deviceName);
        //插入something留言表
        visitorDao.insertVisitorComment(comment.toString(),ip,brower,date,location,deviceInfo,deviceName);
        logger.info("CommentRequest: {}",ipInfo);
    }


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private class IPInfo{
        private String ip;
        private String brower;
        private Date visitTime;
        private String location;
        private Object[] args;
        private  String deviceInfo;//设备
        private String deviceName;
    }
}
