package com.yize.leetcode;

import org.junit.Test;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L66 {
    @Test
    public void test(){
        int[]a={9};
        a=plusOne(a);
        System.out.println(a);
    }
    public int[] method2(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }




    /**
     * 执行结果：
     * 通过
     * 显示详情
     * 执行用时 :
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗 :
     * 35.1 MB
     * , 在所有 Java 提交中击败了
     * 59.87%
     * 的用户
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        if(digits[digits.length-1]==9){
            if(digits.length==1){
                return new int[]{1,0};
            }
            digits[digits.length-1]=0;
            int addin=1;
            int ptr=digits.length-2;
            while(ptr>=0){
                int x=digits[ptr]+addin;
                addin=x/10;
                int re=x%10;
                digits[ptr]=re;
                ptr--;
                if(ptr==-1&&addin==1){
                    int[] result=new int[digits.length+1];
                    result[0]=1;
                    for(int i=1;i<result.length;i++){
                        result[i]=digits[i-1];
                    }
                    return result;
                }
            }
            return digits;
        }else{
            digits[digits.length-1]++;
            return digits;
        }
    }
}
