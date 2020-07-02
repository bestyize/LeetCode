package com.yize.bytedance;

import com.yize.data.ListNode;

public class DetectListHasCircle {
    /**
     * 检测链表有没有环，原理，有环的话快的会把慢的套圈，没环的话会走到null
     * @param head
     * @return
     */
    public boolean detectListHasCircle(ListNode head){
        if(head==null||head.next==null){
            return false;
        }
        ListNode slow=head;
        ListNode quick=head;
        while (quick!=null&&quick.next!=null){
            if(slow==quick){
                return true;
            }
            slow=slow.next;
            quick=quick.next.next;
        }
        return false;
    }
}
