package com.yize.leetcode;

import org.junit.Test;

/**
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: true
 * 解释: 20 = 1
 * 示例 2:
 *
 * 输入: 16
 * 输出: true
 * 解释: 24 = 16
 * 示例 3:
 *
 * 输入: 218
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-two
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L231 {

    @Test
    public void test(){
        System.out.println(method1(3));
    }

    public boolean method2(int n){
        return n>0&&(n&(n-1))==0;
    }

    public boolean method1(int n) {
        if(n<0){
            return false;
        }
        for (int i=0;i<=31;i++){
            if(n==(1<<i)){
                return true;
            }
        }
        return false;
    }
}
