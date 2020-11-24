package com.yize.bytedance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class TopKIncreaseArray {


    /**
     * 找出一个数组的长度Top k的升序子数组，并按长度降序输出
     * @param nums
     */
    public List<List<Integer>> topKIncreaseArray(int[] nums, int k){
        List<List<Integer>> result=new LinkedList<>();
        if(nums.length<k){
            return result;
        }
        int dp[]=new int[nums.length];
        dp[0]=1;
        for (int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                dp[i]=dp[i-1]+1;
            }else {
                dp[i]=1;
            }
        }
        while (k-->0){
            int curMax=dp[0];
            int currMaxIndex=0;
            for (int i=0;i<dp.length;i++){
                if(dp[i]>curMax){
                    curMax=dp[i];
                    currMaxIndex=i;
                }
            }
            List<Integer> items=new LinkedList<>();
            while (curMax-->0){
                items.add(0,nums[currMaxIndex]);
                dp[currMaxIndex]=1;
                currMaxIndex--;
            }
            result.add(items);
        }
        return result;
    }
}
