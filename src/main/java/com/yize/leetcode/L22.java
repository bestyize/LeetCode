package com.yize.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L22 {

    @Test
    public void test(){
        System.out.println(generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        return method1(n);
    }

    public List<String> method1(int n){
        List<String> result=new ArrayList<>();
        return backtrack(result,"",0,0,n);
    }


    /**
     * 思路和算法,回溯法求解
     *
     * 只有在我们知道序列仍然保持有效时才添加 '(' or ')'，而不是像 方法一 那样每次添加。我们可以通过跟踪到目前为止放置的左括号和右括号的数目来做到这一点，
     *
     * 如果我们还剩一个位置，我们可以开始放一个左括号。 如果它不超过左括号的数量，我们可以放一个右括号。
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/generate-parentheses/solution/gua-hao-sheng-cheng-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param result
     * @param item
     * @param openCount
     * @param closeCount
     * @param maxCount
     * @return
     */
    public List<String> backtrack(List<String> result,String item,int openCount,int closeCount,int maxCount){
        if(item.length()==maxCount<<1){
            result.add(item);
            return result;
        }
        if (openCount<maxCount){
            backtrack(result,item+"(",openCount+1,closeCount,maxCount);
        }
        if(closeCount<openCount){
            backtrack(result,item+")",openCount,closeCount+1,maxCount);
        }
        return result;
    }

}

