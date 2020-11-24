package com.yize.tencent;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 单队列实现栈
 */
public class Mystack {
    private Queue<Integer> queue;
    public Mystack() {
        this.queue = new LinkedList<>();
    }
    public void push(int val){
        int size=queue.size();
        queue.offer(val);
        while (size>0){
            queue.offer(queue.poll());
            size--;
        }
    }

    public int pop(){
        return isEmpty()?-1:queue.poll();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public static void main(String[] args) {
//        Mystack stack=new Mystack();
        MyStackTwoQueue stack=new MyStackTwoQueue();
        for (int i=0;i<10;i++){
            System.out.print(i+"\t");
            stack.push(i);
        }
        System.out.println();
        while (!stack.isEmpty()){
            System.out.print(stack.pop()+"\t");
        }


    }

    /**
     * 双队列实现栈
     */
    static class MyStackTwoQueue{
        private Queue<Integer> in;
        private Queue<Integer> out;

        public MyStackTwoQueue() {
            in=new LinkedList<>();
            out=new LinkedList<>();
        }

        public void push(int val){
            int size=out.size();
            out.offer(val);
            while (size>0){
                in.offer(out.poll());
                size--;
            }
            while (!in.isEmpty()){
                out.offer(in.poll());
            }
        }

        public int pop(){
            return isEmpty()?-1:out.poll();
        }

        public boolean isEmpty(){
            return out.isEmpty();
        }

    }
}


