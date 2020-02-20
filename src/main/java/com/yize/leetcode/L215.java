package com.yize.leetcode;

import java.util.PriorityQueue;

public class L215 {
    public int findKthLargest(int[] nums, int k) {
        if(k>nums.length||nums.length==0){
            return -1;
        }
        PriorityQueue<Integer> queue=new PriorityQueue<>(k);
        for(int i=0;i<nums.length;i++){
            if(queue.size()<k){
                queue.offer(nums[i]);
            }else{
                if(queue.peek().compareTo(nums[i])<=0){
                    queue.poll();
                    queue.offer(nums[i]);
                }
            }
        }
        return queue.poll();
    }
}
