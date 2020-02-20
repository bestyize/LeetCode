package com.yize.leetcode;

import org.junit.Test;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L42 {
    @Test
    public void test(){
        int[] height={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }

    public int trap(int[] height) {
        return method2(height);
    }

    /**
     * 执行结果：
     * 通过
     * 显示详情
     * 执行用时 :
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 99.98%
     * 的用户
     * 内存消耗 :
     * 37.9 MB
     * , 在所有 Java 提交中击败了
     * 27.70%
     * 的用户
     * @param height
     * @return
     */
    public int method1(int[] height) {
        if(height.length<3){
            return 0;
        }
        int slow=0,quick=1,totalArea=0;
        while (slow<height.length-1){
            while (slow+1<height.length&&height[slow]<=height[slow+1]){//如果slow=slow+1，那么直到找到slow>slow+1的位置
                slow++;
                quick++;
            }
            int subHeight[]=new int[3];
            int tempArea=0;
            while (quick<height.length&&height[slow]>height[quick]){//找到slow<=hight的地方，这段区域构成了一个水池
                tempArea-=height[quick];//这是水池中的障碍物
                //为了防止最后也找不到，就用这个数组记录第二高位置的坐标，高度，以及中间夹的区域大小
                if(height[quick]>subHeight[1]){
                    subHeight[0]=quick;
                    subHeight[1]=height[quick];
                    subHeight[2]=tempArea+height[quick];
                }
                quick++;
            }
            if(quick!=height.length){//如果没有找到最后，则说明有水池
                tempArea+=height[slow]*(quick-slow-1);//计算两个墙壁之间夹的水池大小
                totalArea+=tempArea;//减去水池中的障碍物
                slow=quick;//指针向前推进
                quick=quick+1;
            }else {//找到最后发现没有水池
                if(subHeight[0]!=0){
                    int subArea=subHeight[1]*(subHeight[0]-slow-1)+subHeight[2];
                    totalArea+=subArea;
                    slow=subHeight[0];
                }else {
                    slow++;
                }
                quick=slow+1;
            }
        }
        return totalArea;
    }

    /**
     * 找出最高点
     * 分别从两边往最高点遍历：如果下一个数比当前数小，说明可以接到水
     * @param height
     * @return
     */
    public int method2(int[] height){
        if(height.length<3){
            return 0;
        }
        int maxIndex=0;
        int maxVal=height[maxIndex];
        for(int i=1;i<height.length;i++){
            if(maxVal<height[i]){
                maxVal=height[i];
                maxIndex=i;
            }
        }
        int area=0;
        int tempMax=height[0];
        for (int i=1;i<maxIndex;i++){
            if(tempMax<height[i]){
                tempMax=height[i];
            }else {
                area=area+(tempMax-height[i]);
            }
        }
        tempMax=height[height.length-1];
        for(int i=height.length-1;i>maxIndex;i--){
            if(tempMax<height[i]){
                tempMax=height[i];
            }else {
                area=area+(tempMax-height[i]);
            }
        }
        return area;
    }

    public int method3(int[] height){
        if(height.length<3){
            return -1;
        }
        int maxIndex=0,maxVal=height[maxIndex];
        for(int i=0;i<height.length;i++){
            if(height[i]>maxVal){
                maxVal=height[i];
                maxIndex=i;
            }
        }
        int area=0;
        int ptrLeft=0,ptrRight=height.length-1,leftMax=height[ptrLeft],rightMax=height[ptrRight];
        while (ptrLeft<maxIndex){
            if(height[ptrLeft]>leftMax){
                leftMax=height[ptrLeft];
            }else {
                area+=(leftMax-height[ptrLeft]);
            }
            ptrLeft++;
        }
        while (ptrRight>maxIndex){
            if(height[ptrRight]>rightMax){
                rightMax=height[ptrRight];
            }else {
                area+=(rightMax-height[ptrRight]);
            }
            ptrRight++;
        }
        return area;
    }


}
