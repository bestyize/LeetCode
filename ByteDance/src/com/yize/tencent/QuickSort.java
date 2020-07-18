package com.yize.tencent;

import org.junit.Test;

public class QuickSort {
    @Test
    public void test(){

    }

    public void quickSort(int[] nums){
        int left=0,right=nums.length;
        quickSort(nums,left,right);
    }

    private void quickSort(int[] nums, int left, int right) {
        if(left<right){
            int i=left,j=right;
            int pivot=left;
            while (i<j){
                while (i<j&&nums[j]>=pivot){
                    j--;
                }
                while (i<j&&nums[i]<=pivot){
                    i++;
                }
                if(i<j){
                    swap(nums,i,j);
                }
            }
            swap(nums,i,left);
            quickSort(nums,left,i-1);
            quickSort(nums,i+1,right);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
