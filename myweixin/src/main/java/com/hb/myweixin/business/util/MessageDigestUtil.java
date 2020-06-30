package com.hb.myweixin.business.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MessageDigestUtil {

    /**
     * sha1加密
     * @param src
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static String sha1(String src) throws NoSuchAlgorithmException{
        //获取一个加密对象
        MessageDigest md = null;
        md = MessageDigest.getInstance("sha1");
        //加密
        byte[] digest = md.digest(src.getBytes());
        char[] chars= {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        StringBuilder sb = new StringBuilder();
        //处理加密结果
        for(byte b:digest) {
            sb.append(chars[(b>>4)&15]);
            sb.append(chars[b&15]);
        }
        return sb.toString();
    }
}
