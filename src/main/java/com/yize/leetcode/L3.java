package com.yize.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3 {
    public static void main(String[] args) {
        int x=new L3().method3("abcabcbb");
        System.out.println(x);
    }

    /**
     * 使用滑动窗口实现
     * @param s
     * @return
     */
    public  int method2(String s) {
        int n = s.length();
        int maxLen=0;
        int startIndex=0;
        //创建map窗口,startIndex为左区间，i为右区间，右边界移动
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < n; i++) {
            // 如果窗口中包含当前字符，
            if (map.containsKey(s.charAt(i))) {
                //左边界移动到 相同字符的下一个位置和startIndex当前位置中更靠右的位置，这样是为了防止startIndex向左移动
                startIndex = Math.max(map.get(s.charAt(i)), startIndex);
            }
            //比对当前无重复字段长度和储存的长度，选最大值并替换
            //i-startIndex+1是因为此时startIndex,j索引仍处于不重复的位置，j还没有向后移动，取的[startIndex,j]长度
            maxLen = Math.max(maxLen, i - startIndex + 1);
            // 将当前字符为key，下一个索引为value放入map中
            // value为i+1是为了当出现重复字符时，startIndex直接跳到上个相同字符的下一个位置，if中取值就不用+1了
            map.put(s.charAt(i), i+1);
        }
        return maxLen;
    }


    /**
     * 使用hashmap
     * @param s
     * @return
     */
    public int method1(String s) {
        Map<Character,Integer> map=new HashMap<Character, Integer>();
        int len=0;
        int maxLen=0;
        for(int i=0;i<s.length();i++){
            char cc=s.charAt(i);
            if(!map.containsKey(cc)){
                map.put(cc,i);//存储字符与出现的位置
                len++;
            }else{
                if(len>maxLen){
                    maxLen=len;
                }
                i=map.get(cc);//退回到重复字符的后一个位置,因为for循环完成后自动加一，所以这里就不用再加1退后一个位置
                map.clear();
                len=0;
            }
        }
        if(len>maxLen){
            maxLen=len;
        }

        return maxLen;
    }

    /**
     * 使用hashmap
     * @param s
     * @return
     */
    public int method3(String s) {
        Map<Character,Integer> map=new HashMap<Character, Integer>();
        int len=0;
        int maxLen=0;
        for(int i=0;i<s.length();i++){
            char cc=s.charAt(i);
            if(!map.containsKey(cc)){
                map.put(cc,i);//存储字符与出现的位置
                len++;
            }else{
                if(len>maxLen){
                    maxLen=len;
                }


                int newStart=map.get(cc);//退回到重复字符的后一个位置,因为for循环完成后自动加一，所以这里就不用再加1退后一个位置
                map.put(cc,i);
                i=newStart;
                len=0;
            }
        }
        if(len>maxLen){
            maxLen=len;
        }

        return maxLen;
    }

}
