package com.yize.bytedance;

import org.junit.Test;

public class MiniAbsValueOfArray {
    @Test
    public void test(){
        int[] nums={-20,-10,-5,2};
        System.out.println(miniAbsValueOfArray(nums));
    }

    public int miniAbsValueOfArray(int[] nums){
        if(nums.length==0){
            return Integer.MAX_VALUE;
        }
        if(nums[0]>0){
            return nums[0];
        }
        if(nums[nums.length-1]<0){
            return nums[nums.length-1];
        }
        int low=0,high=nums.length-1;
        int currVal=Integer.MAX_VALUE;
        while (low<=high){
            int mid=(low+high)>>1;
            if(nums[mid]>0){
                if(Math.abs(currVal)>Math.abs(nums[mid])){
                    currVal=nums[mid];
                }
                high=mid-1;
            }else if(nums[mid]<0){
                if(Math.abs(currVal)>Math.abs(nums[mid])){
                    currVal=nums[mid];
                }
                low=mid+1;
            }else {
                currVal=nums[mid];
                break;
            }
        }
        return currVal;
    }
}
