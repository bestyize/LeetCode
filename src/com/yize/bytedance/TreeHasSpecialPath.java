package com.yize.bytedance;

import com.yize.data.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. 路径总和 II
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */
public class TreeHasSpecialPath {
    private boolean treeHasSpecialPath(TreeNode root,int target){
        if(root==null){
            return false;
        }
        int val=target-root.val;
        if(val==0&&root.left==null&&root.right==null){
            return true;
        }
        return treeHasSpecialPath(root.left,val)||treeHasSpecialPath(root.right,val);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result=new ArrayList<>();
        dfs(root,sum,result,new ArrayList<>());
        return result;
    }

    public void dfs(TreeNode root,int target,List<List<Integer>> result,List<Integer> path){
        if(root==null){
            return ;
        }
        path.add(root.val);
        int val=target-root.val;
        if(val==0&&root.left==null&&root.right==null){
            result.add(new ArrayList<>(path));
        }else {
            dfs(root.left,val,result,path);
            dfs(root.right,val,result,path);
        }
        path.remove(path.size()-1);
    }
}
