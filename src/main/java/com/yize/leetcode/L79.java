package com.yize.leetcode;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L79 {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++) {
                if(backTrack(board,i,j,word,0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backTrack(char[][] board,int x,int y,String word,int currLen){
        if(currLen==word.length()){
            return true;
        }
        if(x<0||x>=board.length||y<0||y>=board[0].length||board[x][y]!=word.charAt(currLen)){
            return false;
        }
        char c=board[x][y];
        board[x][y]='*';
        boolean flag=backTrack(board,x+1,y,word,currLen+1)||backTrack(board,x,y+1,word,currLen+1)
                ||backTrack(board,x-1,y,word,currLen+1)||backTrack(board,x,y-1,word,currLen+1);
        board[x][y]=c;
        return flag;

    }
}
