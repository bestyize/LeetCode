package com.yize.tencent;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 遍历View树
 */
public class TraverseViewTree {
    class TreeNode{

        public int val;
        public List<TreeNode> childs;

        public TreeNode(int val) {
            this.val = val;
            childs=new LinkedList<>();
        }
    }

    public List<Integer> traverseViewTree(TreeNode root){
        if(root==null){
            return null;
        }
        List<Integer> result=new LinkedList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        while (!queue.isEmpty()){
            int layerSize=queue.size();
            for (int i=0;i<layerSize;i++){
                TreeNode temp=queue.poll();
                result.add(temp.val);
                for (TreeNode node: temp.childs){
                    queue.offer(node);
                }
            }
        }
        return result;
    }
}
