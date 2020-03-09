package com.chain.blog.mywechat;

import java.security.MessageDigest;
import java.util.Arrays;

/**
 * @author: chain
 * @create: 2020/02/19
 **/
public class CheckUtil {
    private static final  String  TOKEN="chainwechatdev";
    public    static   boolean checkSignature(String  sign,String  times
    ,String nonce){

        String[] arr=new String[]{TOKEN,times,nonce};
        Arrays.sort(arr);

        StringBuffer content=new StringBuffer();
        for (int i = 0; i <arr.length ; i++) {
            content.append(arr[i]);
        }
        String tmp="";
        try {
             tmp=shaEncode(content.toString());
        } catch (Exception e) {
            System.out.println("sha1加密失败...");
            e.printStackTrace();
        }
        return tmp.equals(sign);

    }


    public static String shaEncode(String inStr) throws Exception {
        MessageDigest sha = null;
        try {
            sha = MessageDigest.getInstance("SHA");
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }

        byte[] byteArray = inStr.getBytes("UTF-8");
        byte[] md5Bytes = sha.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }


}
