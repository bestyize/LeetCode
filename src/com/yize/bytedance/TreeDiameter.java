package com.yize.bytedance;

import com.yize.data.TreeNode;
import org.junit.Test;

/**
 * ## 1、求树的直径
 *
 * 出处：https://www.nowcoder.com/discuss/442244
 */
public class TreeDiameter {
    @Test
    public void test(){

    }

    /**
     * 求二叉树直径【解题思路：何为二叉树直径？这条直径不一定经过根节点，但是一定经过二叉树中的某一个节点，该节点
     * 就是我们的"根"节点，他的左右子树高度和即为二叉树直径，所以，在掌握求二叉树高度的基础上，我们需要判断每个节点的高度，
     * 选择左右高度和为最大值作为二叉树的直径，为什么不加1呢，因为根节点被包含了一次了】
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        treeDiameter(root);
        return maxDiameter;
    }

    int maxDiameter=0;
    public int treeDiameter(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftMax=treeDiameter(root.left);
        int rightMax=treeDiameter(root.right);
        maxDiameter=Math.max(maxDiameter,leftMax+rightMax);
        return 1+Math.max(leftMax,rightMax);
    }

    /**
     * 求树的深度，递归思想
     * @param root
     * @return
     */
    public int depthOfTree(TreeNode root){
        if(root==null){
            return 0;
        }
        return 1+Math.max(depthOfTree(root.left),depthOfTree(root.right));
    }


}
