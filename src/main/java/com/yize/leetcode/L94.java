package com.yize.leetcode;

import com.yize.datastructure.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 中序输出: [1,3,2] 左->中->右
 * 先序输出：[1,2,3] 根->左->右
 * 后序输出：[3,2,1] 左->右->根
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L94 {
    @Test
    public void test(){
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        node1.right=node2;
        node2.left=node3;
        System.out.println(inorderTraversal(node1));
    }



    List<Integer> lists=new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root){
        return method1(root);
    }

    /**
     * 中序递归
     * @param root
     * @return
     */
    public List<Integer> method1(TreeNode root) {
        if(root!=null){
            method1(root.left);
            lists.add(root.val);
            method1(root.right);
        }
        return lists;
    }

    /**
     * 中序非递归
     * @param root
     * @return
     */
    public List<Integer> method2(TreeNode root){
        Stack<TreeNode> stack=new Stack<>();
        while (stack.isEmpty()==false||root!=null){
            if(root!=null){
                stack.push(root);
                root=root.left;
            }else {
                root=stack.pop();
                lists.add(root.val);
                root=root.right;

            }
        }
        return lists;
    }

}
