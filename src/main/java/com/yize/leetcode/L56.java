package com.yize.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0]-o2[0]);
        ArrayList<int[]> newIntList=new ArrayList<>();
        for(int i=0;i<intervals.length;i++){
            if(newIntList.isEmpty()||newIntList.get(newIntList.size()-1)[1]<intervals[i][0]){
                newIntList.add(intervals[i]);
            }else {
                newIntList.get(newIntList.size()-1)[1]=Math.max(newIntList.get(newIntList.size()-1)[1],intervals[i][1]);
            }
        }
        return newIntList.toArray(new int[0][0]);

    }
}
