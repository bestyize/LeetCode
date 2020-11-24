package com.yize.tencent;

import com.yize.data.TreeNode;

import java.util.Stack;

public class VerifyBST {
    public boolean verifyBST(TreeNode root){
        Stack<TreeNode> stack=new Stack<>();
        TreeNode prev=null;
        while (stack.isEmpty()==false||root!=null){
            if(root!=null){
                stack.push(root);
                root=root.left;
            }else {
                root=stack.pop();
                if(prev==null){
                    prev=root;
                }else {
                    if(prev.val>root.val){
                        return false;
                    }
                    prev=root;
                }
                root=root.right;
            }

        }
        return true;
    }
}
