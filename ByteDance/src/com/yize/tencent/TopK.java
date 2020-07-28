package com.yize.tencent;

import jdk.nashorn.internal.ir.GetSplitState;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class TopK {
    /**
     * 小顶堆
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKSolution1(int[] nums,int k){
        List<Integer> result=new LinkedList<>();
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        for (int i:nums){
            if(queue.size()<k){
                queue.offer(i);
            }else {
                if(queue.peek()<i){
                    queue.poll();
                    queue.offer(i);
                }

            }
        }
        while (queue.isEmpty()==false){
            result.add(queue.poll());
        }
        return result;
    }

    /**
     * 快速选择
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKSolution2(int[] nums,int k){
        List<Integer> result=new LinkedList<>();
        quickSelect(nums,0,nums.length-1,k);
        for (int i=0;i<k;i++){
            result.add(nums[i]);
        }
        return result;
    }

    public void quickSelect(int[] nums,int left,int right,int k){
        if (left<right){
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
            swap(nums,i,left);
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
