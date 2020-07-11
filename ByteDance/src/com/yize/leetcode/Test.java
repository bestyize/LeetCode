package com.yize.leetcode;

public class Test {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String className=this.getClass().getCanonicalName();
                System.out.println(className);
            }
        });
    }
    class Finder{
        private Finder finder;
    }
}
