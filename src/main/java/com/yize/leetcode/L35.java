package com.yize.leetcode;

import org.junit.Test;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L35 {
    @Test
    public void test(){
        int a[]={5,7,7,8,8,10};
        int r=searchInsert(a,100);
        System.out.println(r);
    }


    public int searchInsert(int[] nums, int target) {
        return method1(nums,target);
    }

    public int method1(int[] nums, int target) {
        if(nums.length==0){
            return -1;
        }
        int low=0,high=nums.length-1;
        int pos=-1;

        while (low<=high){
            int mid=(low+high)>>1;
            if(nums[mid]>target){
                high=mid-1;
            }else if(nums[mid]<target){
                low=mid+1;
            }else {
                pos=mid;
                break;
            }
        }
        if(pos!=-1){
            return pos;
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i]>target){
                return i;
            }
        }
        return nums.length;


    }
}
