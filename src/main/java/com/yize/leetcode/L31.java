package com.yize.leetcode;

import org.junit.Test;

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * 在真实的面试中遇到过这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L31 {
    @Test
    public void test(){
        int[] aa=new int[]{1,3,2};
        nextPermutation(aa);
        for (int i:aa){
            System.out.println(i);
        }
    }

    public void nextPermutation(int[] nums) {
        method1(nums);
    }
    public void method1(int[] nums) {
        if(nums.length==0||nums.length==1){
            return;
        }
        int low=nums.length-2;

        while (low>=0&&nums[low]>=nums[low+1]){
            low--;
        }
        if(low>=0){
            int high=nums.length-1;
            while (high>=0&&nums[high]<=nums[low]){
                high--;
            }
            int temp=nums[low];
            nums[low]=nums[high];
            nums[high]=temp;
        }
        low++;
        //倒序排列
        int high=nums.length-1;
        while (low<high){
            int val=nums[low];
            nums[low]=nums[high];
            nums[high]=val;
            low++;
            high--;
        }

    }




}
