package com.iotek.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by taft on 2016/5/28.
 */
public class RoundID implements IDType{
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    public static String getID(int IDType){
        String prefix = null;
        switch (IDType){
            case 1:
                prefix = "user";
                break;
            case 2:
                prefix = "userDetails";
                break;
        }
        StringBuffer stb = new StringBuffer();
        for (int i = 0; i < 15 - prefix.length(); i++) {
            stb.append((int)(Math.random()*10));
        }
        return prefix+sdf.format(new Date())+stb.toString();
    }

}
