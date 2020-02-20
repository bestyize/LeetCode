package com.yize.leetcode;

import com.yize.datastructure.ListNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 *
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L82 {
    @Test
    public void test(){
        ListNode node=ListNode.buildListNode(new int[]{1,2,2});
        node=method1(node);
        node.print();
    }

    public ListNode method1(ListNode head){
        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;
        dummy.next=head;
        while (curr.next!=null&&curr.next.next!=null){
            if(curr.next.val==curr.next.next.val){
                while (curr.next.next!=null&&curr.next.val==curr.next.next.val){
                    curr.next=curr.next.next;
                }
                curr.next=curr.next.next;
            }else {
                curr=curr.next;

            }
        }
        return dummy.next;
    }


    public ListNode method(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while (cur.next!=null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                // 重复元素的起点
                ListNode del = cur.next;
                while (del.next != null && del.val == del.next.val) {
                    del = del.next;
                }
                // while退出时，del走到了最后一个重复元素的位置，在这里设置下
                cur.next = del.next;
            } else {
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }


    public ListNode deleteDuplicates(ListNode head) {
        Map<Integer,Integer> map=new HashMap<>();
        ListNode quick= head;
        while (quick!=null){
            while (quick.next!=null&&quick.val==quick.next.val){
                quick.next=quick.next.next;
                map.put(quick.val,1);
            }
            quick=quick.next;
        }
        ListNode dummy=new ListNode(-1);
        ListNode prev=dummy;
        ListNode curr=head;
        while (curr!=null){
            if(!map.containsKey(curr.val)){
                prev.next=curr;
                prev=prev.next;
                curr=curr.next;
            }else {
                if(curr.next==null){
                    curr=null;
                    prev.next=null;
                }else {
                    curr=curr.next;
                }

            }
        }
        return dummy.next;

    }
}
