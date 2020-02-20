package com.yize.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 *
 * 输入:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L54 {
    @Test
    public void test(){
        int a[][]={{1},{2},{3}};
        System.out.println(spiralOrder(a));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list=new ArrayList<>();
        if(matrix.length==0){
            return list;
        }
        int m=matrix.length;
        int n=matrix[0].length;
        int count=(Math.min(m,n)+1)>>1;
        int counter=0;
        while (counter<count){
            //从左到右
            for(int i=counter;i<n-counter;i++){
                list.add(matrix[counter][i]);
            }
            //从上到下
            for(int i=counter+1;i<m-counter;i++){
                list.add(matrix[i][n-1-counter]);
            }
            //从右到左，确保和从左到右不打印同一行
            for(int i=n-1-counter-1;i>=counter&&(m-1-counter!=counter);i--){
                list.add(matrix[m-1-counter][i]);
            }
            //从下到上，确保从下到上不打印同一行
            for(int i=m-1-counter-1;i>counter&&(n-1-counter!=counter);i--){
                list.add(matrix[i][counter]);
            }
            counter++;
        }
        return list;
    }

}
