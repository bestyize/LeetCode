package com.yize.tencent;

import com.yize.data.ListNode;
import org.junit.Test;

public class JudgeListInter {
    @Test
    public void test(){
        ListNode h1=ListNode.build(new int[]{1,2,3,4,5});
        ListNode h2=h1.next.next.next.next.next;
        System.out.println(judgeListInter(h1,h2));
    }
    public ListNode judgeListInter(ListNode h1,ListNode h2){
        ListNode l1=h1,l2=h2;
        while (l1!=null||l2!=null){
            if(l1==l2){
                return l1;
            }
            l1=l1!=null?l1.next:h2;
            l2=l2!=null?l2.next:h1;
        }
        return null;
    }
}
