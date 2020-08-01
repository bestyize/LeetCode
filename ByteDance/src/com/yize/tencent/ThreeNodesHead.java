package com.yize.tencent;

import com.yize.data.TreeNode;
import org.junit.Test;
import sun.reflect.generics.tree.Tree;

/**
 * 3个节点的公共父节点
 */
public class ThreeNodesHead {
    @Test
    public void test(){
        /**
         *              0
         *      1              2
         * 3      4                    5
         */
        TreeNode root=new TreeNode(0);
        TreeNode n1=new TreeNode(1);
        TreeNode n2=new TreeNode(2);
        TreeNode n3=new TreeNode(3);
        TreeNode n4=new TreeNode(4);
        TreeNode n5=new TreeNode(5);
        root.left=n1;
        root.right=n2;
        n1.left=n3;
        n1.right=n4;
        n2.right=n5;
        TreeNode node=threeNodesHead(root,n5,n3,n4);
        System.out.println(node.val);

    }

    public TreeNode threeNodesHead(TreeNode root,TreeNode n1, TreeNode n2, TreeNode n3){
        return originNode(root,n1,n2,n3);
    }

    public TreeNode originNode(TreeNode root,TreeNode n1,TreeNode n2,TreeNode n3){
        if(root==null){
            return null;
        }
        if(n1==root||n2==root||n3==root){
            return root;
        }
        TreeNode left=originNode(root.left,n1,n2,n3);
        TreeNode right=originNode(root.right,n1,n2,n3);
        if(left!=null&&right!=null){
            return root;
        }
        if(left!=null){
            return left;
        }
        if(right!=null){
            return right;
        }
        return null;

    }
}
