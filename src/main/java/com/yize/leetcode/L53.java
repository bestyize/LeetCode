package com.yize.leetcode;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L53 {
    public int method2(int[] nums) {
        int maxSum=nums[0];
        int tempSum=0;
        for(int i:nums){
            if(tempSum>0){
                tempSum+=i;
            }else {
                tempSum=i;
            }
            maxSum=Math.max(maxSum,tempSum);
        }
        return maxSum;
    }
    public int method1(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int maxSum=0;
        int tempSum=0;
        int max=nums[0];
        for(int i=0;i<nums.length;i++){
            tempSum+=nums[i];
            if(tempSum>0){
                maxSum=Math.max(maxSum,tempSum);
            }else{
                tempSum=0;
            }
            if(max<nums[i]){
                max=nums[i];
            }
        }
        return maxSum>0?maxSum:max;
    }
}
