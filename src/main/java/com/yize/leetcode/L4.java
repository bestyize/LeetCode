package com.yize.leetcode;

import org.junit.Test;

/**
 * 执行结果：
 * 通过
 * 显示详情
 * 执行用时 :
 * 3 ms
 * , 在所有 Java 提交中击败了
 * 98.43%
 * 的用户
 * 内存消耗 :
 * 47.4 MB
 * , 在所有 Java 提交中击败了
 * 14.56%
 * 的用户
 * 炫耀一下:
 */

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L4 {
    @Test
    public void test(){
        int[]a={};
        int[]b={3,7};
        double s=method1(a,b);
        System.out.println(s);
    }

    /**
     *时间复杂度O(m+n)，不满足题目要求
     * @param nums1
     * @param nums2
     * @return
     */
    public double method1(int[] nums1, int[] nums2) {
        int[] meger=new int[nums1.length+nums2.length];
        if(nums1.length<nums2.length){
            int temp[]=nums1;
            nums1=nums2;
            nums2=temp;
        }
        int ptr1=0,ptr2=0;
        int count=0;
        while (ptr1<nums1.length&&ptr2<nums2.length){
            if(nums1[ptr1]>nums2[ptr2]){
                meger[count]=nums2[ptr2];
                ptr2++;
            }else {
                meger[count]=nums1[ptr1];
                ptr1++;
            }
            count++;
        }
        while (ptr1<nums1.length){
            meger[count++]=nums1[ptr1++];
        }
        while (ptr2<nums2.length){
            meger[count++]=nums2[ptr2++];
        }

        int medium=meger.length>>1;
        double result=meger[medium];
        if(meger.length%2==0){
            medium=(meger.length-1)>>1;
            result=(meger[medium]+meger[medium+1])/2.0;
        }
        return result;
    }


}
