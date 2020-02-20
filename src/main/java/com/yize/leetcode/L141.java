package com.yize.leetcode;

import com.yize.datastructure.ListNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 *
 * 示例 2：
 *
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 *
 * 示例 3：
 *
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L141 {
    @Test
    public void test(){
        ListNode node=new ListNode(1);
        System.out.println(hasCycle(node));
    }
    public boolean hasCycle(ListNode head) {
        ListNode quick=head.next;
        ListNode slow=head;
        while (slow!=quick){
            if(quick==null||quick.next==null){
                return false;
            }
            slow=slow.next;
            quick=quick.next.next;
        }
        return true;
    }
    public boolean method1(ListNode head) {
        Map<ListNode,Integer> map=new HashMap<>();
        int count=0;
        while (head!=null){
            if(!map.containsKey(head)){
                map.put(head,count++);
                head=head.next;
            }else {
                return true;
            }
        }
        return false;
    }
}
