package com.yize.bytedance;

import com.yize.data.ListNode;
import org.junit.Test;

public class ListNodeSort {
    class ListNodeSortHeap{
        @Test
        public void test(){

        }

        /**
         * 归并排序对链表进行排序
         * @param head
         * @return
         */
        public ListNode mergeSort(ListNode head){
            if(head==null||head.next==null){
                return head;
            }
            ListNode slow=head;
            ListNode quick=head;
            ListNode prevEndNode=head;
            while (quick!=null&&quick.next!=null){
                prevEndNode=slow;
                slow=slow.next;
                quick=quick.next.next;
            }
            prevEndNode.next=null;
            ListNode left=mergeSort(head);
            ListNode right=mergeSort(slow);
            return merge(left,right);
        }

        private ListNode merge(ListNode left, ListNode right) {
            ListNode head=new ListNode(-1);
            ListNode curr=head;
            while (left!=null&&right!=null){
                if(left.val<=right.val){
                    curr.next=new ListNode(left.val);
                    left=left.next;
                }else {
                    curr.next=new ListNode(right.val);
                    right=right.next;
                }
                curr=curr.next;
            }
            curr.next=left==null?right:left;
            return head.next;
        }
    }
}
