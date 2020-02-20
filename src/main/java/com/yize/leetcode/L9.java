package com.yize.leetcode;

import org.junit.Test;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 *
 * 你能不将整数转为字符串来解决这个问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L9 {
    @Test
    public void test(){
        System.out.println(isPalindrome(111));
    }
    public boolean isPalindrome(int x) {
        return method3(x);
    }

    /**
     * 中间向两边
     * @param x
     * @return
     */
    public boolean method1(int x) {
        if(x<0){
            return false;
        }
        String str=String.valueOf(x);
        int medium=str.length()>>1;
        int left=medium-1;
        int right=medium+1;
        if(str.length()%2==0){
            left=medium-1;
            right=medium;
        }
        while (left>=0&&right<str.length()){
            if(str.charAt(left--)!=str.charAt(right++)){
                return false;
            }
        }
        if(left==-1&&right==str.length()){
            return true;
        }
        return false;
    }

    /**
     * 两边向中间
     * @param x
     * @return
     */
    public boolean method2(int x) {
        if (x < 0) {
            return false;
        }
        String str = String.valueOf(x);
        int left=0,right=str.length()-1;
        while (left<=right){
            if(str.charAt(left)!=str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * 通过颠倒数字顺序判断是否是回文
     * @param x
     * @return
     */
    public boolean method3(int x){
        if(x<0){
            return false;
        }
        int reverse=x;
        int result=0;
        while (reverse!=0){
            result=result*10+reverse%10;
            reverse/=10;
        }
        return result==x;

    }
}
