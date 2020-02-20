package com.yize.leetcode;

import com.yize.datastructure.TreeNode;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L101 {
    /**
     * 执行结果：
     * 通过
     * 显示详情
     * 执行用时 :
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗 :
     * 40.3 MB
     * , 在所有 Java 提交中击败了
     * 5.04%
     * 的用户
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return isSymmetric(root.left,root.right);
    }
    public boolean isSymmetric(TreeNode left,TreeNode right) {
        if(left==null&&right==null){
            return true;
        }
        if(left==null&&right!=null||left!=null&&right==null||left.val!=right.val){
            return false;
        }
        boolean result=isSymmetric(left.left,right.right)&&isSymmetric(left.right,right.left);
        return result;
    }
}
