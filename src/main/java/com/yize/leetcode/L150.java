package com.yize.leetcode;

import java.util.Stack;

public class L150 {
    public int evalRPN(String[] tokens) {
        //判空
        if(tokens==null)
            return 0;
        //长度
        int length=tokens.length;
        //保存结果
        int result=0;
        //栈存储数字
        Stack<Integer> stack=new Stack<Integer>();
        String c;
        int first,second;
        for(int i=0;i<length;i++){
            c=tokens[i];//获得字符串
            //遇到符号，出栈两个数字
            if(c.equals("+")){
                second=stack.pop();
                first=stack.pop();
                result=first+second;
                stack.push(result);
            }else if(c.equals("-")){
                second=stack.pop();
                first=stack.pop();
                result=first-second;
                stack.push(result);
            }else if(c.equals("*")){
                second=stack.pop();
                first=stack.pop();
                result=first*second;
                stack.push(result);
            }else if(c.equals("/")){
                second=stack.pop();
                first=stack.pop();
                result=first/second;
                stack.push(result);
            }else{//遇到数字，进栈
                result=Integer.parseInt(c);
                stack.push(result);
            }
        }
        //获得最终结果
        return stack.pop();
    }
}
