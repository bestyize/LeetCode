package com.yize.bytedance;

import com.yize.data.ListNode;
import org.junit.Test;

public class InverseList {
    /**
     * 非递归方式反转链表
     * @param head
     * @return
     */
    public ListNode reverseListNode(ListNode head){
        ListNode curr=head;
        ListNode prev=null;
        while (curr!=null){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }

    /**
     * 递归法翻转链表
     * @param head
     * @return
     */
    public ListNode reverseNode(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode newhead=reverseNode(head.next);
        head.next.next=head;
        head.next=null;
        return newhead;
    }
    @Test
    public void test(){
        ListNode head=ListNode.build(new int[]{1,2,3,4,5});
        head.print();
        reverseNode(head).print();
    }
}
