package com.yize.leetcode;

import com.yize.datastructure.TreeNode;

/**
 * 执行结果：
 * 通过
 * 显示详情
 * 执行用时 :
 * 1 ms
 * , 在所有 Java 提交中击败了
 * 31.94%
 * 的用户
 * 内存消耗 :
 * 44.2 MB
 * , 在所有 Java 提交中击败了
 * 5.06%
 * 的用户
 */
public class L112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null){
            return false;
        }
        sum-=root.val;
        if(root.left==null&&root.right==null&&sum==0){
            return true;
        }
        return hasPathSum(root.left,sum)||hasPathSum(root.right,sum);
    }
}
