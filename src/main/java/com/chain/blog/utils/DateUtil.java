package com.chain.blog.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: chain
 * @create: 2020/01/30
 **/
public class DateUtil {

    public static List<String> dataFormats = new ArrayList<String>() {
        {
            add(new String("yyyy-MM-dd"));
            add(new String("yyyy/MM/dd"));
            add(new String("yyyy-MM-dd HH:24:mm:ss"));

        }
    };



    //data形式为 2020-1-1
    public static Date dateFormat(String date, String dateFormat) {
        if (date == null) {
            return null;
        } else {
            SimpleDateFormat format = new SimpleDateFormat(dateFormat);
            try {
                return format.parse(date);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static Date dateFormat(String date) {
        return dateFormat(date, "yyyy-MM-dd HH:mm:ss");
    }

    //字符串型格式
    public static String dateFormat(Date date, String dateFormat) {
        if (date != null) {
            SimpleDateFormat format = new SimpleDateFormat(dateFormat);
            return format.format(date);
        }
        return null;
    }

    public static String dateFormat(Date date) {
        return dateFormat(date, "yyyy-MM-dd HH:mm:ss");
    }

    public static Date getTomorrow() {
        Date date = new Date();
        long time = date.getTime() / 1000L + 86400L;
        date.setTime(time * 1000L);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = format.parse(format.format(date));
        } catch (ParseException e) {

        }
        return date;

    }

    public static Date getNow() {
        return new Date();
    }



    public static Date getDateByUnixTime(int unix) {
        return new Date((long) unix * 1000);
    }


    public static int getCurrentUnixTime() {
        return (int) new Date().getTime() / 1000;
    }

    public static long getUnixTimeByDate(Date date) {
        return date.getTime() / 1000;
    }

    public static String formatDateByUnixTime(long unix, String format) {
        return dateFormat(new Date(unix * 1000), format);
    }


    public static void main(String[] args){
           System.out.println(dateFormat(new Date(),dataFormats.get(1)));
    }

}
