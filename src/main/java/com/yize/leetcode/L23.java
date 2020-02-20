package com.yize.leetcode;

import com.yize.datastructure.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L23 {
    public ListNode mergeKLists(ListNode[] lists) {
        return method1(lists);
    }

    /**
     * 普通方法
     * @param lists
     * @return
     */
    public ListNode method1(ListNode[] lists){
        List<ListNode> list=new ArrayList<>();
        for(int i=0;i<lists.length;i++){
            while (lists[i]!=null){
                list.add(lists[i]);
                lists[i]=lists[i].next;
            }
        }

        Collections.sort(list, (o1, o2) -> {
            if(o1.val>o2.val){
                return 1;
            }else if(o1.val<o2.val){
                return -1;
            }else {
                return 0;
            }
        });
        ListNode dummy=new ListNode(-1);
        ListNode currNode=dummy;
        for(int i=0;i<list.size();i++){
            currNode.next=list.get(i);
            currNode=currNode.next;
        }
        return dummy.next;
    }
}
