package com.yize.nowcoder;

/**
 * 调整奇数在前，偶数在后
 */
public class AdjustArrayByOdd {
    public int[] reorderArray(int[] nums){
        int ptrOdd=nums.length-1,ptrEven=0;
        int[] result=new int[nums.length];
        for (int i=0;i<nums.length;i++){
            if((nums[i]&1)!=0){
                result[ptrEven++]=nums[i];
            }
        }
        for (int i= nums.length-1;i>=0;i--){
            if((nums[i]&1)==0){
                result[ptrEven--]=nums[i];
            }
        }
        return result;
    }
}
