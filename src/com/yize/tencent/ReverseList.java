package com.yize.tencent;

import com.yize.data.ListNode;

import java.util.List;

public class ReverseList {
    public ListNode reverseList(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode newHead=reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return newHead;
    }

    public ListNode reverseList1(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        while (curr!=null){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
}
