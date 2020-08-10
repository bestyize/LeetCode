package com.yize.nowcoder;

import com.yize.data.ListNode;
import org.junit.Test;

import java.util.Stack;

public class PrintListFromTail {


    @Test
    public void test(){
        printListFromTail(ListNode.build(new int[]{1,2,3,4,5}));
    }

    /**
     * 递归法逆序打印链表
     * @param head
     */
    public void printListNodeFromTail(ListNode head){
        if(head!=null){
            printListNodeFromTail(head.next);
            System.out.println(head.val);
            return;
        }

    }

    /**
     * 用栈打印链表
     * @param head
     */
    public void printListFromTail(ListNode head){
        if(head==null){
            return;
        }
        Stack<Integer> stack=new Stack<>();
        while (head!=null){
            stack.push(head.val);
            head=head.next;
        }
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }


}
