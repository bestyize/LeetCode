package com.yize.data;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int val){
        this.val=val;
    }

    public static ListNode build(int[] values){
        if(values.length==0){
            return null;
        }
        ListNode head=new ListNode(values[0]);
        ListNode curr=head;
        for (int i=1;i<values.length;i++){
            curr.next=new ListNode(values[i]);
            curr=curr.next;
        }
        return head;
    }
    public void print(){
        ListNode curr=this;
        while (curr!=null){
            System.out.print(curr.val+"\t");
            curr=curr.next;
        }
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}
