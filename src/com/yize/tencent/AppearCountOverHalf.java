package com.yize.tencent;

import org.junit.Test;

public class AppearCountOverHalf {
    @Test
    public void test(){
        int[] nums={1,3,5,1,2,1,0,1,1,1,0};
        System.out.println(findNumAppearCountOverHalf(nums));
    }


    /**
     * 找出一个数组中出现次数大于数组长度一半的数  摩尔记数法
     * @param nums
     * @return
     */
    public int findNumAppearCountOverHalf(int[] nums){
        int count=0;
        int num=nums[0];
        for (int n:nums){
            if(count==0){
                num=n;
                count=1;
            }else {
                if(n==num){
                    count++;
                }else {
                    count--;
                }
            }
        }
        count=0;
        for (int n:nums){
            if(n==num){
                count++;
            }
        }
        return count>nums.length/2?num:-1;
    }
}
