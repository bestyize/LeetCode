package com.yize.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * 示例 2:
 *
 * 输入:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/set-matrix-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L73 {
    @Test
    public void test(){
        int matrix[][]={{1,2,3},{4,0,6},{7,8,9}};
        setZeroes(matrix);
        printMatrix(matrix);
    }

    private void printMatrix(int[][] matrix){
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                sb.append(matrix[i][j]+"\t");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public void setZeroes(int[][] matrix) {
        List<Integer> xList=new ArrayList<>();
        List<Integer> yList=new ArrayList<>();
        for(int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    xList.add(i);
                    yList.add(j);
                }
            }
        }


        for(int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                if(xList.contains(i)||yList.contains(j)){
                    matrix[i][j]=0;
                }
            }
        }
    }
}
