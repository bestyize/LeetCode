package com.yize.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 *
 *
 * 上图是一个部分填充的有效的数独。
 *
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   ["5","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: true
 * 示例 2:
 *
 * 输入:
 * [
 *   ["8","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: false
 * 解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
 *      但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 * 说明:
 *
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 给定数独序列只包含数字 1-9 和字符 '.' 。
 * 给定数独永远是 9x9 形式的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-sudoku
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L36 {
    @Test
    public void test(){
        char cc[][]={{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(isValidSudoku(cc));
    }

    public boolean isValidSudoku(char[][] board) {
        return method1(board);
    }

    /**
     * 观察得到规律
     * 0->0,0
     * 1->3,0
     * 2->6,0
     *
     * 3->0,3
     * 4->3,3
     * 5->6,3
     *
     * 6->0,6
     * 7->3,6
     * 8->6,6
     * @param board
     * @return
     */
    public boolean method1(char[][] board) {
        if(board.length!=9||board[0].length!=9){
            return false;
        }
        Map<Character,Integer> xyMap[]=new HashMap[9];
        Map<Character,Integer> xMap[]=new HashMap[9];
        Map<Character,Integer> yMap[]=new HashMap[9];
        for (int i=0;i<9;i++){
            xyMap[i]=new HashMap<>();
            xMap[i]=new HashMap<>();
            yMap[i]=new HashMap<>();
        }
        for(int count=0;count<board[0].length;count++){
            //划分小格，获得小格的起始坐标
            int baseI=3*(count%3);
            int baseJ=3*(count/3);
            for(int i=baseI;i<baseI+3;i++){
                for(int j=baseJ;j<baseJ+3;j++){
                    if(xyMap[count].containsKey(board[i][j])){
                        return false;
                    }else if (xMap[i].containsKey(board[i][j])){
                        return false;
                    }else if(yMap[j].containsKey(board[i][j])){
                        return false;
                    }else if(board[i][j]!='.'){
                        xMap[i].put(board[i][j],1);
                        yMap[j].put(board[i][j],1);
                        xyMap[count].put(board[i][j],1);
                    }
                }
            }
        }
        return true;
    }

    /**
     * 先判断字符，再决定以后的操作
     * @param board
     * @return
     */
    public boolean method2(char[][] board) {
        if(board.length!=9||board[0].length!=9){
            return false;
        }
        Map<Character,Integer> xyMap[]=new HashMap[9];
        Map<Character,Integer> xMap[]=new HashMap[9];
        Map<Character,Integer> yMap[]=new HashMap[9];
        for (int i=0;i<9;i++){
            xyMap[i]=new HashMap<>();
            xMap[i]=new HashMap<>();
            yMap[i]=new HashMap<>();
        }
        for(int count=0;count<9;count++){
            //划分小格，获得小格的起始坐标
            int baseI=3*(count%3);
            int baseJ=3*(count/3);
            for(int i=baseI;i<baseI+3;i++){
                for(int j=baseJ;j<baseJ+3;j++){
                    char c=board[i][j];
                    if(c!='.'){
                        if(xyMap[count].containsKey(c)){
                            return false;
                        }else if (xMap[i].containsKey(c)){
                            return false;
                        }else if(yMap[j].containsKey(c)){
                            return false;
                        }else{
                            xMap[i].put(c,1);
                            yMap[j].put(c,1);
                            xyMap[count].put(c,1);
                        }
                    }

                }
            }
        }
        return true;
    }

}
