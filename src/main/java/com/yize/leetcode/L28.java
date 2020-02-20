package com.yize.leetcode;

import org.junit.Test;

/**
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L28 {
    @Test
    public void test(){
        String a="mississippi";
        String p="issipi";
        System.out.println(strStr(a,p));
    }


    public int strStr(String haystack, String needle) {
        return method1(haystack,needle);
    }

    /**
     * 测试通过了74个测试用例，但是超时了
     * @param str
     * @param pattern
     * @return
     */
    public int method1(String str, String pattern) {
        if(str==null||pattern==null||pattern.length()>str.length()){
            return -1;
        }
        if(pattern.length()==0){
            return 0;
        }
        char c=pattern.charAt(0);
        //使用注释的这一句就会超时
        //for(int i=0;i<str.length();i++){
        for(int i=0;i<str.length()-pattern.length()+1;i++){
            if(str.charAt(i)==c){
                if(isMatch(str,pattern,i,0)){
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean isMatch(String str,String pattern,int strIndex,int patternIndex){
        if(patternIndex==pattern.length()){
            return true;
        }

        if(strIndex<str.length()&&patternIndex<pattern.length()&&(str.charAt(strIndex)==pattern.charAt(patternIndex))){
            return isMatch(str,pattern,strIndex+1,patternIndex+1);
        }else {
            return false;
        }
    }
}
