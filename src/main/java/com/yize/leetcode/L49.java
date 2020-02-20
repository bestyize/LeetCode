package com.yize.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L49 {
    @Test
    public void test(){
        String strs[]={"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists=groupAnagrams(strs);
        System.out.println(lists);
    }
    public List<List<String>> groupAnagrams(String[] strs) {

        if(strs.length==0){
            return new ArrayList<>();
        }
        Map<String,List> map=new HashMap<>();
        for (String s:strs){
            char[] ca=s.toCharArray();
            Arrays.sort(ca);
            String key=String.valueOf(ca);
            if(!map.containsKey(key)){
                map.put(key,new ArrayList());
            }
            map.get(key).add(s);
        }
        return new ArrayList(map.values());
    }
}
