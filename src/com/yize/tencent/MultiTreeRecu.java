package com.yize.tencent;

import java.util.LinkedList;
import java.util.List;
import java.util.List;
import java.util.Queue;

/**
 * 叉树的遍历
 */
public class MultiTreeRecu{
    private class MultiTree{
        int val;
        List<MultiTree> childs;

        public MultiTree(int val) {
            this.val = val;
            this.childs=new LinkedList<>();
        }

    }
    public List<Integer> multiTreeRecu(MultiTree root){
        List<Integer> result=new LinkedList<>();
        Queue<MultiTree> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            for (int i=0;i<size;i++){
                MultiTree node=queue.poll();
                result.add(node.val);
                List<MultiTree> childs=node.childs;
                for (MultiTree child:childs){
                    queue.offer(child);
                }
            }
        }
        return result;
    }

}
