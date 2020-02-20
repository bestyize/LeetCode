package com.yize.leetcode;

import com.yize.datastructure.ListNode;
import org.junit.Test;

/**
 * 148. 排序链表
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 *
 * 示例 1:
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 */
public class L148 {
    @Test
    public void test(){
        ListNode node=ListNode.buildListNode(new int[]{4,5,2,7});
        sortList(node).print();

    }

    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode quick=head;
        ListNode slow=head;
        ListNode midNode=null;
        while (quick!=null&&quick.next!=null){
            midNode=slow;
            slow=slow.next;
            quick=quick.next.next;
        }
        midNode.next=null;
        ListNode leftHead=mergeSort(head);
        ListNode rightHead=mergeSort(slow);
        return merge(leftHead,rightHead);
    }

    private ListNode merge(ListNode leftHead, ListNode rightHead) {
        ListNode dummy=new ListNode(-1);
        ListNode currNode=dummy;
        while (leftHead!=null&&rightHead!=null){
            if(leftHead.val<=rightHead.val){
                currNode.next=leftHead;
                currNode=currNode.next;
                leftHead=leftHead.next;
            }else {
                currNode.next=rightHead;
                currNode=currNode.next;
                rightHead=rightHead.next;
            }
        }
        currNode.next=leftHead==null?rightHead:leftHead;
        return dummy.next;
    }

}
