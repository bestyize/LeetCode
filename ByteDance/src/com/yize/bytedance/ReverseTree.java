package com.yize.bytedance;

import com.yize.data.TreeNode;

public class ReverseTree {
    public TreeNode reverseTree(TreeNode root){
        if(root==null){
            return null;
        }
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        reverseTree(root.left);
        reverseTree(root.right);
        return root;
    }
}
