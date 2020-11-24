package com.yize.tencent;

import com.yize.data.ListNode;

/**
 * 倒数第X个节点
 */
public class LastXNode {
    public ListNode lastXNodeOfList(ListNode head,int x){
        ListNode quick=head;
        ListNode slow=head;
        while (x>0&&quick!=null){
            quick=quick.next;
        }
        if(x>0&&quick==null){
            return null;
        }
        while (quick!=null){
            quick=quick.next;
            slow=slow.next;
        }
        return slow;
    }
}
