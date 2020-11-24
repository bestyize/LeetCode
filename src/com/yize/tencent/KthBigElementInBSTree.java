package com.yize.tencent;

import com.yize.data.TreeNode;

import java.util.Stack;

public class KthBigElementInBSTree {
    public int findKthBigElement(TreeNode root,int k){
        Stack<TreeNode> stack=new Stack<>();
        while (!stack.isEmpty()||root!=null){
            if(root!=null){
                stack.push(root);
                root=root.left;
            }else {
                root=stack.pop();
                k--;
                if(k==0){
                    return root.val;
                }
            }

        }
        return -1;
    }
}
