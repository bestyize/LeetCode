package com.yize.leetcode;

import com.yize.datastructure.TreeNode;

/**
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度  2.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L111 {
    /**
     * 执行用时 :
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗 :
     * 45.4 MB
     * , 在所有 Java 提交中击败了
     * 5.07%
     * 的用户
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.left!=null&&root.right!=null||root.left==null&&root.right==null){
            return 1+Math.min(minDepth(root.left),minDepth(root.right));
        }
        return root.left==null?1+minDepth(root.right):1+minDepth(root.left);

    }
}
