package com.yize.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return method1(candidates,target);
    }
    public List<List<Integer>> method1(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(result,new ArrayList<>(),candidates,target,0);
        return result;
    }

    public void backTrack(List<List<Integer>> result,List<Integer> item,int[] candidates,int target,int startIndex){
        if(target<0){
            return;
        }
        if(target==0){
            result.add(new ArrayList<>(item));
            return;
        }
        for(int i=startIndex;i<candidates.length&&candidates[i]<=target;i++){
            item.add(candidates[i]);
            backTrack(result,item,candidates,target-candidates[i],i);
            item.remove(item.size()-1);
        }
    }
}
