package com.yize.tencent;

import org.junit.Test;

public class MostCharInString {
    @Test
    public void test(){
        System.out.println(mostCharInString("abcccddAA"));
    }


    public char mostCharInString(String str){
        int[] map=new int['z'+1];
        char[] cs=str.toCharArray();
        for (char c:cs){
            map[c]++;
        }
        int max=0;
        char c=' ';
        for (int i='A';i<='z';i++){
            if(map[i]>max){
                max=map[i];
                c=(char)i;
            }
        }
        return c;
    }
}
