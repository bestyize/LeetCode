package com.yize.bytedance;

import org.junit.Test;

public class MaxNumberInString {
    @Test
    public void test(){
        System.out.println(maxNumberInString("www1234rrr,8913,111xxx"));
    }
    public int maxNumberInString(String str){
        char [] cs=str.toCharArray();
        int max=Integer.MIN_VALUE;
        int currPtr=0;
        while (currPtr<cs.length){
            while (currPtr<cs.length&&!isNumber(cs[currPtr])){
                currPtr++;
            }
            int num=0;
            while (currPtr<cs.length&&isNumber(cs[currPtr])){
                num=10*num+(cs[currPtr]-'0');
                currPtr++;
            }
            max=Math.max(num,max);
        }
        return max;
    }

    private boolean isNumber(char c){
        return c>='0'&&c<='9';
    }
}
