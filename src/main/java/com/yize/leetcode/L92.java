package com.yize.leetcode;

import com.yize.datastructure.ListNode;
import org.junit.Test;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L92 {
    @Test
    public void test(){
        int[]a={1,2,3,4,5};
        ListNode node=new ListNode().buildListNode(a);
        ListNode reverse=method1(node,3,4);
        reverse.print();
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        return method1(head,m,n);
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
     * 34.6 MB
     * , 在所有 Java 提交中击败了
     * 13.84%
     * 的用户
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode method1(ListNode head, int m, int n) {
        if(head==null){
            return head;
        }
        ListNode headStart=head;
        ListNode headEnd=null;
        int currPtr=1;
        while (currPtr<m){//寻找第一个节点
            headEnd=head;
            head=head.next;
            currPtr++;
        }
        ListNode prev=null;
        ListNode currNode=head;
        while (currNode!=null&&currPtr<=n){
            ListNode temp=currNode.next;
            currNode.next=prev;
            prev=currNode;
            currNode=temp;
            currPtr++;
        }
        head.next=currNode;//接到n-sizeof(node)
        if(headEnd==null){//从第一个开始反转
            return prev;
        }
        headEnd.next=prev;
        return headStart;
    }
    public ListNode method2(ListNode head, int m, int n) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode pre=dummy;
        for(int i=1;i<m;i++){
            pre=pre.next;//前驱节点，反转位置的前一个结点
        }
        head=pre.next;//第一个反转节点
        for(int i=m;i<n;i++){
            ListNode nextNode=head.next;
            head.next=nextNode.next;//接到前面
            nextNode.next=pre.next;//把原本的head接到后面
            pre.next=nextNode;
        }
        return dummy.next;

    }
}
