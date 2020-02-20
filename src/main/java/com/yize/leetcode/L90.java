package com.yize.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: [1,2,2]
 * 输出:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L90 {
    @Test
    public void test(){
        System.out.println(subsetsWithDup(new int[]{1,2,2}));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists=new ArrayList<>();
        lists.add(new ArrayList<>());
        backTrack(lists,new ArrayList<>(),0,nums);
        return lists;
    }
    public void backTrack(List<List<Integer>> lists,List<Integer> item,int start,int[]nums){
        for(int i=start;i<nums.length;i++){
            if(i>start&&nums[i]==nums[i-1]){
                continue;
            }
            item.add(nums[i]);
            lists.add(new ArrayList<>(item));
            backTrack(lists,item,i+1,nums);
            item.remove(item.size()-1);
        }
    }

}
