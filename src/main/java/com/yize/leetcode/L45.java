package com.yize.leetcode;

import org.junit.Test;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 示例:
 *
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 说明:
 *
 * 假设你总是可以到达数组的最后一个位置。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L45 {
    @Test
    public void test(){
        int nums[]={2,3,1,1,4};
        System.out.println(jump(nums));
    }
    public int jump(int[] nums) {
        return method1(nums);
    }
    public int method1(int[] nums) {
        int minStep=0;
        int bound=0;
        int maxPos=0;
        for (int i=0;i<nums.length-1;i++){
            maxPos=Math.max(maxPos,nums[i]+i);
            if(i==bound){//从i走到bound,获取i到bound中最大的pos，作为下一个Pos
                bound=maxPos;
                minStep++;
            }
        }

        return minStep;
    }
}
