package com.yize.leetcode;

/**
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 *
 * 示例 1:
 *
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [3,1,3,4,2]
 * 输出: 3
 * 说明：
 *
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-duplicate-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L287 {
    /**
     快慢指针思想, fast 和 slow 是指针, nums[slow] 表示取指针对应的元素
     注意 nums 数组中的数字都是在 1 到 n 之间的(在数组中进行游走不会越界),
     因为有重复数字的出现, 所以这个游走必然是成环的, 环的入口就是重复的元素,
     即按照寻找链表环入口的思路来做
     **/
    public int findDuplicate(int[] nums) {
        int fast=0,slow=0;
        while (true){
            fast=nums[nums[fast]];//链表下一个节点的下一个节点
            slow=nums[slow];//链表下一个节点你
            if(fast==slow){//快慢指针相遇
                fast=0;//快指针或者慢指针迁移到入口位置，
                // 继续走下去，直到相遇，他们会在入口相遇，也就是重复元素
                while (nums[slow]!=nums[fast]){
                    fast=nums[fast];
                    slow=nums[slow];
                }
                return nums[slow];
            }
        }
    }
}
