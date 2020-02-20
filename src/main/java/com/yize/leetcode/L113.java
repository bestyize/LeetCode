package com.yize.leetcode;

import com.yize.datastructure.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
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
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L113 {
    @Test
    public void test(){
        TreeNode node1=new TreeNode(5);
        TreeNode node2=new TreeNode(4);
        TreeNode node3=new TreeNode(8);
        TreeNode node4=new TreeNode(11);
        TreeNode node5=new TreeNode(13);
        TreeNode node6=new TreeNode(4);
        TreeNode node7=new TreeNode(7);
        TreeNode node8=new TreeNode(2);
        TreeNode node9=new TreeNode(5);
        TreeNode node10=new TreeNode(1);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node3.left=node5;
        node3.right=node6;
        node4.left=node7;
        node4.right=node8;
        node6.left=node9;
        node6.right=node10;
        System.out.println(pathSum(node1,22));
    }



    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> lists=new ArrayList<>();
        pathSum(root,sum,lists,new ArrayList<>());
        return lists;
    }

    public void pathSum(TreeNode root, int sum,List<List<Integer>> lists,List<Integer> list) {
        if(root==null){
            return ;
        }
        sum-=root.val;
        list.add(root.val);
        if(root.left==null&&root.right==null&&sum==0){
            lists.add(new ArrayList<>(list));
        }else {
            pathSum(root.left,sum,lists,list);
            pathSum(root.right,sum,lists,list);
        }
        list.remove(list.size()-1);
    }
}
