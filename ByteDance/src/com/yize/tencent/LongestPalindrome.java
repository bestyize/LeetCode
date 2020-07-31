package com.yize.tencent;

/**
 * 最长回文子串
 */
public class LongestPalindrome {
    public String longestPalindrome(String str){
        int maxLen=0,maxStart=0;
        char cs[]=str.toCharArray();
        boolean[][] dp=new boolean[cs.length][cs.length];
        for (int i=0;i<cs.length;i++){
            for (int j=i;j>=0;j--){
                if(i-j<=2){
                    dp[j][i]=cs[i]==cs[j];
                }else {
                    dp[j][i]=(cs[i]==cs[j])&&dp[j+1][i-1];
                }
                if(dp[j][i]==true){
                    if(j-i>maxLen){
                        maxLen=j-i;
                        maxStart=j;
                    }
                }
            }
        }
        return String.copyValueOf(cs,maxStart,maxLen);
    }
}
