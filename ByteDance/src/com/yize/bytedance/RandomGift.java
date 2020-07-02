package com.yize.bytedance;

import org.junit.Test;

import java.util.*;


public class RandomGift {
    @Test
    public void test(){
        List<Info> infoList=buildInfoList();
        System.out.println(infoList);
        List<Info> changedList=randomGift(infoList);
        System.out.println(changedList);
    }

    class Info{
        int person;
        int gift;
        public Info(int person, int gift) {
            this.person = person;
            this.gift = gift;
        }

        @Override
        public String toString() {
            return "Info{" +
                    "person='" + person + '\'' +
                    ", gift='" + gift + '\'' +
                    '}';
        }
    }
    /**
     * 解题思路：维护两个链表，每次选定链表头，移除链表头后从链表里面随机选择一个节点交换数据，
     * 然后把刚才选定的链表放到另一个连表里
     * @param infoList
     * @return
     */
    public List<Info> randomGift(List<Info> infoList){

        List<Info> changedList=new ArrayList<>();
        Random ran=new Random();
        while (infoList.size()>1){
            Info readyInfo=infoList.get(0);
            infoList.remove(0);
            int pos=ran.nextInt(infoList.size());
            Info randomInfo=infoList.get(pos);

            int gift=readyInfo.gift;
            readyInfo.gift=randomInfo.gift;
            randomInfo.gift=gift;
            changedList.add(readyInfo);

        }
        changedList.add(infoList.remove(0));
        return changedList;
    }

    public List<Info> buildInfoList(){
        List<Info> infoList=new ArrayList<>();
        for (int i=0;i<100;i++){
            infoList.add(new Info(i,i));
        }
        return infoList;
    }
}
