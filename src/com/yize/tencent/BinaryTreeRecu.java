package com.yize.tencent;

import com.yize.data.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRecu {
    @Test
    public void test(){
        TreeNode root=new TreeNode(0);
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        root.left=node1;
        root.right=node2;
        node2.left=node3;
        node2.right=node4;
        System.out.println(levelRecu(root));
    }

    public List<Integer> levelRecu(TreeNode root){
        List<Integer> nums=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (queue.isEmpty()==false){
            int size=queue.size();
            for (int i=0;i<size;i++){
                TreeNode node=queue.poll();
                nums.add(node.val);
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
        }
        return nums;
    }


}
