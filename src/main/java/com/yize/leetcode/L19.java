package com.yize.leetcode;

import com.yize.datastructure.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L19 {

    @Test
    public void test(){
        ListNode head=new ListNode(0);
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);

        head.next=node1;
//        node1.next=node2;
//        node2.next=node3;
//        head.print();
        head=removeNthFromEnd(head,2);
        head.print();


    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        return method3(head,n);
    }

    public ListNode method1(ListNode head, int n) {
        ListNode node=head;
        List<ListNode> nodeList=new ArrayList<>();
        while (node!=null){
            nodeList.add(node);
            node=node.next;
        }
        if(nodeList.size()-n>=0){
            int base=nodeList.size()-n;
            if(n==1){
                if(nodeList.size()>1){
                    nodeList.get(nodeList.size()-2).next=null;
                }else {
                    head=null;
                }
            }else if(base==0){
                if(nodeList.size()>1){
                    head=nodeList.get(1);
                }else {
                    head=null;
                }
            }else {
//                if(base>1&&base<nodeList.size()){
                    nodeList.get(base-1).next=nodeList.get(base+1);
//                }
            }
        }else {
            return null;
        }

        return head;
    }

    public ListNode method2(ListNode head, int n) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode quick=head;
        int len=0;
        while(quick!=null){
            quick=quick.next;
            len++;
        }
        len-=n;
        quick=dummy;
        while (len>0){
            len--;
            quick=quick.next;
        }
        quick.next=quick.next.next;
        return dummy.next;
    }

    /**
     * 双指针，一遍遍历
     * @param head
     * @param n
     * @return
     */
    public ListNode method3(ListNode head, int n) {
        ListNode dummy=new ListNode(-1);
        ListNode quick=dummy;
        ListNode slow=dummy;
        dummy.next=head;
        while (n>=0){
            n--;
            quick=quick.next;
        }

        while (quick!=null){
            slow=slow.next;
            quick=quick.next;
        }
        slow.next=slow.next.next;
        return dummy.next;
    }









}
