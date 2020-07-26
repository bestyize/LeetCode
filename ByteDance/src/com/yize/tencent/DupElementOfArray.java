package com.yize.tencent;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class DupElementOfArray {
    public List<Integer> dupElementOfArray(int[] nums){
        List<Integer> result=new LinkedList<>();
        Set<Integer> set=new HashSet<>();
        for (int i:nums){
            if(!set.contains(i)){
                result.add(i);
            }
            set.add(i);
        }
        return result;
    }
}
