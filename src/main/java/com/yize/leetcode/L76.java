package com.yize.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 *
 * 示例：
 *
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 *
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L76 {

    @Test
    public void test(){
        String s="a";
        String t="a";
        System.out.println(minWindow(s,t));
    }
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap();
        Map<Character, Integer> tempMap = new HashMap();
        for (int i = t.length() - 1; i >= 0; i--) {
            if (map.containsKey(t.charAt(i))) {
                map.put(t.charAt(i), map.get(t.charAt(i)) + 1);
            } else {
                map.put(t.charAt(i), 1);
            }
        }

        int left=0,right=0;
        int matchCount=0;
        int start=0;
        int minLen=s.length()+1;
        while (right<s.length()){
            char c=s.charAt(right);
            if(map.containsKey(c)){
                if(tempMap.containsKey(c)){
                    tempMap.put(c,tempMap.get(c)+1);
                }else {
                    tempMap.put(c,1);
                }
                if(map.get(c)==(int)tempMap.get(c)){
                    matchCount++;
                }
            }
            right++;
            while (matchCount==map.size()){
                if(right-left<minLen){
                    start=left;
                    minLen=right-left;
                    //add
                }
                char cc=s.charAt(left);
                if(map.containsKey(cc)){
                    tempMap.put(cc,tempMap.get(cc)-1);
                    if(tempMap.get(cc)<(int)map.get(cc)){
                        matchCount--;
                    }
                }
                left++;
            }

        }
        return minLen==s.length()+1?"":s.substring(start,start+minLen);
    }
}
