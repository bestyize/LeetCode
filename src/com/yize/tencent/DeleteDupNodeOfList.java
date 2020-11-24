package com.yize.tencent;

import com.yize.data.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 删除无序链表中的重复节点
 */
public class DeleteDupNodeOfList {
    public ListNode deleteDupNodeOfList(ListNode head){
        ListNode curr=head;
        Set<ListNode> set=new HashSet<>();
        ListNode dummy=new ListNode(-1);
        ListNode noDupNode=dummy;
        while (curr!=null){
            if(!set.contains(curr)){
                noDupNode.next=curr;
                noDupNode=noDupNode.next;
            }
            set.add(curr);
            curr=curr.next;
        }
        return dummy.next;

    }
}
