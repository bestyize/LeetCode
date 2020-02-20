package com.yize.leetcode;

import com.yize.datastructure.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 *
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 1
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 3
 * 进阶：
 * 如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L230 {
    @Test
    public void test(){
        TreeNode node1=new TreeNode(3);
        TreeNode node2=new TreeNode(1);
        TreeNode node3=new TreeNode(4);
        TreeNode node4=new TreeNode(2);
        node1.left=node2;
        node1.right=node3;
        node2.right=node4;
        System.out.println(kthSmallest(node1,1));
    }
    public int kthSmallest(TreeNode root, int k) {
        return method1(root,k);
    }

    public int method2(TreeNode root,int k){
        Stack<TreeNode> stack=new Stack<>();
        List<Integer> list=new ArrayList<>();
        while(root!=null||stack.isEmpty()==false){
            if(root!=null){
                stack.push(root);
                root=root.left;
            }else {
                root=stack.pop();
                list.add(root.val);
                if(list.size()==k){
                    return root.val;
                }
                root=root.right;
            }
        }
        return -1;
    }

    public int method1(TreeNode root, int k) {
        Stack<TreeNode> stack=new Stack<>();
        PriorityQueue<Integer> queue=new PriorityQueue<>(((o1, o2) -> o2.compareTo(o1)));
        while(root!=null||stack.isEmpty()==false){
            if(root!=null){
                if(queue.size()<k){
                    queue.offer(root.val);
                }else if(root.val<queue.peek()){
                    queue.poll();
                    queue.offer(root.val);
                }
                stack.push(root);
                root=root.left;
            }else{
                root=stack.pop();
                root=root.right;
            }
        }
        return queue.poll();
    }
}
