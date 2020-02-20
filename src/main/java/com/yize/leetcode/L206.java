package com.yize.leetcode;

import com.yize.datastructure.ListNode;
import org.junit.Test;

import java.util.Stack;

/**
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L206 {
    @Test
    public void test(){
        int[]a={1,2,3,4,5};
        ListNode node=new ListNode().buildListNode(a);
        node.print();
        node=reverseNode(node);
        node.print();
    }

    public ListNode reverseList(ListNode head) {
        return method1(head);
    }

    public ListNode method2(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        while (curr!=null){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }

    public ListNode method1(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        Stack<ListNode> stack=new Stack<>();
        while (head!=null){
            stack.push(head);
            head=head.next;
        }
        ListNode newHead=stack.pop();
        ListNode node=newHead;
        while (!stack.isEmpty()){
            node.next=stack.pop();
            node=node.next;
        }
        node.next=null;
        return newHead;
    }


    public ListNode reverseNode(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        while (curr!=null){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
}
