package com.yize.bytedance;

import com.yize.data.TreeNode;
import org.junit.Test;

import java.util.Stack;

public class BstToList {
    @Test
    public void test(){
        TreeNode root=new TreeNode(3);
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(6);
        TreeNode node3=new TreeNode(4);
        TreeNode node4=new TreeNode(7);
        root.left=node1;
        root.right=node2;
        node2.left=node3;
        node2.right=node4;
        TreeNode temp=bstToList(root);
        System.out.println(1);
    }

    /**
     * 二叉搜索树转双链表
     * @param root
     * @return
     */
    public TreeNode bstToList(TreeNode root){
        TreeNode head=null;
        TreeNode prev=null;
        Stack<TreeNode> stack=new Stack<>();
        while (root!=null||!stack.isEmpty()){
            if(root!=null){
                stack.push(root);
                root=root.left;
            }else {
                root=stack.pop();
                TreeNode curr=root;
                if(head==null){
                    head=curr;
                    head.left=prev;
                    prev=curr;
                }else {
                    prev.right=curr;
                    curr.left=prev;
                    prev=curr;
                }
                root=root.right;
            }
        }
        return head;
    }
}
