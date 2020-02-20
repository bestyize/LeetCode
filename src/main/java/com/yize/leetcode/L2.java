package com.yize.leetcode;

import com.yize.datastructure.ListNode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2 {

    public static void main(String[] args) {
        ListNode l1=buildNode(99);
        ListNode l2=buildNode(9);
        System.out.println();
        ListNode result=addTwoNumbers(l1,l2);
        while (result!=null){
            System.out.print(result.val);
            result=result.next;
        }
    }

    private static ListNode buildNode(int number){
        String nn=String.valueOf(number);

        ListNode headNode=new ListNode(nn.charAt(nn.length()-1)-0x30);
        ListNode currNode=headNode;
        for(int i=nn.length()-2;i>=0;i--){
            currNode.next=new ListNode(nn.charAt(i)-0x30);
            currNode=currNode.next;
        }
        return headNode;

    }

    private static boolean shouldExchange(ListNode l1, ListNode l2){
        ListNode ll1=l1,ll2=l2;
        int count1=0,count2=0;
        while (ll1!=null){
            count1++;
            ll1=ll1.next;
        }

        while (ll2!=null){
           count2++;
            ll2=ll2.next;
        }

        return count1>count2;

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tempNode=null;
        if(shouldExchange(l1,l2)){
            tempNode=l1;
            l1=l2;
            l2=tempNode;
        }

        int addin=0;
        ListNode headNode=l1;
        ListNode headNodeFakeLastNode=null;
        while (l1!=null&&l2!=null){
            int re=l1.val+l2.val+addin;
            if(re/10!=0){
                addin=1;
            }else {
                addin=0;
            }
            l1.val=re%10;
            headNodeFakeLastNode=l1;
            l1=l1.next;
            l2=l2.next;
        }
        if(l2!=null) {//l1到头但是l2没到头
            headNodeFakeLastNode.next=l2;
            ListNode fakeLastNode2=null;
            while (l2!=null){
                int re=l2.val+addin;
                if(re/10!=0){
                    addin=1;
                }else {
                    addin=0;
                }
                l2.val=re%10;
                fakeLastNode2=l2;
                l2=l2.next;
            }
            if(addin!=0){
                fakeLastNode2.next=new ListNode(1);
            }
        }else if(addin==1){//两个都穷尽，并且有进位
            headNodeFakeLastNode.next=new ListNode(1);
        }
        return headNode;


    }

    public ListNode addTwoNumber(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode cursor = root;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sumVal = l1Val + l2Val + carry;
            carry = sumVal / 10;

            ListNode sumNode = new ListNode(sumVal % 10);
            cursor.next = sumNode;
            cursor = sumNode;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        return root.next;
    }



}
