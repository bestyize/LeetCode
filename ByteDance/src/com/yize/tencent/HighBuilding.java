package com.yize.tencent;

import java.util.Stack;

/**
 * 摩天大楼问题：
 * https://blog.csdn.net/qq_23594799/article/details/105084966
 *
 * 小Q在周末的时候和他的小伙伴来到大城市逛街，一条步行街上有很多高楼，共有n座高楼排成一行。
 * 小Q从第一栋一直走到了最后一栋，小Q从来没有看到过这么多高楼，所以他想知道他在每栋楼的位置处能看到多少栋楼呢？（当前面的楼的高度大于等于后面的楼时，后面的楼将被挡住）
 */
public class HighBuilding {
    public int[] maxToSee(int[] heights){
        int len= heights.length;
        int left[]=new int[len];
        Stack<Integer> leftStack=new Stack<>();

        for (int i=0;i<len;i++){
            left[i]=leftStack.size();
            if(leftStack.isEmpty()||heights[i]<leftStack.peek()){
                leftStack.push(heights[i]);
            }else {
                while (leftStack.size()>0&&heights[i]>=leftStack.peek()){
                    leftStack.pop();
                }
                leftStack.push(heights[i]);
            }
        }

        int right[]=new int[len];
        Stack<Integer> rightStack=new Stack<>();
        for (int i=len-1;i>=0;i--){
            right[i]=rightStack.size();
            if(rightStack.isEmpty()||heights[i]<rightStack.peek()){
                rightStack.push(heights[i]);
            }else {
                while (rightStack.size()>0&&heights[i]>=rightStack.peek()){
                    rightStack.pop();
                }
                rightStack.push(heights[i]);
            }
        }
        int[] result=new int[len];
        for (int i=0;i<len;i++){
            result[i]=left[i]+right[i]+;
        }
        return result;
    }
}
