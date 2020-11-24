package com.yize.tencent;

import java.util.Random;

/**
 * 洗牌算法
 */
public class ReShuffer {
    public int[] reShuffer(int[] nums){
        Random ran=new Random();
        for (int i=0;i< nums.length;i++){
            nums[i]=i;
        }
        for (int i=0;i< nums.length;i++){
            swap(nums,ran.nextInt(nums.length),ran.nextInt(nums.length));
        }
        return nums;
    }

    private void swap(int[] nums,int i,int j){
        int temp= nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
