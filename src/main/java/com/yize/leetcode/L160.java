package com.yize.leetcode;

import com.yize.datastructure.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 编写一个程序，找到两个单链表相交的起始节点。
 *
 * 如下面的两个链表：
 *
 *
 *
 * 在节点 c1 开始相交。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        return method2(headA,headB);
    }

    /**
     * 我们通常做这种题的思路是设定两个指针分别指向两个链表头部，一起向前走直到其中一个到达末端，另一个与末端距离则是两链表的 长度差。再通过长链表指针先走的方式消除长度差，最终两链表即可同时走到相交点。
     *
     * 换个方式消除长度差： 拼接两链表。
     * 设长-短链表为 C，短-长链表为 D （分别代表长链表在前和短链表在前的拼接链表），则当 C 走到长短链表交接处时，D 走在长链表中，且与长链表头距离为 长度差;
     *
     * 以下图片帮助理解：当 ha == hb 时跳出，返回即可
     *
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists/solution/intersection-of-two-linked-lists-shuang-zhi-zhen-l/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param headA
     * @param headB
     * @return
     */
    public ListNode method2(ListNode headA, ListNode headB){
        ListNode ptrA=headA;
        ListNode ptrB=headB;
        while (ptrA!=ptrB){
            ptrA=(ptrA!=null)?ptrA.next:headB;
            ptrB=(ptrB!=null)?ptrB.next:headA;
        }
        return ptrA;
    }



    public ListNode method1(ListNode headA, ListNode headB) {
        Map<ListNode,Integer> map=new HashMap<>();
        while(headA!=null){
            map.put(headA,1);
            headA=headA.next;
        }
        while(headB!=null){
            if(map.containsKey(headB)){
                return headB;
            }
            headB=headB.next;
        }

        return null;
    }
}
