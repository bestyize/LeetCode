package com.yize.leetcode;

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
public class L59 {
    public int[][] generateMatrix(int n) {
        int[][] matrix=new int[n][n];
        int value=1;
        int counter=0;
        int count=n;
        while (counter<n){
            for(int i=counter;i<=(n-1)-counter;i++){
                matrix[counter][i]=value++;
            }
            for(int i=counter+1;i<=(n-1)-counter;i++){
                matrix[i][n-1-counter]=value++;
            }
            for(int i=n-2-counter;i>=counter&&(i!=(n-1)-counter);i--){
                matrix[n-1-counter][i]=value++;
            }
            for(int i=n-counter-2;i>=counter+1&&(i!=n-1-counter);i--){
                matrix[i][counter]=value++;
            }
            counter++;
        }
        return matrix;
    }
}
