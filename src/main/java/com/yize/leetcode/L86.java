package com.yize.leetcode;

import com.yize.datastructure.ListNode;

/**
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 * 示例:
 *
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L86 {
    //建立两个链表，第一个链表作为小于目标值的链表
    //第二个链表作为大于等于目标值的链表
    public ListNode partition(ListNode head, int x) {
        ListNode dummyHead1=new ListNode(-1);
        ListNode dummyHead2=new ListNode(-1);
        ListNode node1=dummyHead1;
        ListNode node2=dummyHead2;
        while (head!=null){
            if(head.val<x){
                node1.next=head;
                head=head.next;
                node1=node1.next;
                node1.next=null;
            }else {
                node2.next=head;
                head=head.next;
                node2=node2.next;
                node2.next=null;
            }
        }
        node1.next=dummyHead2.next;
        return dummyHead1.next;
    }
}
