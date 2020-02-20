package com.yize.datastructure;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode() {
    }

    public static ListNode buildListNode(int []val){
        ListNode dummy=new ListNode(-1);
        ListNode head=new ListNode(val[0]);
        dummy.next=head;
        for(int i=1;i<val.length;i++){
            head.next=new ListNode(val[i]);
            head=head.next;
        }
        return dummy.next;
    }

    public void print(){
        ListNode node=this;
        while (node!=null){
            System.out.print(node.val+"->");
            node=node.next;
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return "{" +
                "\"val\":\"" + val + "\"" +
                "}";
    }
}
