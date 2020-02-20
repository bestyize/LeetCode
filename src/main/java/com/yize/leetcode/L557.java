package com.yize.leetcode;

import org.junit.Test;

public class L557 {
    @Test
    public void test(){
        String str="Let's take LeetCode contest";
        System.out.println(method2(str));
    }
    public String method2(String s) {
        StringBuilder sb=new StringBuilder();
        char[] cs=s.toCharArray();
        int ptrSlow=0,ptrQuick=ptrSlow+1;
        int nextSpaceIndex=0;
        for(int i=0;i<cs.length;i++){
            if(cs[i]==' '||i==cs.length-1){
                nextSpaceIndex=i;
                if(i!=cs.length-1){
                    ptrQuick=i-1;
                }else {
                    ptrQuick=i;
                }
                while(ptrSlow<=ptrQuick){
                    sb.append(cs[ptrQuick--]);
                }
                if(i!=cs.length-1){
                    sb.append(' ');
                }
                ptrSlow=i+1;
            }
        }
        return sb.toString();
    }

    public String method1(String s) {
        StringBuilder sb=new StringBuilder();
        String ss[]=s.split(" ");
        for(int i=0;i<ss.length;i++){
            int ptr=ss[i].length()-1;
            while(ptr>=0){
                sb.append(ss[i].charAt(ptr));
                ptr--;
            }
            if(i!=ss.length-1){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
