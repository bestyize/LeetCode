package com.yize.tencent;

import org.junit.Test;

/**
 * 旋转数组的最小值
 */
public class MiniNumberOfRotateArray {
    @Test
    public void test(){
        int[] nums={1,1,0,1,1,1,1};
        System.out.println(miniNumberOfRotateArray(nums));
    }

    public int miniNumberOfRotateArray(int[] nums){
        int low=0,high=nums.length-1;
        while (low<high){
            int mid=(low+high)>>1;
            if(nums[high]>nums[mid]){
                high=mid;
            }else if(nums[high]<nums[mid]){
                low=mid+1;
            }else {
                high--;
            }
        }
        return nums[low];
    }
}
