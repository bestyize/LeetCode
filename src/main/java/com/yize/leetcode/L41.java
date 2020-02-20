package com.yize.leetcode;

import org.junit.Test;

import java.util.HashMap;

/**
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 *
 * 示例 1:
 *
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 *
 * 输入: [7,8,9,11,12]
 * 输出: 1
 * 说明:
 *
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-missing-positive
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L41 {

    @Test
    public void test(){
        int[] nums={2,1,3};
        System.out.println(firstMissingPositive(nums));
    }

    public int firstMissingPositive(int[] nums) {
        return method2(nums);
    }

    /**
     * 时空复杂度都为N，不合题意
     * @param nums
     * @return
     */
    public int method1(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:nums){
            map.put(i,1);
        }
        int count=1;
        while (true){
            if(!map.containsKey(count)){
               break;
            }
            count++;
        }
        return count;
    }

    /**
     * 我们使用一种 “座位交换法" 来达到 in-place 的目的：
     *
     * 从第一个位置开始，让座位上的乘客走到自己应该坐的位置，并让该位置的人坐到第一个位置。一直进行这样的操作，直到第一个位置的人坐到自己位置。不过有时候我们知道，有的人总喜欢逃票。因此终止条件就是，一旦发现第一个位置的人逃票（票号 <= 0，或 >= 最大座位号)，则终止交换。
     * 对第二到N个位置做相同的操作。
     * 时间复杂度N,空间复杂度1
     * @param nums
     * @return
     */
    public int method2(int nums[]){
        if(nums.length==0){
            return 1;
        }
        for(int i=0;i<nums.length;i++){
            while (nums[i]>=1&&nums[i]<=nums.length&&nums[i]!=(i+1)&&nums[i]!=nums[nums[i]-1]){
                int temp=nums[i];
                nums[i]=nums[nums[i]-1];
                nums[temp-1]=temp;
            }
        }
        int i=0;
        for(i=0;i<nums.length;i++){
            if(nums[i]!=i+1){
                return i+1;
            }
        }

        return i+1;
    }
}
