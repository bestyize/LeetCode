package com.yize.bytedance;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 *  
 *
 * 示例 1:
 *
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 输出: 1
 * 示例 2:
 *
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * 输出: 3
 * 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IslandCount {
    public int islandCount(int[][] matrix){
        int count=0;
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==1){
                    dfs(matrix,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int[][] matrix,int i,int j){
        if(i<0||i>=matrix.length||j<0||j>=matrix[0].length||matrix[i][j]!=1){
            return;
        }
        matrix[i][j]=2;
        dfs(matrix,i-1,j);
        dfs(matrix,i+1,j);
        dfs(matrix,i,j-1);
        dfs(matrix,i,j+1);
    }
}
