package com.yize.bytedance;

import org.junit.Test;

public class SortAlgo {
    public static void main(String[] args) {
        MergeSort mergeSort=new MergeSort();
        int[] nums={2,1,8,6,3,4,2};
        mergeSort.mergeSort(nums);
        for (int n:nums){
            System.out.print(n+"\t");
        }
    }
    static class QuickSort{
        //
    }

    static class MergeSort{
        public void mergeSort(int[] nums){
            mergeSort(nums,0,nums.length-1);
        }

        public void mergeSort(int[] nums,int left,int right){
            if(left<right){
                int mid=(left+right)>>1;
                mergeSort(nums,left,mid);
                mergeSort(nums,mid+1,right);
                merge(nums,left,mid,right);
            }
        }

        private void merge(int[] nums, int left, int mid, int right) {
            int[] temp=new int[right-left+1];
            int curr=0;
            int i=left,j=mid+1;
            while (i<=mid&&j<=right){
                if(nums[i]<=nums[j]){
                    temp[curr++]=nums[i++];
                }else {
                    temp[curr++]=nums[j++];
                }
            }
            while (i<=mid){
                temp[curr++]=nums[i++];
            }
            while (j<=right){
                temp[curr++]=nums[j++];
            }
            for (int pos=0;pos<temp.length;pos++){
                nums[left++]=temp[pos];
            }
        }
    }
}
