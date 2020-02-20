package com.yize.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L46 {
    @Test
    public void test(){
        int[] nums=new int[]{1,2,3};
        System.out.println(permute(nums));
    }

    public List<List<Integer>> permute(int[] nums) {
        return method1(nums);
    }

    public List<List<Integer>> method1(int[] nums) {
        List<List<Integer>> lists=new ArrayList<>();
        backTrack(lists,new ArrayList<>(),nums);
        return lists;

    }

    /**
     * 这篇文章是很久之前的一篇《回溯算法详解》的进阶版，之前那篇不够清楚，就不必看了，看这篇就行。把框架给你讲清楚，你会发现回溯算法问题都是一个套路。
     *
     * 废话不多说，直接上回溯算法框架。解决一个回溯问题，实际上就是一个决策树的遍历过程。你只需要思考 3 个问题：
     *
     * 1、路径：也就是已经做出的选择。
     *
     * 2、选择列表：也就是你当前可以做的选择。
     *
     * 3、结束条件：也就是到达决策树底层，无法再做选择的条件。
     *
     * 如果你不理解这三个词语的解释，没关系，我们后面会用「全排列」和「N 皇后问题」这两个经典的回溯算法问题来帮你理解这些词语是什么意思，现在你先留着印象。
     *
     * 代码方面，回溯算法的框架：
     *
     * result = []
     * def backtrack(路径, 选择列表):
     *     if 满足结束条件:
     *         result.add(路径)
     *         return
     *
     *     for 选择 in 选择列表:
     *         做选择
     *         backtrack(路径, 选择列表)
     *         撤销选择
     *
     * 作者：labuladong
     * 链接：https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-xiang-jie-by-labuladong-2/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param lists
     * @param trackList
     * @param nums
     */
    public void backTrack(List<List<Integer>> lists,List<Integer> trackList,int[]nums){
        if(trackList.size()==nums.length){
            lists.add(new ArrayList<>(trackList));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(trackList.contains(nums[i])){
                continue;
            }
            trackList.add(nums[i]);
            backTrack(lists,trackList,nums);
            trackList.remove(trackList.size()-1);
        }
    }
}
