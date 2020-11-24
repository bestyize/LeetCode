package com.yize.tencent;

import org.junit.Test;

public class BigNumberMul {
    @Test
    public void test(){
      System.out.println(multiply("0","0"));
    }
    public String multiply(String num1, String num2) {
        if(num1==null||num2==null||num1.isEmpty()||num2.isEmpty()){
            return null;
        }
        char cs1[]=num1.toCharArray();
        char cs2[]=num2.toCharArray();
        int len1=cs1.length,len2=cs2.length;
        int[] result=new int[len1+len2];
        for (int i=len1-1;i>=0;i--){
            for (int j=len2-1;j>=0;j--){
                int val=(cs1[i]-'0')*(cs2[j]-'0')+result[i+j+1];
                result[i+j+1]=val%10;
                result[i+j]+=val/10;
            }
        }
        int ptr=0;
        while (ptr<result.length&&result[ptr]==0){
            ptr++;
        }
        StringBuffer sb=new StringBuffer();
        while (ptr<result.length){
            sb.append(result[ptr++]);
        }
        return sb.toString().isEmpty()?"0":sb.toString();
    }
}
