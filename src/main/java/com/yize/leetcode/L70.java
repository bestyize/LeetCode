package com.yize.leetcode;

import org.junit.Test;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L70 {
    @Test
    public void test(){
        System.out.println(climbStairs(3));
    }

    /**
     * 执行结果：
     * 通过
     * 显示详情
     * 执行用时 :
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗 :
     * 33 MB
     * , 在所有 Java 提交中击败了
     * 48.60%
     * 的用户
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if(n<3){
            return n;
        }
        int num1=1,num2=2;
        while(n-2>0){
            int temp=num2;
            num2=num2+num1;
            num1=temp;
            n--;
        }
        return num2;

    }
}
