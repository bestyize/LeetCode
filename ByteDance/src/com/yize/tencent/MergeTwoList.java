package com.yize.tencent;

import com.yize.data.ListNode;

public class MergeTwoList {
    public ListNode mergeTwoList(ListNode h1,ListNode h2){
        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;
        while (h1!=null&&h2!=null){
            if(h1.val<=h2.val){
                curr.next=new ListNode(h1.val);
                h1=h1.next;
            }else {
                curr.next=new ListNode(h2.val);
                h2=h2.next;
            }
            curr=curr.next;

        }
        curr.next=h1!=null?h1:h2;
        return dummy.next;
    }
}
