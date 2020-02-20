package com.yize.leetcode;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class L6 {
    public static void main(String[] args) {
        String ss=new L6().method1("LEETCODEISHIRING",4);
        System.out.println(ss);
    }
    /**
     * 假设有n行
     * 第一层2*(n-1)*i,i=0,1,2,...
     * 第二层(2(n-1)+1)*i,i=0,1,2,...
     * @param s
     * @param numRows
     * @return
     */

    public String method1(String s,int numRows){
        if(numRows<=1){
            return s;
        }
        String[] ss=new String[numRows];
        for (int i=0;i<ss.length;i++){
            ss[i]="";
        }
        for (int i=0;i<s.length();i++){
            int base=(numRows<<1)-2;
            if(i%base<numRows){
                ss[i%base]+=s.charAt(i);
            }else {
                ss[base-i%base]+=s.charAt(i);
            }
        }
        String sss=new String();
        for(int i=0;i<ss.length;i++){
            sss+=ss[i];
        }
        return sss;
    }

}
