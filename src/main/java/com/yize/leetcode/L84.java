package com.yize.leetcode;

import org.junit.Test;

public class L84 {
    @Test
    public void test(){
        System.out.println(largestRectangleArea(new int[]{2,1,2}));
    }

    public int largestRectangleArea(int[] heights) {
        if(heights.length==0){
            return 0;
        }
        int leftMin[]=new int[heights.length];
        leftMin[0]=-1;
        //这里的算法复杂度是N，因为当前的前一个柱子比当前柱子高，
        // 所以第一个比前一个柱子低的柱子到前一个柱子之间都是比当前柱子高的，所以直接跳过去了
        for(int i=1;i<heights.length;i++){
            int prev=i-1;
            while (prev>=0&&heights[prev]>=heights[i]){
                prev=leftMin[prev];
            }
            leftMin[i]=prev;
        }
        //下面的算法复杂度是N2
//        for(int i=1;i<heights.length;i++){
//            int prev=i-1;
//            while (prev>=0&&heights[prev]>=heights[i]){
//                prev--;
//            }
//            leftMin[i]=prev;
//        }

        int rightMin[]=new int[heights.length];
        rightMin[heights.length-1]=heights.length;
        for(int i=heights.length-2;i>=0;i--){
            int next=i+1;
            while (next<heights.length&&heights[next]>=heights[i]){
                next=rightMin[next];
            }
            rightMin[i]=next;
        }
        int maxArea=0;
        for(int i=0;i<heights.length;i++){
            int area=(rightMin[i]-leftMin[i]-1)*heights[i];
            if(area>maxArea){
                maxArea=area;
            }
        }
        return maxArea;
    }
}
