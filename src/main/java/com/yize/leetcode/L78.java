package com.yize.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class L78 {
    @Test
    public void test(){
        System.out.println(subsets(new int[]{1,2,3}));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists=new ArrayList<>();
        lists.add(new ArrayList<>());
        backTrack(lists,new ArrayList<>(),nums,0);
        return lists;

    }
    private void backTrack(List<List<Integer>> lists,List<Integer> item,int[] nums,int start){
        if(!lists.contains(item)){
            lists.add(new ArrayList<>(item));
        }
        for (int i=start;i<nums.length;i++){
            item.add(nums[i]);
            backTrack(lists,item,nums,i+1);
            item.remove(item.size()-1);
        }
    }
}
