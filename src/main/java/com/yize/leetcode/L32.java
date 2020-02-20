package com.yize.leetcode;

import org.junit.Test;

import java.util.Stack;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 *
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 *
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L32 {
    @Test
    public void test(){
        System.out.println(longestValidParentheses(")"));
    }

    public int longestValidParentheses(String s) {
        return method1(s);
    }
    public int method1(String s) {
        if(s==null||s.length()<2){
            return 0;
        }
        int maxLen=0;
        Stack<Integer> stack=new Stack<>();
        stack.push(-1);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            }else {
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else {
                    maxLen= Math.max(maxLen,i-stack.peek());
                }
            }
        }
        return maxLen;
    }
}
