package com.yize.nowcoder;

import com.yize.data.TreeNode;
import org.junit.Test;

import java.util.Stack;

/**
 *            6
 *      4           8
 *   3     5     7     9
 *
 *
 *
 */

public class BSTToDoubleList {
    @Test
    public void test(){
        TreeNode root=new TreeNode(6);
        TreeNode n1=new TreeNode(4);
        TreeNode n2=new TreeNode(8);
        TreeNode n3=new TreeNode(3);
        TreeNode n4=new TreeNode(5);
        TreeNode n5=new TreeNode(7);
        TreeNode n6=new TreeNode(9);
        root.left=n1;
        root.right=n2;
        n1.left=n3;
        n1.right=n4;
        n2.left=n5;
        n2.right=n6;
        TreeNode head=bstToDoubleList(root);
        System.out.println();

    }

    public TreeNode bstToDoubleList(TreeNode root){
        if(root==null){
            return null;
        }
        TreeNode head=null,prev=null;
        Stack<TreeNode> stack=new Stack<>();
        while (!stack.isEmpty()||root!=null){
            if(root!=null){
                stack.push(root);
                root=root.left;
            }else {
                root=stack.pop();
                if(head==null){
                    head=root;
                    prev=head;
                }else {
                    prev.right=root;
                    root.left=prev;
                    prev=root;
                }
                root=root.right;
            }
        }
        return head;
    }
}
