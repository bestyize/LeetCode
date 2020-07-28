package com.yize.tencent;

import org.junit.Test;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class JumpFloor {
    @Test
    public void test(){
        System.out.println(jumpFloor(4));
    }
    public int jumpFloor(int target) {
        if(target<3){
            return target;
        }
        int prev=2;
        int prevPrev=1;
        for (int i=3;i<=target;i++){
            int temp=prev;
            prev+=prevPrev;
            prevPrev=temp;
        }
        return prev;
    }
}
