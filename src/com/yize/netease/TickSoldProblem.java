package com.yize.netease;

/**
 * 最短的售票时间
 *
 * 解答：https://blog.csdn.net/qq_23594799/article/details/107882361
 */
public class TickSoldProblem {
    public static void main(String[] args) {
        int[] a={3,5,7,6};
        int[] b={6,11,13};
        System.out.println(timeToClose(a,b));

    }

    /**
     * @param a 单独购买的时间
     * @param b 两个人一起买的时间
     * @return
     */
    public static int timeToClose(int[] a,int[] b){
        if (a.length==0||a.length==1){
            return a.length==0?0:a[0];
        }
        int[] dp=new int[a.length];
        dp[0]=a[0];
        dp[1]=Math.min(b[0],a[0]+a[1]);
        int ptr=2;
        while (ptr<a.length){
            //a[ptr]表示单独购买的花费时间，dp[ptr-1]表示从第0个人到第ptr-1个人总共花费的最小时间
            //b[ptr-1]表示第ptr个人和第ptr-1个人一起花费的时间，dp[ptr-2]表示从第0个人到第ptr-2个人总共花费的最小时间
            dp[ptr++]=Math.min(a[ptr]+dp[ptr-1],b[ptr-1]+dp[ptr-2]);
        }
        return dp[dp.length-1];
    }
}
