package com.yize.leetcode;

import org.junit.Test;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 *
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 示例 2:
 *
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L55 {
    @Test
    public void test(){
        int[] nums={3,2,0,0,1};
        System.out.println(canJump(nums));
    }

    /**
     * 执行结果：
     * 通过
     * 显示详情
     * 执行用时 :
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 99.98%
     * 的用户
     * 内存消耗 :
     * 38.1 MB
     * , 在所有 Java 提交中击败了
     * 76.12%
     * 的用户
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int curr=nums.length-2;
        int zeroIdx=curr;
        while (curr>=0){
            while (nums[curr]!=0){//指针移动到值为0的位置
                curr--;
                zeroIdx=curr;
                if(curr==-1){
                    return true;
                }
            }
            while (curr>=0&&nums[curr]<=(zeroIdx-curr)){//看一下是否有能跳过自身位置的节点
                curr--;
                if(curr==-1){
                    return false;
                }
            }
        }
        return true;
    }
}
