package com.yize.leetcode;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class L88 {
    @Test
    public void test(){
        int[] nums1={0,0,0};
        int[] nums2={1};

        method1(nums1,0,nums2,1);
    }

    /**
     * 执行结果：
     * 通过
     * 显示详情
     * 执行用时 :
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗 :
     * 36.2 MB
     * , 在所有 Java 提交中击败了
     * 40.96%
     * 的用户
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void method1(int[] nums1, int m, int[] nums2, int n) {
        int ptr1=m-1,ptr2=n-1,newPtr=m+n-1;
        while (ptr1>=0||ptr2>=0){
            if(ptr1>=0&&ptr2>=0){
                nums1[newPtr--]=nums1[ptr1]>nums2[ptr2]?nums1[ptr1--]:nums2[ptr2--];
            }else {
                while (ptr1>=0){
                    nums1[newPtr--]=nums1[ptr1--];
                }
                while (ptr2>=0){
                    nums1[newPtr--]=nums2[ptr2--];
                }
            }

        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        Queue<Integer> queue1=new LinkedList<>();
        Queue<Integer> queue2=new LinkedList<>();
        for(int i=0;i<m;i++){
            queue1.offer(nums1[i]);
        }
        for(int i=0;i<n;i++){
            queue2.offer(nums2[i]);
        }
        int ptr=0;
        while (queue1.isEmpty()==false||queue2.isEmpty()==false){
            if(queue1.isEmpty()==false&&queue2.isEmpty()==false){
                int val=queue1.peek()<queue2.peek()?queue1.poll():queue2.poll();
                nums1[ptr++]=val;
            }else {
                while (queue1.isEmpty()==false){
                    nums1[ptr++]=queue1.poll();
                }
                while (queue2.isEmpty()==false){
                    nums1[ptr++]=queue2.poll();
                }
            }

        }
    }
}
