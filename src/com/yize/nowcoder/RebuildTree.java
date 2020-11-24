package com.yize.nowcoder;

import com.yize.data.TreeNode;
import org.junit.Test;

/**
 *              1
 *      2               3
 * 4        5       6       7
 *
 * 前序： 1 2 4 5 3 6 7
 * 中序： 4 2 5 1 6 3 7
 *
 */

public class RebuildTree {
    @Test
    public void test(){
        int[] pre={1,2,4,5,3,6,7};
        int[] in={4,2,5,1,6,3,7};
        TreeNode root=rebuildTreeFromPreIn(pre,in);
        System.out.println(root.val);
    }


    /**
     * 从前序和中序恢复二叉树
     * @param pre
     * @param in
     * @return
     */
    public TreeNode rebuildTreeFromPreIn(int[] pre,int[] in){
        return rebuildTreeFromPreIn(pre,0, pre.length-1,in,0,in.length-1);
    }

    public TreeNode rebuildTreeFromPreIn(int[] pre,int preStart,int preEnd,int[] in,int inStart,int inEnd){
        if(preStart>preEnd||inStart>inEnd){
            return null;
        }
        int rootVal=pre[preStart];
        TreeNode root=new TreeNode(rootVal);
        int count=0;
        for (int i=inStart;i<=inEnd;i++){
            if(in[i]==rootVal){
                break;
            }
            count++;
        }
        root.left=rebuildTreeFromPreIn(pre,preStart+1,preStart+count,in,inStart,inStart+count-1);
        root.right=rebuildTreeFromPreIn(pre,preStart+count+1,preEnd,in,inStart+count+1,inEnd);
        return root;

    }
}
