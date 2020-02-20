package com.yize.leetcode;

import com.yize.datastructure.ListNode;
import org.junit.Test;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *  
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L24 {

    @Test
    public void test(){
        int[] a=new int[]{0,1,2,3};
        ListNode head=new ListNode().buildListNode(a);
        head.print();
        swapPairs(head);
        //head.print();
    }

    public ListNode swapPairs(ListNode head) {
        return method1(head);
    }

    /**
     * 执行结果：
     * 通过
     * 显示详情
     * 执行用时 :
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗 :
     * 34.5 MB
     * , 在所有 Java 提交中击败了
     * 36.30%
     * 的用户
     * @param head
     * @return
     */
    public ListNode method1(ListNode head){
        if(head==null){
            return head;
        }
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode slow=head;
        ListNode quick=head.next;
        ListNode prevNode=dummy;
        while (quick!=null){
            //上一轮最后一个节点连接上这个节点
            prevNode.next=quick;
            //慢节点的下一个节点变为快节点的下一个节点
            slow.next=quick.next;
            //快节点的下一个节点变为慢节点
            quick.next=slow;
            //更新下一轮的上一个节点
            prevNode=slow;

            //更新下一轮用到的两个节点指针
            slow=slow.next;
            if(slow==null){//这个slow是下一轮的第一个节点，如果为null,就不用再向下了
                break;
            }
            quick=slow.next;
        }
        dummy.next.print();
        return dummy.next;
    }
}
