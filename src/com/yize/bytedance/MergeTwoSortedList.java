package com.yize.bytedance;

import com.yize.data.ListNode;
import org.junit.Test;

public class MergeTwoSortedList {
    @Test
    public void test(){
        ListNode head1=ListNode.build(new int[]{1,2,5,6,7});
        ListNode head2=ListNode.build(new int[]{1,3,4,7});
        ListNode head=mergeSortedList(head1,head2);
        head.print();
    }

    /**
     * 合并两个排序链表，不用创建新节点
     * @param node1
     * @param node2
     * @return
     */
    public ListNode mergeSortedList(ListNode node1,ListNode node2){
        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;
        while (node1!=null&&node2!=null){
            if(node1.val<=node2.val){
                curr.next=node1;
                curr=curr.next;
                node1=node1.next;
            }else {
                curr.next=node2;
                curr=curr.next;
                node2=node2.next;
            }
        }
        curr.next=node1==null?node2:node1;
        return dummy.next;
    }
}
