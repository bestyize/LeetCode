package com.yize.tencent;

import com.yize.data.ListNode;
import org.junit.Test;

import java.util.Stack;

public class ListNumberAdd {
    /**
     * 低位低字节两数相加
     * @param n1
     * @param n2
     * @return
     */
    public ListNode numberAdd(ListNode n1,ListNode n2){
        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;
        int addin=0;
        while (n1!=null||n2!=null){
            int val=addin;
            if(n1!=null&&n2!=null){
                val+=n1.val+n2.val;
            }else {
                val+=n1!=null?n1.val:n2.val;
            }
            curr.next=new ListNode(val%10);
            curr=curr.next;
            addin=val/10;
            n1=n1.next;
            n2=n2.next;
        }
        if(addin!=0){
            curr.next=new ListNode(addin);
        }
        return dummy.next;
    }
    @Test
    public void test(){
        ListNode n1=ListNode.build(new int[]{9,9,9});
        ListNode n2=ListNode.build(new int[]{1,1,1});
        ListNode r=numberAddTwo(n1,n2);
        r.print();
    }


    /**
     * 数字的高位放在低字节的两数相加，用栈实现
     * @param n1
     * @param n2
     * @return
     */
    public ListNode numberAddTwo(ListNode n1,ListNode n2){
        Stack<Integer> stack1=new Stack<>();
        Stack<Integer> stack2=new Stack<>();
        while (n1!=null){
            stack1.push(n1.val);
            n1=n1.next;
        }
        while (n2!=null){
            stack2.push(n2.val);
            n2=n2.next;
        }
        ListNode curr=null;
        int addin=0;
        while (!stack1.isEmpty()||!stack2.isEmpty()){
            int val=addin;
            if(!stack1.isEmpty()){
                val+=stack1.pop();
            }
            if(!stack2.isEmpty()){
                val+=stack2.pop();
            }
            ListNode newNode=new ListNode(val%10);
            newNode.next=curr;
            curr=newNode;
            addin=val/10;
        }
        ListNode head=null;
        if(addin!=0){
            head=new ListNode(addin);
            head.next=curr;
        }else {
            head=curr;
        }
        return head;
    }


}
