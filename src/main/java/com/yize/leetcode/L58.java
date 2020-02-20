package com.yize.leetcode;

/**
 * 执行结果：
 * 通过
 * 显示详情
 * 执行用时 :
 * 0 ms
 * , 在所有 Java 提交中击败了
 * 100.00%
 * 的用户
 * 内存消耗 :
 * 35.7 MB
 * , 在所有 Java 提交中击败了
 * 88.94%
 * 的用户
 * 炫耀一下:
 */
public class L58 {
    public int lengthOfLastWord(String s) {
        if(s==null||s.length()==0){
            return 0;
        }
        int ptr=s.length()-1;
        int lastAlpha=s.length()-1;
        while(ptr>=0&&s.charAt(ptr)==' '){
            ptr--;
            lastAlpha=ptr;
        }
        while(ptr>=0&&s.charAt(ptr)!=' '){
            ptr--;
        }
        return lastAlpha-ptr;
    }
}
