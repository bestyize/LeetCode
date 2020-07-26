package com.yize.tencent;

import org.junit.Test;

/**
 * 无序数组的中位数O(N)的解法
 * 思路：快速选择，然后在左边找最小元素
 */
public class MediumNumberOfMixArray {
    @Test
    public void test(){
        int[] nums={7,5,9,3,11,32,27,1,-9,4};
        //-9,1,3,4,5,7,9,11,27,32
        System.out.println(mediumNUmberOfMixArray(nums));
    }


    public int mediumNUmberOfMixArray(int[] nums){
        int k=nums.length/2+1;
        quickSelect(nums,0,nums.length-1,k);
        int m1=nums[k-1];
        if(nums.length%2==1){
            return m1;
        }else {
            int m2=Integer.MAX_VALUE;
            for (int i=0;i<k-1;i++){
                m2=Math.min(m2,nums[i]);
            }
            return (m1+m2)/2;
        }

    }
    public void quickSelect(int[] nums,int left,int right,int k){
        if(left<right){
            int i=left,j=right;
            int pivot=nums[left];
            while (i<j){
                while (i<j&&nums[j]<=pivot){
                    j--;
                }
                while (i<j&&nums[i]>=pivot){
                    i++;
                }
                if(i<j){
                    swap(nums,i,j);
                }
            }
            swap(nums,i,left);//恢复枢纽元
            if(i>=k){
                quickSelect(nums,left,i-1,k);
            }else {
                quickSelect(nums,i+1,right,k);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

}
