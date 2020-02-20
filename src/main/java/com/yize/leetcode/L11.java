package com.yize.leetcode;

import org.junit.Test;

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L11 {
    @Test
    public void test(){
        int height[]={1,8,6,2,5,4,8,3,7};
        int area=maxArea(height);
        System.out.println(area);
    }

    public int maxArea(int[] height) {
        return method2(height);
    }

    /**
     * 暴力解法,穷举所有可能，时间复杂度O(N^2)
     * @param height
     * @return
     */
    public int method1(int[] height) {
        if(height.length<=1){
            return 0;
        }
        int maxArea=0;
        for(int i=0;i<height.length;i++){
            for(int j=i+1;j<height.length;j++){
                int area=(j-i)*(height[j]>height[i]?height[i]:height[j]);
                if(area>maxArea){
                    maxArea=area;
                }
            }
        }
        return maxArea;
    }

    /**
     * 双指针，从两边指向中间，时间复杂度O(N),空间复杂度O(1)
     * @param height
     * @return
     */
    public int method2(int[] height){
        if(height.length<=1){
            return 0;
        }
        int maxArea=0;
        int low=0,high=height.length-1;
        while (low<high){
            int area=0;
            if(height[high]>=height[low]){
                area=(high-low)*(height[low]);
                low++;
            }else {
                area=(high-low)*(height[high]);
                high--;
            }
            if(area>maxArea){
                maxArea=area;
            }
        }
        return maxArea;
    }
}
