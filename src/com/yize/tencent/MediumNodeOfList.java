package com.yize.tencent;

import com.yize.data.ListNode;

public class MediumNodeOfList {
    public ListNode mediumNodeOfList(ListNode head){
        if(head==null||head.next==null){
            return null;
        }
        ListNode slow=head,quick=head;
        while (quick!=null&&quick.next!=null){
            slow=slow.next;
            quick=quick.next.next;
        }
        return slow;
    }
}
