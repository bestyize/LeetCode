package com.yize.tencent;

import java.util.Stack;

/**
 * 两个栈实现队列
 */
public class MyQueue {
    private Stack<Integer> in;
    private Stack<Integer> out;

    public MyQueue() {
        in=new Stack<>();
        out=new Stack<>();
    }
    public void offer(int val){
        in.push(val);
    }

    public int poll(){
        if(out.isEmpty()){
            while (!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.isEmpty()?-1:out.pop();
    }

    public boolean isEmpty(){
        return in.isEmpty()&&out.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue queue=new MyQueue();
        for (int i=0;i<10;i++){
            System.out.print(i+"\t");
            queue.offer(i);
        }
        System.out.println();
        while (!queue.isEmpty()){
            System.out.print(queue.poll()+"\t");
        }

    }
}
