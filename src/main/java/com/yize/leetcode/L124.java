package com.yize.leetcode;

import com.yize.datastructure.TreeNode;

/**
 * 给定一个非空二叉树，返回其最大路径和。
 *
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * 输出: 6
 * 示例 2:
 *
 * 输入: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 输出: 42
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L124 {
    int maxSum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathSumHelper(root);
        return maxSum;
    }
    public int maxPathSumHelper(TreeNode root) {
        if(root==null){
            return 0;
        }
        int leftTreeSum=Math.max(maxPathSumHelper(root.left),0);
        int rightTreeSum=Math.max(maxPathSumHelper(root.right),0);
        int value=leftTreeSum+rightTreeSum+root.val;//计算当前和
        maxSum=Math.max(maxSum,value);
        return root.val+Math.max(leftTreeSum,rightTreeSum);
    }


}
