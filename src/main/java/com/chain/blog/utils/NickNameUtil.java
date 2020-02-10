package com.chain.blog.utils;

import com.sun.org.apache.regexp.internal.RE;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.io.UnsupportedEncodingException;
import java.util.Random;

/**
 * 产生随机的昵称
 * @author: chain
 * @create: 2020/02/06
 **/
public class NickNameUtil {

    //有形容词的概率
    private static final float HAS_ADJ=(float) 0.3;

    //名字为2个字的概率 反之则为3个字
    private static final  float TWO_CH_NAME=(float) 0.5;

    //使用内置的形容词的概率
    private static final  float USE_CURRENT_ADJ=(float) 0.3;

    private static String currentAdj[] = {
            "装逼的","狗屁的","蛋疼的",
            "一样的", "喜欢的", "美丽的", "一定的", "原来的", "美好的", "开心的", "可能的", "可爱的",
            "明白的", "所有的", "后来的", "重要的", "经常的", "自然的", "真正的", "害怕的", "空中的",
            "红色的", "痛苦的", "干净的", "辛苦的", "精彩的", "欢乐的", "进步的", "影响的", "黄色的",
            "亲爱的", "根本的", "完美的", "金黄的", "聪明的", "清新的", "迷人的", "光明的", "共同的",
            "直接的", "真实的", "听说的", "用心的", "飞快的", "雪白的", "着急的", "乐观的", "主要的",
            "鲜艳的", "冰冷的", "细心的", "奇妙的", "水平的", "动人的", "大量的", "无知的", "礼貌的",
            "暖和的", "深情的", "正常的", "平淡的", "光亮的", "落后的", "大方的", "老大的", "刻苦的",
            "晴朗的", "专业的", "永久的", "大气的", "知己的", "刚好的", "相对的", "平和的", "友好的",
            "广大的", "秀丽的", "日常的", "高级的", "相同的", "笔直的", "安定的", "知足的", "结实的",
            "许久的", "听话的", "知名的", "闷热的", "众多的", "拥挤的", "天生的", "迷你的", "老实的",
            "友爱的", "原始的", "可笑的", "合格的", "公共的", "大红的", "得力的", "洁净的", "暗淡的",
            "鲜红的", "桃红的", "吓人的", "多余的", "秀美的", "繁忙的", "冰凉的", "热心的", "空旷的",
            "冷清的", "公开的", "冷淡的", "齐全的", "草绿的", "能干的", "发火的", "可心的", "业余的",
            "空心的", "凉快的", "长远的", "土黄的", "和好的", "合法的", "明净的", "过时的", "低下的",
            "不快的", "低级的", "中用的", "不定的", "公办的", "用功的", "少许的", "忙乱的", "日用的",
            "要紧的", "少见的", "非分的", "怕人的", "大忙的", "幸福的", "特别的", "未来的", "伟大的",
            "困难的", "伤心的", "实在的", "现实的", "丰富的", "同样的", "巨大的", "耐心的", "优秀的",
            "亲切的", "讨厌的", "严厉的", "积极的", "整齐的", "环保的"};

    /**
     * 随机返回一个现有的形容词
     * @return
     */
    public static String getCurrentAdj(){
        int length=currentAdj.length;
        return currentAdj[new Random().nextInt(length)];
    }


    /**
     * 针对一级汉字范围产生一个随机的汉字
     * highNum 高位 范围 16-55   0XB0 -- 0xD6
     * lowNum 低位 01-94 0xA1-0xFE
     * @return
     */
    public static String getOneCh(){
        String ch=null;
        Integer  highNum,lowNum;
        Random random=new Random();
        highNum=176+ random.nextInt(40);
        lowNum=161+random.nextInt(94);
        byte[] bytes=new byte[2];
        bytes[0]=highNum.byteValue();
        bytes[1]=lowNum.byteValue();
        try {
            ch=new String(bytes,"GB2312");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return ch;
    }

    /**
     * 根据概率为0.3 是否加上一个形容词
     * @return
     */
    public static boolean hasAdj(){
        float num=(new Random()).nextFloat();
        if (num<=HAS_ADJ)
            return true;
        return false;
    }

    /**
     * 根据概率为0.5 名字为2字
     * 为 3字
     * @return
     */
    public static boolean has2ChName(){
        float num=(new Random()).nextFloat();
        if (num<=TWO_CH_NAME)
            return true;
        return false;
    }

    public static boolean useCurrentAdj(){
        float num=(new Random()).nextFloat();
        if (num<=USE_CURRENT_ADJ)
            return true;
        return false;
    }

    public static String generateRandomName(){
        String name="";
        String adj="";
        if (hasAdj()){
            //具有形容词
            if (useCurrentAdj()){
                //使用现成的形容词
                adj=getCurrentAdj();
            }else {
                //使用生成的形容词
                if (has2ChName()) {//生成2个字的形容词
                    for (int i = 0; i < 2; ) {
                        String tmp = getOneCh();
                        if (tmp != "的" || tmp != "得" || tmp != "地") {
                            adj += tmp;
                            i++;
                        }
                    }
                } else {
                    //生成三个字的形容词
                    for (int i = 0; i < 3; ) {
                        String tmp = getOneCh();
                        if (tmp != "的" || tmp != "得" || tmp != "地") {
                            adj += tmp;
                            i++;
                        }
                    }
                }
                adj += "的";
            }
        }
        for (int i = 0; i < 2; ) {
            String tmp = getOneCh();
            if (tmp != "的" || tmp != "得" || tmp != "地") {
                adj += tmp;
                i++;
            }
        }
        if (!has2ChName()){
            for (int i = 0; i < 1; ) {
                String tmp = getOneCh();
                if (tmp != "的" || tmp != "得" || tmp != "地") {
                    adj += tmp;
                    i++;
                }
            }
        }

        return adj+name;
    }
}