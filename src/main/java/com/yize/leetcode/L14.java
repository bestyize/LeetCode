package com.yize.leetcode;

import org.junit.Test;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L14 {
    @Test
    public void test(){
        String strs[]={"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
    public String longestCommonPrefix(String[] strs) {
        return method1(strs);
    }

    /**
     * 时间复杂度O(N),虽然有两个for
     * @param strs
     * @return
     */
    public String method1(String[] strs) {
        if(strs.length==0){
            return "";
        }
        if(strs.length==1){
            return strs[0];
        }
        char firstPairStr[]=strs[0].toCharArray();
        int ptr=0;
        for(int i=0;i<firstPairStr.length;i++){
            for(int j=1;j<strs.length;j++){
                if(i<strs[j].length()&&(strs[j].charAt(i)==firstPairStr[i])){
                }else {
                    return strs[0].substring(0,ptr);
                }

            }
            ptr++;
        }
        return strs[0].substring(0,ptr);
    }

    public String method2(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        String str = strs[0];
        for(int i = 1; i < strs.length; i++){
            while(strs[i].indexOf(str) != 0){
                str=str.substring(0, str.length() - 1);
            }
        }
        return str;
    }
}
