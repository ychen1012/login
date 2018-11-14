package com.imtoocai.diary.util;

import org.apache.commons.codec.digest.DigestUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by yangchen on 2018/11/13 16 :54.
 */
public class MD5Util {

    public static void encrypByMd5(String context) throws NoSuchAlgorithmException {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(context.getBytes());//update处理
            byte [] encryContext = md.digest();//调用该方法完成计算

            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < encryContext.length; offset++) {//做相应的转化（十六进制）
                i = encryContext[offset];
                if (i < 0) i += 256;
                if (i < 16) buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            System.out.println("32result: " + buf.toString());// 32位的加密
            System.out.println("16result: " + buf.toString().substring(8, 24));// 16位的加密
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /*
     * 2.使用开发的jar直接应用
     *  使用外部的jar包中的类：import org.apache.commons.codec.digest.DigestUtils;
     *  对上面内容的一个封装使用方便
     */
    public static void encrypByMd5Jar(String context) {
        String md5Str = DigestUtils.md5Hex(context);
        System.out.println("32result: " + md5Str);
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {

        encrypByMd5("1234567890");
        encrypByMd5Jar("123456");
    }
}
