package com.yize.tencent;

import org.junit.Test;

public class TwoStringIntersection {
    @Test
    public void test(){
        System.out.println(interSectionOfTwoStr("mafazine","validate"));
    }

    /**
     * 输出两个字符串字符的交集
     * @param s1
     * @param s2
     * @return
     */
    public String interSectionOfTwoStr(String s1,String s2){
        if(s1==null||s2==null||s1.length()==0||s2.length()==0){
            return "";
        }
        char[] cs1=s1.toCharArray();
        char[] cs2=s2.toCharArray();
        int[] map1=new int['z'+1];
        for (char c1:cs1){
            map1[c1]++;
        }
        int[] map2=new int['z'+1];
        for (char c2:cs2){
            map2[c2]++;
        }
        StringBuilder sb=new StringBuilder();
        for (int i='A';i<='z';i++){
            if(map1[i]>0&&map2[i]>0){
                sb.append((char)i);
            }
        }
        return sb.toString();
    }
}
