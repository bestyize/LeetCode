package com.yize.leetcode;

import org.junit.Test;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 *
 *
 *
 * 例如，上图是一个7 x 3 的网格。有多少可能的路径？
 *
 * 说明：m 和 n 的值均不超过 100。
 *
 * 示例 1:
 *
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * 示例 2:
 *
 * 输入: m = 7, n = 3
 * 输出: 28
 * 在真实的面试中遇到过这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L62 {
    @Test
    public void test(){
        System.out.println(method2(19,13));
    }

    /**
     * 动态规划，令dp[i][j]是到达i,j的路径数量
     * 那么dp[i][j]=dp[i-1][j]+dp[i][j-1]
     * 由于只能向下或者向右移动，那么第一行和第一列都只有一种走法
     * 所以：dp[0][0-n]=1;dp[0-m][0]=1
     * @param m
     * @param n
     * @return
     */
    public int method2(int m,int n){
        int[][]dp=new int[m][n];
        for(int i=0;i<m;i++){
            dp[i][0]=1;
        }
        for(int i=0;i<n;i++){
            dp[0][i]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    /**
     * 公式法
     * @param m
     * @param n
     * @return
     */
    public int method1(int m, int n) {
        return (int)(mmul(m+n-2)/(mmul(n-1)*mmul(m-1)));
    }
    private double mmul(double n){
        if(n==1||n==0){
            return 1;
        }
        return n*mmul(n-1);
    }




}
