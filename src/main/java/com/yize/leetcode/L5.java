package com.yize.leetcode;

import org.junit.Test;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L5 {
    @Test
    public void test(){
        String s=new String("aaaa");
        String str=method3(s);
        System.out.println(str);
        //System.out.println(isPalindrome("abab",0,3));
    }
    /*************************
     * 求解字符串中的最长回文串-----动态规划法O(n^2)
     * 实现思路:用一个boolean类型的二维数组isPlalindrome[i][j] 来表示i到j之间的字符串是否回文
     * 其中 i>=j
     * 动态规划的初值就是  当i=j时，isPlalindrome[i][j]=true;
     * 动态规划的推导公式为  当i=j+1时，isPlalindrome[i][j]=(oriArray[i]==oriArray[j]),相邻两元素是否相等
     * 					当i>j+1时，需要判断i与j之间的子串是否是回文串,即
     * 							isPlalindrome[i][j]=(oriArray[i]==oriArray[j])&&isPlalindrome[i+1][j-1]
     * PS:状态矩阵赋值过程必须使用左下三角的形式  否则会产生误判 使用了未赋值的位置
     * @param str 要求解的字符串
     * @return 返回字符串中的最长回文串
     */

    public String method2(String str){
        if((str==null)||str.length()==0){
            return "";
        }
        char[] sc=str.toCharArray();
        int low=0,high=0;
        boolean[][] isPlalindrome=new boolean[sc.length][sc.length];
        for(int i=0;i<sc.length;i++){
            for(int j=0;j<=i;j++){
                if(i==j){//同一个元素
                    isPlalindrome[i][j]=true;
                }else if(i-j==1){
                    //相邻元素
                    isPlalindrome[i][j]=(sc[i]==sc[j]);
                }else {
                    //不相邻元素
                    isPlalindrome[i][j]=(sc[i]==sc[j])&&isPlalindrome[i-1][j+1];
                }
                //更新
                if(isPlalindrome[i][j]&&(i-j)>(high-low)){
                    low=j;
                    high=i;
                }
            }
        }
        return str.substring(low,high+1);
    }

    /**
     * 动态规划，优化版
     * @param s
     * @return
     */
    public String method3(String s){
        if(s==null||s.equals("")){
            return "";
        }
        int low=0;
        int high=0;
        boolean isMirror[][]=new boolean[s.length()][s.length()];//定义状态，如果是true就是联通的
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if(j-i<3){//i==j，j-i==1，j-i==2,中间夹着一个的情况
                    isMirror[i][j]=(s.charAt(i)==s.charAt(j));
                }else {
                    isMirror[i][j]=isMirror[i+1][j-1]&&(s.charAt(i)==s.charAt(j));
                }
                if(isMirror[i][j]&&(j-i)>(high-low)){
                    high=j;
                    low=i;
                }
            }
        }
        return s.substring(low,high+1);

    }




    /**
     * 最长回文字符串暴力计算，复杂度O(n^3)
     * @param s
     * @return
     */
    public String method1(String s) {
        int maxLen=0;
        String maxL="";
        for(int i=0;i<s.length()-1;i++){
            for(int j=i;j<s.length();j++){
                if(isPalindrome(s,i,j)){
                    if(maxLen<j-i){
                        maxLen=j-i;
                        maxL=s.substring(i,j+1);
                    }
                }
            }
        }
        return maxL;
    }

    /**
     * 判断是否为回文字符串
     * @param s
     * @param low
     * @param high
     * @return
     */
    public boolean isPalindrome(String s,int low,int high){
        while (low<high){
            if(s.charAt(low++)!=s.charAt(high--)){
                return false;
            }
        }
        return true;
    }
}
