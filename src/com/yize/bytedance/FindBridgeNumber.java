package com.yize.bytedance;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 寻找k：在无序数组中，k的所有左值比它更小，所有右值比他更大。限定o（n）。
 */
public class FindBridgeNumber {
    @Test
    public void test(){
        int[] nums={2,1,2,3,4,4};
        List<Integer> result=findBridgeNumber(nums);
        System.out.println(result);
    }

    public List<Integer> findBridgeNumber(int[] nums){
        List<Integer> result=new ArrayList<>();
        if(nums.length<=2){
            return result;
        }
        int[] dpLeft=new int[nums.length];
        dpLeft[0]=Integer.MIN_VALUE;
        dpLeft[1]=nums[0];
        for (int i=2;i<dpLeft.length;i++){
            dpLeft[i]=Math.max(nums[i-1],dpLeft[i-1]);
        }

        int[] dpRight=new int[nums.length];
        dpRight[dpRight.length-1]=Integer.MAX_VALUE;
        dpRight[dpRight.length-2]=nums[nums.length-1];

        for (int i=dpRight.length-3;i>=0;i--){
            dpRight[i]=Math.min(nums[i+1],dpRight[i+1]);
        }
        for (int i=0;i<nums.length;i++){
            if(dpLeft[i]<nums[i]&&dpRight[i]>nums[i]){
                result.add(nums[i]);
            }
        }
        return result;
    }
}
