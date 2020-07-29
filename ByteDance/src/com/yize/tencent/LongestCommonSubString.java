package com.yize.tencent;

/**
 * 定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 *
 * 若这两个字符串没有公共子序列，则返回 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestCommonSubString {
    public int longestCommonSubString(String s1,String s2){
        char cs1[]=s1.toCharArray();
        char cs2[]=s2.toCharArray();
        int[][] dp=new int[s1.length()+1][s2.length()+1];
        for (int i=1;i<=cs1.length;i++){
            for (int j=1;j<cs2.length;j++){
                if(cs1[i-1]==cs2[j-1]){
                    //s1 and s2 match of same char
                    dp[i][j]=dp[i-1][j-1]+1;
                }else {
                    //decide s1 delete a char or s2 delete a char;
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[cs1.length][cs2.length];
    }
}
