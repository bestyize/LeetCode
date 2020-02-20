package com.yize.leetcode;

import org.junit.Test;

/**
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 * 说明：m 和 n 的值均不超过 100。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L63 {
    @Test
    public void test(){
        int aa[][]={{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquePathsWithObstacles(aa));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length==0||obstacleGrid[0][0]==1){
            return 0;
        }
        int m=obstacleGrid.length,n=obstacleGrid[0].length;
        int[][] dp=new int[m][n];
        for(int i=0;i<n&&obstacleGrid[0][i]==0;i++){
            dp[0][i]=1;
        }
        for(int i=0;i<m&&obstacleGrid[i][0]==0;i++){
            dp[i][0]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(obstacleGrid[i][j]!=1){
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }else{
                    dp[i][j]=0;
                }
            }
        }
        return dp[m-1][n-1];
    }
}
