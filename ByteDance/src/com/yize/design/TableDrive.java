package com.yize.design;

import java.util.HashMap;
import java.util.Map;

/**
 * 优化一段代码,降低代码的圈复杂度
 *
 * scheme        打开
 * weixin://    true
 * mqq://       true
 * baidu://     true
 * https://     false
 *
 */
public class TableDrive {
    private static Map<String,Boolean> schemeMap;
    /**
     * 表驱动的方式实现scheme判定
     * @param scheme
     * @return
     */
    public static boolean shouldOpenSchemeBySystem(String scheme){
        if(!isCorrectFormat(scheme)){
            return false;
        }
        Map<String,Boolean> map=loadSchemeOption();
        String schemePrefix=scheme.substring(0,scheme.indexOf("://"));
        if(!map.containsKey(schemePrefix)){
            return false;
        }
        return map.get(schemePrefix);
    }

    public static Map<String,Boolean> loadSchemeOption(){
        if(schemeMap==null){
            //load properties from file or network,json format is perfect.
            schemeMap=new HashMap<>();
        }

        return schemeMap;
    }
    public static boolean isCorrectFormat(String scheme){
        return scheme!=null&&scheme.contains("://");
    }

    /**
     * 传统的方式实现scheme判定
     * @param scheme
     * @param yes
     * @return
     */
    public static boolean shouldOpenSchemeBySystem(String scheme,boolean yes){
        if(!isCorrectFormat(scheme)){
            return false;
        }
        String schemePrefix=scheme.substring(0,scheme.indexOf("://"));
        if(schemePrefix.equals("weixin://")){
            return false;
        }else if(schemePrefix.equals("mqq://")){
            return false;
        }else if(schemePrefix.equals("baidu://")){
            return false;
        }else if(schemePrefix.equals("https://")){
            return true;
        }else {
            //other schemes ...etc
        }
        return false;
    }

}
