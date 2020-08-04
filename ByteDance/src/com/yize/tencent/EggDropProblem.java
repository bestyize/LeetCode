package com.yize.tencent;

import org.junit.Test;

/**
 * 一幢 100 层的大楼,给你两个鸡蛋. 如果在第 n 层扔下鸡蛋,鸡蛋不碎,那么从前 n-1 层扔鸡蛋都不碎.
 * 这两只鸡蛋一模一样,不碎的话可以扔无数次. 已知鸡蛋在0层扔不会碎.
 * 提出一个策略, 要保证能测出鸡蛋恰好不会碎的楼层, 并使此策略在最坏情况下所扔次数最少.
 * 参考文献：https://blog.csdn.net/lonelyrains/article/details/46428569
 *
 *
 * 假设到代数：如果第一枚鸡蛋扔下去的层数为i，则碎了的情况，需要扔的总次数最糟糕的情况是1 + ( i - 1 )；
 * 如果没碎，剩下的两个鸡蛋都在，需要扔的次数一定为1 + 用两枚鸡蛋来解决剩下的100 - i层的次数（这个问题跟原题是一样的，但是层数少了一些）。
 * 也就是 如果用f ( 100 )表示100层的最坏情况下的最少次数，那么从第i层扔鸡蛋的最糟糕的试验次数是 1+ Max( i - 1, f ( 100 - i ) )，
 * Max表示这两者之间的最大值，是最最糟糕的情况了。  而 f ( 100 ) 就是对所有从1到100的所有i里， 1+ Max( i - 1, f ( 100 - i ) )的值最小的那个。
 *
 */
public class EggDropProblem {
    @Test
    public void test(){
        System.out.println(tryDropEgg(1000));
    }

//    /**
//     * 暴力解法：递归超时
//      * @param layer
//     * @return
//     */
//    public int tryDropEgg(int layer){
//        if(layer<2){
//            return layer;
//        }
//        int miniStep=layer;
//        for (int i=1;i<=layer;i++){
//            //鸡蛋碎了，那只能从1试到i-1,鸡蛋没碎，还剩两个鸡蛋，那么对i到layer用这两个鸡蛋模拟，也就是再做递归
//            miniStep=Math.min(miniStep,1+Math.max(i-1,tryDropEgg(layer-i)));
//        }
//        return miniStep;
//    }

    /**
     * Hash表优化方式,避免重复计算
     * @param layer
     * @return
     */
    public int tryDropEgg(int layer){
        if(layer<2){
            return layer;
        }
        int[] map=new int[layer];
        return tryDropEgg(layer,map);
    }

    public int tryDropEgg(int layer,int[] map){
        int miniStep=layer;
        for (int i=1;i<=layer;i++){
            if(map[layer-i]==0){
                map[layer-i]=tryDropEgg(layer-i,map);
            }
            miniStep=Math.min(miniStep,1+Math.max(i-1,map[layer-i]));
        }
        return miniStep;
    }
}
