package com.yize.bytedance;

public class OrderlessArrayMediumNumber {
    public int middleNumberOfOrderlessArray(int[] nums){
        if(nums.length%2==0){
            int n1=nums.length/2;
            int n2=nums.length/2+1;
            quickSelect(nums,0,nums.length-1,n1);
            int num1=nums[n1-1];
            quickSelect(nums,0,nums.length-1,n2);
            int num2=nums[n2-1];
            return (num1+num2)>>1;

        }else {
            int n=nums.length/2+1;
            quickSelect(nums,0,nums.length-1,n);
            return nums[n-1];
        }
    }

    private void quickSelect(int[] nums,int k){
        quickSelect(nums,0,nums.length-1,k);
    }

    private void quickSelect(int[] nums,int left,int right,int k){
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
            swap(nums,left,i);
            if(i>=k){
                quickSelect(nums,left,i-1,k);
            }else {
                quickSelect(nums,i+1,right,k);
            }
        }
    }

    private void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
