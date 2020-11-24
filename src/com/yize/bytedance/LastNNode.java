package com.yize.bytedance;

import com.yize.data.ListNode;
import org.junit.Test;

public class LastNNode {
    @Test
    public void test(){
        System.out.println(kthToLast(ListNode.build(new int[]{1,2,3,4,5}),2));
    }

    public int kthToLast(ListNode head, int k) {
        return lastNNode(head,k);
    }
    public int lastNNode(ListNode head,int n){
        if(head==null){
            return -1;
        }
        ListNode slow=head;
        ListNode quick=head;
        while (n>0&&quick!=null){
            n--;
            quick=quick.next;
        }
        if(n< 0){
            return -1;
        }
        while (quick!=null){
            quick=quick.next;
            slow=slow.next;
        }
        return slow.val;
    }
}
