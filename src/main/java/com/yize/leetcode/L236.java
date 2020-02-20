package com.yize.leetcode;

import com.yize.datastructure.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 *
 *
 *  
 *
 * 示例 1:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L236 {
    @Test
    public void test(){
        TreeNode node1=new TreeNode(3);
        TreeNode node2=new TreeNode(5);
        TreeNode node3=new TreeNode(1);
        TreeNode node4=new TreeNode(6);
        TreeNode node5=new TreeNode(2);
        TreeNode node6=new TreeNode(0);
        TreeNode node7=new TreeNode(8);
        TreeNode node8=new TreeNode(7);
        TreeNode node9=new TreeNode(4);

        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        node3.left=node6;
        node3.right=node7;
        node5.left=node8;
        node5.right=node9;

        System.out.println(lowestCommonAncestor(node1,node2,node9).val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p==q){
            return p;
        }
        if(root==null||p==null||q==null){
            return null;
        }
        backTrack(root,p,q,new ArrayList<>());
        int ptr=0;
        while (ptr<list1.size()&&ptr<list2.size()){
            if(list2.get(ptr)!=list1.get(ptr)){
                return ptr==0?null:list1.get(ptr-1);
            }
            ptr++;
        }
        return list1.size()>list2.size()?list2.get(list2.size()-1):list1.get(list1.size()-1);
    }
    private List<TreeNode> list1=new ArrayList<>();
    private List<TreeNode> list2=new ArrayList<>();
    public void backTrack(TreeNode node,TreeNode p,TreeNode q,List<TreeNode> list){
        if(node==null||(list1.size()!=0&&list2.size()!=0)){
            return ;
        }
        list.add(node);
        if(node==p||node==q){
            if(list1.size()==0){
                list1.addAll(new ArrayList<>(list));
            }else {
                list2.addAll(new ArrayList<>(list));
                return ;
            }
        }
        backTrack(node.left,p,q,list);
        backTrack(node.right,p,q,list);
        list.remove(list.size()-1);
    }
}
