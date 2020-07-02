package com.yize.bytedance;

import com.yize.data.TreeNode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树右视图
 */
public class RightViewOfTree {
    public List<Integer> rightViewOfTree(TreeNode root){
        List<Integer> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        LinkedList<TreeNode> queue=new LinkedList<>();
        queue.offerFirst(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            result.add(queue.peekLast().val);
            for (int i=0;i<size;i++){
                TreeNode temp=queue.pollLast();
                if(temp.left!=null){
                    queue.offerFirst(temp.left);
                }
                if(temp.right!=null){
                    queue.offerFirst(temp.right);
                }
            }
        }
        return result;
    }
}
