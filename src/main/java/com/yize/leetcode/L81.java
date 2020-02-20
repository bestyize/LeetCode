package com.yize.leetcode;

import org.junit.Test;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 *
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 *
 * 示例 1:
 *
 * 输入: nums = [2,5,6,0,0,1,2], target = 0
 * 输出: true
 * 示例 2:
 *
 * 输入: nums = [2,5,6,0,0,1,2], target = 3
 * 输出: false
 * 进阶:
 *
 * 这是 搜索旋转排序数组 的延伸题目，本题中的 nums  可能包含重复元素。
 * 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L81 {
    @Test
    public void test(){
        int nums[]={2,2,2,0,2,2};
        System.out.println(search(nums,0));
    }

    /**
     * 执行用时 :
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 99.57%
     * 的用户
     * 内存消耗 :
     * 39.3 MB
     * , 在所有 Java 提交中击败了
     * 36.63%
     * 的用户
     * @param nums
     * @param target
     * @return
     */
    public boolean search(int[] nums, int target) {
        if(nums.length==0){
            return false;
        }
        int low=0,high=nums.length-1;
        int mid=(low+high)>>1;
        while (low<=high){
            mid=(low+high)>>1;
            if(nums[mid]>nums[low]||nums[mid]>nums[high]){
                low=mid+1;
            }else if(nums[mid]<nums[low]||nums[mid]<nums[high]){
                high=mid;
            }else if(mid!=low&&mid!=high&&(nums[high]==nums[mid]&&nums[low]==nums[mid])){
                low++;
            }else {
                while (mid>0){
                    if(nums[mid-1]>nums[mid]){
                        break;
                    }
                    mid--;
                }

                break;
            }
        }
        return findNum(nums,0,mid-1,target)||findNum(nums,mid,nums.length-1,target);
    }

    public boolean findNum(int nums[],int low,int high,int target){
        while (low<=high){
            int mid=(low+high)>>1;
            if(nums[mid]>target){
                while (mid>0){
                    if(nums[mid]!=nums[mid-1]){
                        break;
                    }
                    mid--;
                }
                high=mid-1;
            }else if(nums[mid]<target){
                while (mid<nums.length-1){
                    if(nums[mid]!=nums[mid+1]){
                        break;
                    }
                    mid++;
                }
                low=mid+1;
            }else {
                return true;
            }
        }
        return false;
    }

}
