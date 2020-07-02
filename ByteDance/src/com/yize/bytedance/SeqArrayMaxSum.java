package com.yize.bytedance;

public class SeqArrayMaxSum {


    /**
     * 最大子序和，解题思路：最大子序列的开头必然不是负数
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int max=nums[0];
        int currSum=max;
        for (int i=1;i<nums.length;i++){
            currSum=Math.max(currSum+nums[i],nums[i]);
            max=Math.max(currSum,max);
        }
        return max;
    }
}
