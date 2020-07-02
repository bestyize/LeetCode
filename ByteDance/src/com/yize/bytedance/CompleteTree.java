package com.yize.bytedance;

import com.yize.data.TreeNode;

import java.util.LinkedList;

public class CompleteTree {
    /**
     * 若有任何一个节点有右孩子没有左孩子，肯定不是完成二叉树，直接返回false；
     * 若一个节点不是两个孩子都全，也不是只有右孩子没有左孩子，那它后面遍历的节点都必需是叶子节点。
     * @param root
     * @return
     */
    public boolean isCompleteTree1(TreeNode root){
        if(root==null){
            return true;
        }
        LinkedList<TreeNode> queue=new LinkedList<>();
        boolean reachLeaf=false;
        queue.offerFirst(root);
        while (queue!=null){
            TreeNode node=queue.poll();
            if ((reachLeaf&&(node.left!=null||node.right!=null))||(node.left==null&&node.right!=null)){
                return false;
            }
            if(node.left!=null){
                queue.offerFirst(node.left);
            }
            if(node.right!=null){
                queue.offerFirst(node.right);
            }
            if(node.left!=null&&node.right==null){
                reachLeaf=true;
            }
        }
        return true;
    }
    public boolean isCompleteTree(TreeNode root){
        if(root==null){
            return true;
        }
        LinkedList<TreeNode> queue=new LinkedList<>();
        boolean reachLeaf=false;
        queue.offerFirst(root);
        while (queue!=null){
            int size=queue.size();
            for (int i=0;i<size;i++){
                TreeNode node=queue.pollLast();
                if((reachLeaf&&(node.left!=null||node.right!=null))||(node.left==null&&node.right!=null)){
                    return false;
                }
                if(node.left!=null){
                    queue.offerFirst(node.left);
                }
                if(node.right!=null){
                    queue.offerFirst(node.right);
                }
                if(node.left!=null&&node.right==null){
                    reachLeaf=true;
                }
            }
        }
        return true;
    }
}
