package com.yize.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L169 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length>>1];
    }

    public int method3(int[] nums){
        int count=1;
        int number=nums[0];
        for (int i=1;i<nums.length;i++){
            if(number==nums[i]){
                count++;
            }else {
                count--;
            }
            if(count==0){
                number=nums[i+1];
            }
        }
        return number;
    }

    public int method2(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i:nums){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
                if(map.get(i)>=nums.length>>1){
                    return i;
                }
            }else {
                map.put(i,1);
            }
        }
        return -1;
    }

}
