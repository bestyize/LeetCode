package com.yize.tencent;

import com.yize.data.TreeNode;
import org.junit.Test;

/**
 * 判断二茬平衡树
 */
public class IsAVLTree {
    @Test
    public void test(){

    }

    public boolean isAVLTree(TreeNode root){
        if(root==null){
            return true;
        }
        if(Math.abs(depthOfTree(root.left)-depthOfTree(root.right))>1){
            return false;
        }
        return isAVLTree(root.left)&&isAVLTree(root.right);
    }

    public int depthOfTree(TreeNode root){
        if(root==null){
            return 0;
        }
        return 1+Math.max(depthOfTree(root.left),depthOfTree(root.right));
    }
}
