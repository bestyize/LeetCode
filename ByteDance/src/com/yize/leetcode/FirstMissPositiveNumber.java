package com.yize.leetcode;

import org.junit.Test;

/**
 * 缺失的最小正数
 *
 * https://leetcode-cn.com/problems/first-missing-positive/
 */
public class FirstMissPositiveNumber {
    @Test
    public void test(){
        int[] nums={2,4,5,3,6,1};
        System.out.println(firstMissingPositive(nums));
    }

    public int firstMissingPositive(int[] nums) {
        for (int i=0;i< nums.length;i++){
            while (nums[i]>0&&nums[i]< nums.length&&(nums[nums[i]-1]!=nums[i])){
                swap(nums,nums[i]-1,i);
            }
        }
        for (int i=0;i<nums.length;i++){
            if(nums[i]!=i+1){
                return i+1;
            }
        }
        return nums.length+1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp= nums[i];
        nums[i]=nums[j];
        nums[j]=temp;

    }
}
