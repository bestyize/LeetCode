package com.yize.tencent;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 小Q在进行一场竞技游戏,这场游戏的胜负关键就在于能否能争夺一条长度为L的河道,即可以看作是[0,L]的一条数轴。
 * 这款竞技游戏当中有n个可以提供视野的道具−真视守卫,第i个真视守卫能够覆盖区间[xi,yi]。现在小Q想知道至少用几个真视守卫就可以覆盖整段河道。
 *
 * 输入描述:
 *
 * 输入包括n+1行。
 *
 * 第一行包括两个正整数n和L(1<=n<=105,1<=L<=109)
 *
 * 接下来的n行,每行两个正整数xi,yi(0<=xi<=yi<=109),表示第i个真视守卫覆盖的区间。
 *
 * 输出描述:
 *
 * 一个整数，表示最少需要的真视守卫数量, 如果无解, 输出-1。
 *
 * 示例1
 * 输入
 *
 * 4 6
 * 3 6
 * 2 4
 * 0 2
 * 4 7
 *
 * 输出
 *
 * 3
 * 这道题考察的是贪心算法，首先将“真视守卫”按照左端从小到大，右端从大到小排列，设置两个变量，up更新的下限和mx本次视野的最右端，每次操作“真视守卫”时，将其最右端和up比较，如果小于等于则更新mx，反之更新up再将该真视守卫”进行比较操作
 * ————————————————
 * 版权声明：本文为CSDN博主「独酌101112」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/weixin_43353524/article/details/105182937
 *
 */
public class VersionCatch {
    public static void main(String[] args) {
        int[][] covers={
                {0,2},
                {4,6},
                {3,6},
                {2,4},
                {0,2},
                {4,7},
                {5,9},
                {5,10}
        };
        System.out.println(merge(covers));
    }

    public static int merge(int[][] covers){
        if(covers.length==0){
            return -1;
        }
        Arrays.sort(covers, (o1, o2) -> {
            if(o1[0]!=o2[0]){
                return o1[0]-o2[0];
            }else {
                return o2[0]-o1[0];
            }
        });

        int low=covers[0][0],maxPos=covers[0][1];
        int count=1;
        for (int i=1;i<covers.length;i++){
            if(covers[i][1]>maxPos){
                maxPos=covers[i][1];
                if(covers[i][0]>low){
                    count++;
                }
                low=covers[i][0];
            }
        }
        return count;

    }
}
