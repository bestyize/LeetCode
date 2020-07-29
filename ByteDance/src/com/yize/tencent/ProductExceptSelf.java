package com.yize.tencent;

/**
 * 除了本身之外的乘积
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。（注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
 * 对于A长度为1的情况，B无意义，故而无法构建，因此该情况不会存在。
 */
public class ProductExceptSelf {
    public int[] multiply(int[] nums) {
        int left[]=new int[nums.length];
        left[0]=1;
        for (int i=1;i< nums.length;i++){
            left[i]=left[i-1]*nums[i-1];
        }

        int right[]=new int[nums.length];
        right[right.length-1]=1;
        for (int i= right.length-2;i>=0;i--){
            right[i]=right[i+1]*nums[i+1];
        }
        int [] result=new int[nums.length];
        for (int i=0;i< result.length;i++){
            result[i]=left[i]* right[i];
        }
        return result;

    }
}
