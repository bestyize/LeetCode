package com.yize.leetcode;

import com.yize.datastructure.ListNode;
import org.junit.Test;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L83 {

    @Test
    public void test(){
        ListNode node=ListNode.buildListNode(new int[]{1,1,1,1,2,3,4,4,4});
        node=deleteDuplicates(node);
        node.print();
    }
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur=head;
        while (cur!=null){
            while (cur.next!=null&&cur.val==cur.next.val){
                cur.next=cur.next.next;
            }
            cur=cur.next;
        }
        return head;
    }
}
