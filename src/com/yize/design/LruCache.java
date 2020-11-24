package com.yize.design;

import java.util.HashMap;
import java.util.Map;

/**
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 *  
 *
 * 进阶:
 *
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lru-cache
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LruCache {
    private class Node{
        public Node prev;
        public Node next;
        public int key;
        public int val;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private class DoubleList{
        private Node head;
        private Node tail;
        private int size;

        public DoubleList(){
            head=new Node(0,0);
            tail=new Node(0,0);
            head.prev=tail;
            head.next=tail;
            tail.next=head;
            tail.prev=head;
            size=0;
        }

        private Node remove(Node node){
            node.prev.next=node.next;
            node.next.prev=node.prev;
            size--;
            return node;
        }
        public Node removeLast(){
            if(size==0){
                return null;
            }
            return remove(tail.prev);
        }

        public void addFirst(Node node){
            node.prev=head;
            node.next=head.next;
            head.next.prev=node;
            head.next=node;
            size++;
        }

        public int size(){
            return size;
        }

    }

    private Map<Integer,Node> map;
    private DoubleList cache;
    private int cap;

    public LruCache(int cap) {
        this.cap = cap;
        map=new HashMap<>();
        cache=new DoubleList();
    }

    public int get(int key){
        if(!map.containsKey(key)){
            return -1;
        }
        int val=map.get(key).val;
        put(key,val);
        return val;
    }

    public void put(int key,int val){
        Node node=new Node(key,val);
        if(map.containsKey(key)){
            cache.addFirst(cache.removeLast());
            map.put(key,node);
        }else {
            if(cap==cache.size()){
                map.remove(cache.removeLast().key);
            }
            cache.addFirst(node);
            map.put(key,node);
        }
    }
}
