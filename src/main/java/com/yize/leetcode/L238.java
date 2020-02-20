package com.yize.leetcode;

public class L238 {
    public int[] productExceptSelf(int[] nums) {
        int[]leftMul=new int[nums.length];
        int[]rightMul=new int[nums.length];
        leftMul[0]=1;
        rightMul[rightMul.length-1]=1;
        for(int i=1;i<nums.length;i++){
            leftMul[i]=nums[i]*leftMul[i-1];
        }

        for(int j=nums.length-1;j>=0;j--){
            rightMul[j]=rightMul[j+1]*nums[j];
        }
        int [] result=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            result[i]=leftMul[i]*rightMul[i];
        }
        return result;
    }
}
