package com.yize.tencent;

import com.yize.data.TreeNode;

public class MirrorOfBinaryTree {
    public TreeNode mirrorOfBinaryTree(TreeNode root){
        if(root==null){
            return null;
        }
        TreeNode left=root.left;
        root.left=root.right;
        root.right=left;
        mirrorOfBinaryTree(root.left);
        mirrorOfBinaryTree(root.right);
        return root;
    }
}
