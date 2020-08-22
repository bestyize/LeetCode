package com.yize.leetcode;

import com.yize.data.ListNode;

/**
 * 2. 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class AddTwoNumber {
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
           curr=curr.next;
           addin=val/10;
        }
        if(addin!=0){
            curr.next=new ListNode(addin);
        }
        return dummy.next;
    }
}
