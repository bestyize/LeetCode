package com.yize.leetcode;

import com.yize.datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 给定一个二叉树，原地将它展开为链表。
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L114 {
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        Stack<TreeNode> stack=new Stack();
        Queue<TreeNode> queue=new LinkedList<>();
        while(stack.isEmpty()==false||root!=null){
            if(root!=null){
                stack.push(root);
                queue.offer(root);
                root=root.left;
            }else{
                root=stack.pop();
                root=root.right;
            }
        }
        TreeNode prevNode=queue.poll();
        TreeNode head=prevNode;
        while(queue.isEmpty()==false){
            prevNode.left=null;
            prevNode.right=queue.poll();
            prevNode=prevNode.right;
        }
        root=head;

    }
}
