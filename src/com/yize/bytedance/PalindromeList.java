package com.yize.bytedance;

import com.yize.data.ListNode;

public class PalindromeList {
    /**
     * 方法一，一边找中点一边反转链表前半部分
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null){
            return true;
        }
        ListNode slow=head,quick=head;
        ListNode prev=null,curr=slow;
        while (quick!=null&&quick.next!=null){
            ListNode temp=slow.next;
            slow=slow.next;
            quick=quick.next.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        if(quick!=null){//奇数个元素，需要向后移动一位
            slow=slow.next;
        }
        ListNode front=prev;
        ListNode below=slow;
        while (front!=null){
            if(front.val!=below.val){
                return false;
            }
            front=front.next;
            below=below.next;
        }
        return true;
    }


}
