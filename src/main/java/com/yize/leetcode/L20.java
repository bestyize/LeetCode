package com.yize.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class L20 {
    @Test
    public void test(){
        System.out.println(isValid("]"));
    }

    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<Character>();
        Map<Character,Character> map=new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='('||c=='{'||c=='['){
                stack.push(c);
            }else{
                if(stack.isEmpty()==false&&map.get(stack.peek())==c){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
