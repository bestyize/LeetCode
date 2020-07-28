package com.yize.tencent;

import com.yize.data.ListNode;
import org.junit.Test;

public class PalindromeList {
    @Test
    public void test(){
        ListNode head=ListNode.build(new int[]{1,2,3,3,2,1,0});
        System.out.println(isPalindromeList(head));
    }

    public boolean isPalindromeList(ListNode head){
        if(head==null||head.next==null){
            return true;
        }
        ListNode slow=head,quick=head;
        ListNode prev=null;

        while (quick!=null&&quick.next!=null){
            ListNode curr=slow;
            slow=slow.next;
            quick=quick.next.next;
            curr.next=prev;
            prev=curr;

        }
        if(quick!=null){
            slow=slow.next;
        }
        while (slow!=null){
            if(slow.val!=prev.val){
                return false;
            }
            slow=slow.next;
            prev=prev.next;
        }
        return true;

    }
}
