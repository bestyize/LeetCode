package com.yize.leetcode;

import com.yize.datastructure.ListNode;
import org.junit.Test;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 *
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L61 {
    @Test
    public void test(){
        int val[]={1,2,3,4,5};
        ListNode node=new ListNode().buildListNode(val);
        node.print();
        node=rotateRight(node,1);
        node.print();
    }

    /**
     * 执行结果：
     * 通过
     * 显示详情
     * 执行用时 :
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 99.92%
     * 的用户
     * 内存消耗 :
     * 37.3 MB
     * , 在所有 Java 提交中击败了
     * 14.84%
     * 的用户
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||k==0){
            return head;
        }
        ListNode curr=head;
        int listSize=0;
        //成环，计算链表大小
        while (curr!=null){
            listSize++;
            if(curr.next==null){
                curr.next=head;
                break;
            }
            curr=curr.next;
        }
        int stepToRun=listSize-k%listSize;
        while (stepToRun>0){
            curr=curr.next;
            stepToRun--;
        }
        head=curr.next;
        curr.next=null;
        return head;
    }
}
