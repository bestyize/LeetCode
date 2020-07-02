package com.yize.bytedance;

import com.yize.data.ListNode;

public class ReverseNodeEveryK {
    public ListNode reverseNodeEveryK(ListNode head,int k){
        if(head==null||head.next==null){
            return head;
        }
        ListNode dummy=new ListNode(-1);
        ListNode prevEnd=dummy;
        ListNode curr=head;
        while (curr!=null){
            int count=0;
            ListNode endNode=curr;
            ListNode prev=null;
            while (curr!=null&&count<k){//先K个一组翻转
                ListNode temp=curr.next;
                curr.next=prev;
                prev=curr;
                curr=temp;
                count++;
            }
            if(count==0){
                prevEnd.next=prev;
                prevEnd=endNode;
            }else{
                curr=prev;
                prev=null;
                while (curr!=null){
                    ListNode temp=curr.next;
                    curr.next=prev;
                    prev=curr;
                    curr=temp;
                }
                prevEnd.next=prev;
            }


        }
        return dummy.next;
    }
}
