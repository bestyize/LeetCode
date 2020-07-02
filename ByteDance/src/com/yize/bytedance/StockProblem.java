package com.yize.bytedance;

public class StockProblem {
    /**
     *121. 买卖股票的最佳时机
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     *
     * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
     *
     * 注意：你不能在买入股票前卖出股票。
     *
     *
     *
     * 示例 1:
     *
     * 输入: [7,1,5,3,6,4]
     * 输出: 5
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
     * 示例 2:
     *
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     * @param prices
     * @return
     */
    public int stockProblem1(int[] prices){
        int maxProfit=0;
        int currMin=Integer.MAX_VALUE;
        for (int i=0;i<prices.length;i++){
            currMin=Math.min(prices[i],currMin);
            maxProfit= Math.max(maxProfit,prices[i]-currMin);
        }
        return maxProfit;
    }

    /**
     *给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     *
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     *
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     *  
     *
     * 示例 1:
     *
     * 输入: [7,1,5,3,6,4]
     * 输出: 7
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
     * 示例 2:
     *
     * 输入: [1,2,3,4,5]
     * 输出: 4
     * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
     *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
     * 示例 3:
     *
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     *  
     *
     * 提示：
     *
     * 1 <= prices.length <= 3 * 10 ^ 4
     * 0 <= prices[i] <= 10 ^ 4
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * 解题思路：一盈利就卖出
     * @param prices
     * @return
     */
    public int stockProblem2(int[] prices){
        int maxProfit=0;
        for (int i=1;i<prices.length;i++){
            if(prices[i]-prices[i-1]>0){
                maxProfit+=prices[i]-prices[i-1];
            }
        }
        return maxProfit;
    }

    /**
     *123. 买卖股票的最佳时机 III
     * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
     *
     * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
     *
     * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     * 示例 1:
     *
     * 输入: [3,3,5,0,0,3,1,4]
     * 输出: 6
     * 解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
     *      随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
     * 示例 2:
     *
     * 输入: [1,2,3,4,5]
     * 输出: 4
     * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
     *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
     * 示例 3:
     *
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
     * 解题思路：单调栈
     * @param prices
     * @return
     */
    public int stockProblem3(int[] prices){
        int left[]=new int[prices.length];
        int leftMin=Integer.MAX_VALUE;
        int leftMaxProfit=0;
        for (int i=0;i<prices.length;i++){
            leftMin=Math.min(leftMin,prices[i]);
            leftMaxProfit=Math.max(leftMaxProfit,prices[i]-leftMin);
            left[i]=leftMaxProfit;
        }

        int right[]=new int[prices.length];
        int rightMax=Integer.MIN_VALUE;
        int rightMaxProfit=0;
        for (int i=prices.length-1;i>=0;i--){
            rightMax=Math.max(rightMax,prices[i]);
            rightMaxProfit=Math.max(rightMaxProfit,rightMax-prices[i]);
            right[i]=rightMaxProfit;
        }
        int maxProfit=0;
        for (int i=0;i<prices.length;i++){
            maxProfit=Math.max(maxProfit,left[i]+right[i]);
        }
        return maxProfit;
    }
}
