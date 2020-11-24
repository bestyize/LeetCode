package com.yize.tencent;

/**
 * 除了这两个数之外，都出现了两次，这两个只出现了一次
 */
public class JustOnceNumberTwo {
    public int[] justOnceNumber(int[] nums){
        int result=0;
        for (int n:nums){
            result^=n;//n1是两个数字亦或值
        }
        int a=0,b=0;
        for (int i=31;i>=0;i--){
            int mask=(1<<i);
            if((mask&result)!=0){//这两个数至少有一位不同
                for (int n:nums){
                    if((n&mask)!=0){
                        a^=n;
                    }else {
                        b^=n;
                    }
                }
                break;
            }
        }
        return new int[]{a,b};

    }
}
