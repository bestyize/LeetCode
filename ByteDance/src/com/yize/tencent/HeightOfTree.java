package com.yize.tencent;

import com.yize.data.TreeNode;

public class HeightOfTree {
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        return 1+Math.max(height(root.left),height(root.right));
    }
}
