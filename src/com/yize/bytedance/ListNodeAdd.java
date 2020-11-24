package com.yize.bytedance;

import com.yize.data.ListNode;

/**
 *
 * https://leetcode-cn.com/problems/sum-lists-lcci/
 *
 * 给定两个用链表表示的整数，每个节点包含一个数位。
 *
 * 这些数位是反向存放的，也就是个位排在链表首部。
 *
 * 编写函数对这两个整数求和，并用链表形式返回结果。
 */
public class ListNodeAdd {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;
        int addin=0;
        while (l1!=null||l2!=null){
            int val=addin;
            if(l1!=null){
                val+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                val+=l2.val;
                l2=l2.next;
            }
            curr.next=new ListNode(val%10);
            addin=val/10;
            curr=curr.next;
        }
        if(addin!=0){
            curr.next=new ListNode(addin);
        }
        return dummy.next;
    }
}
