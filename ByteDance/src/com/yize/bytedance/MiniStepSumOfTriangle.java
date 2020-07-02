package com.yize.bytedance;

import java.util.List;

/**
 * 120. 三角形最小路径和
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 *
 *
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 *
 *
 * 说明：
 *
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 *
 * 解题思路：自底向上的动态规划
 */
public class MiniStepSumOfTriangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.get(triangle.size()-1).size();
        int[] dp=new int[n];
        int layer=triangle.size()-1;
        for (int i=layer;i>=0;i--){
            List<Integer> layerVal=triangle.get(i);
            for (int j=0;j<=i;j++){
                if(i==layer){
                    dp[j]=layerVal.get(j);
                }else {
                    dp[j]=Math.min(dp[j],dp[j+1])+layerVal.get(j);
                }
            }

        }
        return dp[0];
    }
}
