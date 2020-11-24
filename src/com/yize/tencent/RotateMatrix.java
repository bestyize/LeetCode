package com.yize.tencent;

import org.junit.Test;

/**
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RotateMatrix {
    @Test
    public void test(){
        int n=3;
        int[][] matrix=generateMatrix(n);
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println();
        }
    }

    public int[][] generateMatrix(int n) {
        int max=n*n;
        int layer=0;
        int count=1;
        int[][] matrix=new int[n][n];
        while (count<=max){
            for (int i=layer;i<n-layer&&count<=max;i++){
                matrix[layer][i]=count*count;
                count++;

            }
            for (int i=layer+1;i<n&&count<=max;i++){
                matrix[i][n-1-layer]=count*count;
                count++;
            }
            for (int i=n-1-layer-1;i>=layer&&count<=max;i--){
                matrix[n-1-layer][i]=count*count;
                count++;
            }
            for (int i=n-1-layer-1;i>layer&&count<=max;i--){
                matrix[i][layer]=count*count;
                count++;
            }
            layer++;
        }
        return matrix;

    }
}
