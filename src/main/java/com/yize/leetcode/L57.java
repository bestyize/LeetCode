package com.yize.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 *
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 *
 * 示例 1:
 *
 * 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出: [[1,5],[6,9]]
 * 示例 2:
 *
 * 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出: [[1,2],[3,10],[12,16]]
 * 解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-interval
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L57 {
    @Test
    public void test(){
        int[][] ii={{1,3},{6,9}};
        int[] insert={2,5};
        int[][] ss=insert(ii,insert);
        System.out.println(ss);
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length==0&&newInterval.length!=0){
            int[][]a=new int[1][2];
            a[0]=newInterval;
            return a;
        }
        int add=0;
        if(newInterval.length!=0){
            add=1;
        }
        int[][] nee=new int[intervals.length+add][intervals[0].length];
        for(int i=0;i<intervals.length;i++){
            nee[i]=intervals[i];
        }
        if(newInterval.length!=0){
            nee[nee.length-1]=newInterval;
        }
        Arrays.sort(nee,(o1,o2)->o1[0]-o2[0]);
        ArrayList<int[]> list=new ArrayList<>();
        for(int i=0;i<nee.length;i++){
            if(list.size()==0||list.get(list.size()-1)[1]<nee[i][0]){
                list.add(nee[i]);
            }else{
                list.get(list.size()-1)[1]=Math.max(nee[i][1],list.get(list.size()-1)[1]);
            }
        }
        return list.toArray(new int[0][0]);
    }
}
