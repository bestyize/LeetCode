package com.yize.leetcode;

/**
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
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
public class MinCoverString {
    public String minWindow(String s, String t) {
        int[] map=new int[128];
        int[] tempMap=new int[128];
        char[] cs=s.toCharArray();
        char[] ts=t.toCharArray();
        for (char c:ts){
            map[c]++;
        }
        int left=0,right=0;
        int matchCount=0;
        int start=0;
        int minLen=Integer.MAX_VALUE;
        while (right<cs.length){
            char c=cs[right];
            if(map[c]>0){
                tempMap[c]++;
                if(map[c]==tempMap[c]){
                    matchCount++;
                }
            }
            right++;
            while (matchCount==ts.length){
                if(right-left<minLen){
                    start=left;
                    minLen=right-left;
                }
                char cc=cs[left];
                if(map[cc]>0){
                    tempMap[cc]--;
                    if(tempMap[cc]<map[cc]){
                        matchCount--;
                    }
                }
                left++;
            }
        }
        return minLen==Integer.MAX_VALUE?"":s.substring(start,start+minLen);
    }
}
