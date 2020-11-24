package com.yize.tencent;

public class MergeSort {

    public void mergeSort(int[] nums){
        mergeSort(nums,0,nums.length-1);
    }

    private void mergeSort(int[] nums, int left, int right) {
        if(left<right){
            int mid=(left+right)>>1;
            mergeSort(nums,left,mid);
            mergeSort(nums,mid+1,right);
            merge(nums,left,mid,right);
        }
    }

    public void merge(int[] nums,int left,int mid,int right){
        int temp[]=new int[right-left+1];
        int curr=0;
        int ptrLeft=left,ptrRight=mid+1;
        while (ptrLeft<=mid&&ptrRight<=right){
            if(nums[ptrLeft]<=nums[ptrRight]){
                temp[curr++]=nums[ptrLeft++];
            }else {
                temp[curr++]=nums[ptrRight++];
            }
        }
        while (ptrLeft<mid){
            temp[curr++]=nums[ptrLeft++];
        }
        while (ptrRight<mid){
            temp[curr++]=nums[ptrRight++];
        }
        for (int i=left;i<=right;i++){
            nums[i]=temp[left+i];
        }


    }
}
