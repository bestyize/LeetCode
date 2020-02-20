package com.yize.leetcode;

import org.junit.Test;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L34 {
    @Test
    public void test(){
        int a[]={5,7,7,8,8,10};
        int rr[]=searchRange(a,5);
        System.out.println(rr);
    }

    public int[] searchRange(int[] nums, int target) {
        return method1(nums,target);
    }

    public int[] method1(int[] nums, int target) {
        if(nums.length==0){
            return new int[]{-1,-1};
        }
        int low=0,high=nums.length-1;
        int pos=-1;
        while (low<=high){
            int mid=(low+high)>>1;
            if(nums[mid]<target){
                low=mid+1;
            }else if(nums[mid]>target){
                high=mid-1;
            }else {
                pos=mid;
                break;
            }
        }
        if(pos==-1){
            return new int[]{-1,-1};
        }

        int ptrLeft=pos-1;
        int ptrRight=pos+1;
        while (ptrLeft>=0){
            if(nums[ptrLeft]==target){
                ptrLeft--;
            }else {
                break;
            }
        }
        while (ptrRight<nums.length){
            if(nums[ptrRight]==target){
                ptrRight++;
            }else {
                break;
            }
        }
        return new int[]{ptrLeft+1,ptrRight-1};
    }
}
