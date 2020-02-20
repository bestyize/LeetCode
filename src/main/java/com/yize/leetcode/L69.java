package com.yize.leetcode;

import org.junit.Test;

/**
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L69 {
    @Test
    public void test(){
        System.out.println(mySqrt(7));
    }
    public int mySqrt(int x) {
        return method1(x);
    }

    public int method1(int x){
        int start=1;
        int end=x>>1;
        while (start<=end){
            int mid =(start+end)>>1;
            if (mid==x/mid){
                /// mid * mid == x
                return mid;
            }else if(mid<x/mid &&(mid+1)>x/(mid+1)){
                /// mid * mid < x  && (mid + 1) * (mid + 1) > x
                return mid;
            }else if(mid>x/mid){
                end=mid-1;
            }else {
                start=mid+1;
            }
        }
        return x;/// x = 0, 1的时候,直接return x
    }
}
