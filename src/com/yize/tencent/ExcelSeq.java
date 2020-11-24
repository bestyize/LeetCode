package com.yize.tencent;

import org.junit.Test;

public class ExcelSeq {
    @Test
    public void test(){
        System.out.println(titleToNumber("ZY"));
    }

    public int titleToNumber(String s){
        char[] cs=s.toCharArray();
        int[] map=new int['Z'+1];
        for (int i='A';i<='Z';i++){
            map[i]=i-'A'+1;
        }
        int ptr=cs.length-1;
        int result=0;
        while (ptr>=0){
            result+=Math.pow(26,cs.length-ptr-1)*map[cs[ptr--]];
        }
        return result;
    }
}
