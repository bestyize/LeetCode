package com.yize.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L77 {
    @Test
    public void test(){
        System.out.println(combine(3,3));
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> lists=new ArrayList<>();
        if(n<k){
            return lists;
        }
        backTrack(lists,new ArrayList<>(),n,k);
        return lists;
    }

    public void backTrack(List<List<Integer>> lists,List<Integer> item,int n,int k){
        if(item.size()==k){
            lists.add(new ArrayList<>(item));
            return;
        }
        for(int i=1;i<=n;i++){
            int currentSize=item.size();
            if(currentSize==0||item.get(currentSize-1)<i){
                item.add(i);
                backTrack(lists,item,n,k);
                item.remove(currentSize);
            }

        }
    }
}
