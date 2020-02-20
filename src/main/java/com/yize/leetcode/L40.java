package com.yize.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L40 {
    @Test
    public void test(){
        int[] candidates={2,5,2,1,2};
        int target=5;
        System.out.println(combinationSum2(candidates,target));
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        return method1(candidates,target);
    }

    /**
     * 执行结果：
     * 通过
     * 显示详情
     * 执行用时 :
     * 5 ms
     * , 在所有 Java 提交中击败了
     * 63.10%
     * 的用户
     * 内存消耗 :
     * 39.5 MB
     * , 在所有 Java 提交中击败了
     * 20.32%
     * 的用户
     * 炫耀一下:
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> method1(int[] candidates, int target) {
        List<List<Integer>> lists=new ArrayList<>();
        if(candidates.length==0){
            return lists;
        }
        Arrays.sort(candidates);
        backTrack(lists,new ArrayList<>(),0,candidates,target,0);
        return lists;
    }
    public void backTrack(List<List<Integer>> lists, List<Integer> item, int itemSum, int[] candidates, int target, int startIndex){
        if(itemSum==target){
            for(List<Integer> mm:lists){
                if(mm.equals(item)){
                    return;
                }
            }
            lists.add(new ArrayList<>(item));
            return;
        }
        for(int i=startIndex;i<candidates.length&&candidates[i]<=target;i++){
            if(itemSum+candidates[i]>target){//剪枝，排序后后面所有的数据都不符合条件
                break;
            }
            if(i>startIndex&&candidates[i]==candidates[i-1]){//去掉重复数据
                continue;
            }
            item.add(candidates[i]);
            backTrack(lists,item,itemSum+candidates[i],candidates,target,i+1);
            item.remove(item.size()-1);
        }
    }
}
