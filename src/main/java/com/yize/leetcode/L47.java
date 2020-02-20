package com.yize.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L47 {
    @Test
    public void test(){
        int nums[]={1,1,2};
        System.out.println(permuteUnique(nums));
    }

    /**
     * 执行用时 :
     * 477 ms
     * , 在所有 Java 提交中击败了
     * 5.06%
     * 的用户
     * 内存消耗 :
     * 42.4 MB
     * , 在所有 Java 提交中击败了
     * 15.21%
     * 的用户
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> lists=new ArrayList<>();
        if(nums.length==0){
            return lists;
        }
        backTrack(lists,new ArrayList<>(),new ArrayList<>(),nums);
        return lists;
    }

    public void backTrack(List<List<Integer>> lists,List<Integer> item,List<Integer> itemIndex,int[]nums){
        if(item.size()==nums.length){
            for(List<Integer> list:lists){
                if(list.equals(item)){
                    return;
                }
            }
            lists.add(new ArrayList<>(item));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!itemIndex.contains(i)){
                itemIndex.add(i);
                item.add(nums[i]);
                backTrack(lists,item,itemIndex,nums);
                item.remove(item.size()-1);
                itemIndex.remove(itemIndex.size()-1);
            }
        }
    }
}
