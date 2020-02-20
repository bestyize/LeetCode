package com.yize.leetcode;

import org.junit.Test;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L33 {
    @Test
    public void test(){
        int a[]={4,5,6,7,0,1,2};
        int pos=search(a,1);
        System.out.println(pos);
    }

    public int search(int[] nums, int target) {
        return method1(nums,target);
    }

    /**
     * 执行结果：
     * 通过
     * 显示详情
     * 执行用时 :
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 92.48%
     * 的用户
     * 内存消耗 :
     * 37.7 MB
     * , 在所有 Java 提交中击败了
     * 17.00%
     * 的用户
     * @param nums
     * @param target
     * @return
     */
    public int method1(int[] nums, int target) {
        if(nums.length==0){
            return -1;
        }
        int low=0,high=nums.length-1;
        int point=0;
        while (low<=high){
            int mid=(low+high)>>1;
            if(nums[mid]<nums[low]||nums[mid]<nums[high]){
                high=mid;
            }else if(nums[mid]>nums[low]||nums[mid]>nums[high]){
                low=mid+1;
            }else {
                point=low;
                break;
            }
        }
        //point就是旋转点
        if(target>nums[nums.length-1]){
            return find(nums,target,0,point-1);
        }else {
            return find(nums,target,point,nums.length-1);
        }
    }

    public int find(int[] array,int target,int low,int high){
        while (low<=high){
            int mid=(high+low)>>1;
            if(array[mid]>target){
                high=mid-1;
            }else if(array[mid]<target){
                low=mid+1;
            }else {
                return mid;
            }
        }
        return -1;
    }


}
