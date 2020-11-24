package com.yize.tencent;

import org.junit.Test;

/**
 * 复杂链表的复制
 */
public class ListCopy {
    private class ListNode {
        int val;
        ListNode next;
        ListNode random;

        public ListNode(int val) {
            this.val = val;
        }
    }
    @Test
    public void test(){
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(3);
        ListNode n4=new ListNode(4);
        ListNode n5=new ListNode(5);
        ListNode n6=new ListNode(6);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        n2.random=n4;
        n5.random=n2;
        ListNode copyList=listCopy(n1);
        System.out.println();
    }


    public ListNode listCopy(ListNode head){
        ListNode curr=head;
        while (curr!=null){
            ListNode dup=new ListNode(curr.val);
            dup.next=curr.next;
            curr.next=dup;
            curr=curr.next.next;
        }
        curr=head;
        while (curr!=null&&curr.next!=null){
            curr.next.random=curr.random==null?null:curr.random.next;
            curr=curr.next.next;
        }
        curr=head.next;
        ListNode newHead=curr;
        while (curr!=null&&curr.next!=null){
            curr.next=curr.next.next;
            curr=curr.next;
        }
        return newHead;
    }
}
