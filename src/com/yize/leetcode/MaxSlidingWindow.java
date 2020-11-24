package com.yize.leetcode;

import java.util.LinkedList;

public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result=new int[nums.length];
        LinkedList<Integer> queue=new LinkedList<>();
        for (int i=0;i<nums.length;i++){
            while (queue.size()>0&&nums[queue.peekLast()]<=nums[i]){
                queue.pollLast();
            }
            queue.offerLast(i);
            if(queue.peekFirst()<=i-k){
                queue.pollFirst();
            }
            if(i-k+1>=0){
                result[i-k+1]=nums[queue.peekFirst()];
            }
        }
        return result;
    }
}
