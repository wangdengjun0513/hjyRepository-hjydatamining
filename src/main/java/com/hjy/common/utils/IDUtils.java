package com.hjy.common.utils;

import java.util.UUID;

public class IDUtils {

    public static String currentTimeMillis(){
        //防止时间戳相同，让线程等待1毫秒
        try {
            Thread.currentThread().sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return String.valueOf(System.currentTimeMillis());
    }

    /**
     * 获得一个32位UUID
     * @return String UUID
     */
    public static String getUUID(){
        String uuid = UUID.randomUUID().toString();
        //去掉“-”符号
        return uuid.replaceAll("-", "");
    }
}
