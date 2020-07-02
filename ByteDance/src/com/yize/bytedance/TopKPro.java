package com.yize.bytedance;


import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TopKPro {

    /**
     * 使用快排
     */
    class TopKQuickSelectSolution{
        @Test
        public void test(){
            int[] nums={3,5,7,4,2,1,6};
            int k=5;
            System.out.println(getKthBiggerElement(nums,k));
        }

        public int getKthBiggerElement(int[] nums,int k){
            quickSelect(nums,0,nums.length-1,k);
            return nums[k-1];
        }

        public void quickSelect(int[] nums,int low,int high,int k){
            if(low<high){
                int i=low,j=high;
                int pivot=nums[low];
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
                swap(nums,low,i);
                //枢纽元位置大于等于K，那么元素待查找的元素在左边
                if(i>=k){
                    quickSelect(nums,low,i-1,k);
                }else {
                    quickSelect(nums,i+1,high,k);
                }

            }
        }
        private void swap(int[] nums,int i,int j){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }
    }

    /**
     * 使用堆求解
     */
    class TopKHeapSolution {
        @Test
        public void test() {
            int[] nums = {3, 5, 7, 4, 2, 1, 6};
            int k = 5;
            System.out.println(getKthBiggerElement(nums, k));
        }

        public int getKthBiggerElement(int[] nums, int k) {
            if(k>nums.length){
                return -1;
            }
            PriorityQueue<Integer> queue=new PriorityQueue<>();
            for (int i:nums){
                if(queue.size()<k){
                    queue.offer(i);
                }else {
                    if(i>queue.peek()){
                        queue.poll();
                        queue.offer(i);
                    }
                }
            }

            return queue.peek();
        }
    }

}
