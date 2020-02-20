package com.yize.leetcode;

import org.junit.Test;

/**
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 *
 * 输入为非空字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L67 {
    @Test
    public void test(){
        System.out.println(addBinary("1","111"));
    }

    public String addBinary(String a, String b) {
        while (a.length()>b.length()){
            b="0"+b;
        }
        while (b.length()>a.length()){
            a="0"+a;
        }
        StringBuilder sb=new StringBuilder();
        int ptrA=a.length()-1,ptrB=b.length()-1;
        int addin=0;
        while (ptrA>=0){
            if(a.charAt(ptrA)=='1'&&b.charAt(ptrB)=='1'){
                if(addin==1){
                    sb.append(1);
                }else {
                    sb.append(0);
                }
                addin=1;
            }else if(a.charAt(ptrA)=='1'||b.charAt(ptrB)=='1'){
                if(addin==1){
                    sb.append(0);
                    addin=1;
                }else {
                    sb.append(1);
                    addin=0;
                }

            }else {
                if(addin==1){
                    sb.append(1);
                }else {
                    sb.append(0);
                }
                addin=0;
            }
            ptrA--;
            ptrB--;
        }
        if(addin==1){
            sb.append(1);
        }
        return sb.reverse().toString();

    }
}
