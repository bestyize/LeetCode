package com.yize.leetcode;

import java.util.*;

/**
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 *
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L217 {
    public boolean method1(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i:nums){
            map.put(i,1);
        }
        return map.size()!=nums.length;
    }

    public boolean method2(int[] nums){
        Map<Integer,Integer> map=new HashMap<>();
        for (int i:nums){
            if(map.containsKey(i)){
                return true;
            }
            map.put(i,1);
        }
        return false;
    }

    public boolean method3(int[] nums) {
        Set<Integer> Hashset = new HashSet<>();
        for(Integer i:nums){
            if(Hashset.contains(i)) return true;
            Hashset.add(i);
        }
        return false;
    }

    public boolean method4(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(Integer i:nums){
            //if(Hashset.contains(i)) return true;
            set.add(i);
        }
        return set.size()==nums.length;
    }

    public boolean method5(int[] nums){
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]){
                return true;
            }
        }
        return false;
    }
}
