package com.yize.tencent;

import org.junit.Test;

/**
 * 有一个数字只出现一次，其他都出现两次
 */
public class JustOnceNumber {
    @Test
    public void test(){
        int[] nums={1,2,2,1,4,5,5};
        System.out.println(justOnce(nums));
    }

    public int justOnce(int[] nums){
        int n=0;
        for (int i:nums){
            n=n^i;
        }
        return n;
    }
}
